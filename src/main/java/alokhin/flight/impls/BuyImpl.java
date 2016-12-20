package alokhin.flight.impls;

import alokhin.flight.database.DataHelper;
import alokhin.flight.entities.Directories.Place;
import alokhin.flight.entities.Objects.Flight;
import alokhin.flight.entities.Objects.Passenger;
import alokhin.flight.entities.Objects.Reservation;
import alokhin.flight.exceptions.DoubleTransactionException;
import alokhin.flight.exceptions.PlaceBusyException;
import alokhin.flight.interfaces.Buy;
import alokhin.flight.utils.GMTCalendar;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BuyImpl implements Buy {

    public Integer buyTicket(Flight flight, Place place, Passenger passenger, String addInfo) {

        try {
            List places = DataHelper.getInstance().getPlacesBusy(flight.getAircraft().getId(), flight.getId());

            for (Object o : places) {

                Place p = (Place) o;

                if (p.getId().equals(place.getId()) && p.getBusy()) {
                    throw new PlaceBusyException("Place is busy.");
                }
            }

            if (DataHelper.getInstance().getPassengerById(passenger.getId()) == null) {
                passenger = DataHelper.getInstance().insertPassenger(passenger);
            }

            Reservation reservation = new Reservation();
            reservation.setFlight(flight);
            reservation.setPlace(place);
            reservation.setPassenger(passenger);
            reservation.setAddInfo(addInfo);
            reservation.setCode(UUID.randomUUID().toString());
            reservation.setReserveDatetime(GMTCalendar.getInstance());

            ArrayList<Reservation> reservations_by_passenger = (ArrayList<Reservation>) DataHelper.getInstance().getReservationsByDocumentNumber(passenger.getDocumentNumber());
            for (Reservation r : reservations_by_passenger) {
                if (r.getFlight().getId().equals(flight.getId())) {
                    throw new DoubleTransactionException("Transaction failure. This passenger reserved this ticket recently.");
                }
            }

            DataHelper.getInstance().insertReservation(reservation);

            return 0;

        } catch (DoubleTransactionException dte) {
            dte.printStackTrace();
            return 1; // Double Transaction Exception
        } catch (PlaceBusyException pbe) {
            pbe.printStackTrace();
            return 2; // Place Pusy Exception
        } finally {
            DataHelper.closeTransaction();
        }
    }

}
