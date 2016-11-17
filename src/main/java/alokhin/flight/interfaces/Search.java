package alokhin.flight.interfaces;

import alokhin.flight.entities.Directories.City;
import alokhin.flight.entities.Objects.Flight;

import java.util.Date;
import java.util.List;

public interface Search {
    List<Flight> searchFlight(Date date, City cityFrom, City cityTo, int placeCount);
}
