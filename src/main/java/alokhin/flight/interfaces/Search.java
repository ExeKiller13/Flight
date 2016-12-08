package alokhin.flight.interfaces;

import alokhin.flight.entities.Directories.City;
import alokhin.flight.entities.Objects.Flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface Search {

    ArrayList<Flight> searchFlight(Long date, City cityFrom, City cityTo);

    ArrayList<City> getAllCities();
}
