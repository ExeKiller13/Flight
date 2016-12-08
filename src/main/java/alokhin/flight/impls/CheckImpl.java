package alokhin.flight.impls;

import alokhin.flight.database.DataHelper;
import alokhin.flight.entities.Objects.Reservation;
import alokhin.flight.interfaces.Check;

import java.util.ArrayList;

public class CheckImpl implements Check {

    public Reservation checkReservationByCode(String code) {
        Reservation reservation = null;
        try {
            reservation = DataHelper.getInstance().getReservationByCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataHelper.closeTransaction();
        }
        return reservation;
    }

    public ArrayList<Reservation> checkReservationByDocumentNumber(String documentNumber) {
        ArrayList<Reservation> reservations = null;
        try {
            reservations = (ArrayList<Reservation>) DataHelper.getInstance().getReservationsByDocumentNumber(documentNumber);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataHelper.closeTransaction();
        }
        return reservations;
    }

    public ArrayList<Reservation> checkReservationByDateReserv(Long date) {
        ArrayList<Reservation> reservations = null;
        try {
            reservations = (ArrayList<Reservation>) DataHelper.getInstance().getReservationsByDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataHelper.closeTransaction();
        }
        return reservations;
    }

    public ArrayList<Reservation> checkReservationByFamilyName(String familyName) {
        ArrayList<Reservation> reservations = null;
        try {
            reservations = (ArrayList<Reservation>) DataHelper.getInstance().getReservationsByFamilyName(familyName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataHelper.closeTransaction();
        }
        return reservations;
    }

}
