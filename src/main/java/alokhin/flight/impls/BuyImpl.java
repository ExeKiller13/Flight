package alokhin.flight.impls;

import alokhin.flight.database.DataHelper;
import alokhin.flight.entities.Directories.Place;
import alokhin.flight.entities.Objects.Flight;
import alokhin.flight.entities.Objects.Passenger;
import alokhin.flight.entities.Objects.Reservation;
import alokhin.flight.interfaces.Buy;
import alokhin.flight.utils.GMTCalendar;

import javax.jws.WebService;
import java.util.List;
import java.util.UUID;

public class BuyImpl implements Buy {

    public Boolean buyTicket(Flight flight, Place place, Passenger passenger, String addInfo) {

        try {
            List places = DataHelper.getInstance().getPlacesBusy(flight.getAircraft().getId(), flight.getId());

            for(Object o : places) {

                Place p = (Place) o;

                if(p.getId().equals(place.getId()) && p.getBusy()) {
                    throw new Exception("Place is busy.");
                }
            }

            if(DataHelper.getInstance().getPassengerById(passenger.getId()) == null) {
                DataHelper.getInstance().insertPassenger(passenger);
            }

            Reservation reservation = new Reservation();
            reservation.setFlight(flight);
            reservation.setPlace(place);
            reservation.setPassenger(passenger);
            reservation.setAddInfo(addInfo);
            reservation.setCode(UUID.randomUUID().toString());
            reservation.setReserveDatetime(GMTCalendar.getInstance());

            DataHelper.getInstance().insertReservation(reservation);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataHelper.closeTransaction();
        }

        return false;
    }

}
