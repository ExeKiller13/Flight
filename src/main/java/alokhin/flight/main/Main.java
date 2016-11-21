package alokhin.flight.main;

import alokhin.flight.database.DataHelper;
import alokhin.flight.entities.Directories.Aircraft;
import alokhin.flight.entities.Directories.Place;
import alokhin.flight.entities.Objects.Flight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        ArrayList<Aircraft> aircrafts = (ArrayList<Aircraft>) DataHelper.getInstance().getAllAircrafts();
        for(Aircraft a : aircrafts) {
            System.out.println("--------------------");
            System.out.println("Id - " + a.getId());
            System.out.println("Name - " + a.getName());
            System.out.println("Company name - " + a.getCompany().getName());
            System.out.println("Desc - " + a.getDesc());
            System.out.println("--------------------");
        }

        ArrayList<Place> places = (ArrayList<Place>) DataHelper.getInstance().getPlacesByAircraftId(2);
        for(Place p : places) {
            System.out.println("--------------------");
            System.out.println("Id - " + p.getId());
            System.out.println("Row - " + p.getRow());
            System.out.println("Seat - " + p.getSeat());
            System.out.println("--------------------");
        }

//        System.out.println(DataHelper.getInstance().getAllFlights());

        ArrayList<Flight> arrayList = (ArrayList<Flight>) DataHelper.getInstance().getFlight(1479591900000L,
                DataHelper.getInstance().getCityById(1L),
                DataHelper.getInstance().getCityById(2L));
//        System.out.println("Dur 2 - " + ((ArrayList<Flight>) DataHelper.getInstance().getFlight(1479741300000L,
//                DataHelper.getInstance().getCityById(3L),
//                DataHelper.getInstance().getCityById(2L))).get(0).getDuration());

//        System.out.println(DataHelper.getInstance().getAllCities());
        DataHelper.closeTransaction();

    }
}
