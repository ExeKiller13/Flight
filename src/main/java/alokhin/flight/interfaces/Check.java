package alokhin.flight.interfaces;

import alokhin.flight.entities.Objects.Reservation;

/**
 * Created by ExeKiller on 15.11.2016.
 */
public interface Check {
    Reservation checkReservation(String code);
}
