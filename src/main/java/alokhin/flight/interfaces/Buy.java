package alokhin.flight.interfaces;

import alokhin.flight.entities.Directories.Place;
import alokhin.flight.entities.Objects.Flight;
import alokhin.flight.entities.Objects.Reservation;

public interface Buy {
    Reservation buyTicket(Flight flight, Place place, String addInfo);
}
