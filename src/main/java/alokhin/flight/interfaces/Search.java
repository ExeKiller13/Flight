package alokhin.flight.interfaces;

import alokhin.flight.entities.Directories.City;
import alokhin.flight.entities.Directories.Place;
import alokhin.flight.entities.Objects.Flight;

import java.util.ArrayList;

public interface Search {

    ArrayList<Flight> searchFlight(Long date, City cityFrom, City cityTo, Integer interval);

    ArrayList<City> getAllCities();

    ArrayList<Place> getPlacesBusy(Long aircraft_id, Long flight_id);

    public ArrayList<Place> getFreePlaces(Long aircraft_id, Long flight_id);
}
