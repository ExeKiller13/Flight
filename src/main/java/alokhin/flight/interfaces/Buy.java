package alokhin.flight.interfaces;

import alokhin.flight.entities.Directories.Place;
import alokhin.flight.entities.Objects.Flight;
import alokhin.flight.entities.Objects.Passenger;
import alokhin.flight.entities.Objects.Reservation;

public interface Buy {

    Integer buyTicket(Flight flight, Place place, Passenger passenger, String addInfo);

}
