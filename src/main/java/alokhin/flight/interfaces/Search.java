package alokhin.flight.interfaces;

import alokhin.flight.entities.Directories.City;
import alokhin.flight.entities.Objects.Flight;

import java.util.Date;
import java.util.List;

/**
 * Created by ExeKiller on 15.11.2016.
 */
public interface Search {
    List<Flight> searchFlight(Date date, City cityFrom, City cityTo, int placeCount);
}
