package alokhin.flight.impls;

import alokhin.flight.database.DataHelper;
import alokhin.flight.entities.Directories.City;
import alokhin.flight.entities.Objects.Flight;
import alokhin.flight.interfaces.Search;
import alokhin.flight.utils.GMTCalendar;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "FlightService")
public class SearchImpl implements Search {

    public ArrayList<Flight> searchFlight(Long date, City cityFrom, City cityTo) {

        try {
            ArrayList<Flight> list = new ArrayList<Flight>();

            Calendar c = GMTCalendar.getInstance();
            c.setTimeInMillis(date);

            list.addAll(DataHelper.getInstance().getFlight(date, cityFrom, cityTo));

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

}
