package alokhin.flight.interfaces;

import alokhin.flight.entities.Objects.Reservation;

import java.util.ArrayList;

public interface Check {

    Reservation checkReservationByCode(String code);

    ArrayList<Reservation> checkReservationByDocumentNumber(String documentNumber);

    ArrayList<Reservation> checkReservationByDateReserv(Long date);

    ArrayList<Reservation> checkReservationByFamilyName(String familyName);

}
