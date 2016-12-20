package alokhin.flight.impls;

import alokhin.flight.database.DataHelper;
import alokhin.flight.entities.Directories.City;
import alokhin.flight.entities.Directories.Place;
import alokhin.flight.entities.Objects.Flight;
import alokhin.flight.interfaces.Search;
import alokhin.flight.utils.GMTCalendar;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SearchImpl implements Search {

    public ArrayList<Flight> searchFlight(Long date, City cityFrom, City cityTo, Integer interval) {

        try {
            ArrayList<Flight> list = new ArrayList<Flight>();

            Calendar c = GMTCalendar.getInstance();
            c.setTimeInMillis(date);

            list.addAll(DataHelper.getInstance().getFlight(date, cityFrom, cityTo, interval));

            return list;
        } finally {
            DataHelper.closeTransaction();
        }
    }

    public ArrayList<City> getAllCities() {
        try {
            return (ArrayList<City>) DataHelper.getInstance().getAllCities();
        } finally {
            DataHelper.closeTransaction();
        }
    }

    public ArrayList<Place> getPlacesBusy(Long aircraft_id, Long flight_id) {
        try {
            return (ArrayList<Place>) DataHelper.getInstance().getPlacesBusy(aircraft_id, flight_id);
        } finally {

            DataHelper.closeTransaction();
        }
    }

    public ArrayList<Place> getFreePlaces(Long aircraft_id, Long flight_id) {
        ArrayList<Place> places = getPlacesBusy(aircraft_id, flight_id);

        ArrayList<Place> freePlaces = new ArrayList<Place>();

        for (Place place : places) {
            if (!place.getBusy()) {
                freePlaces.add(place);
            }
        }

        return freePlaces;
    }

}
