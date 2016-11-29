package alokhin.flight.main;

import alokhin.flight.database.DataHelper;
import alokhin.flight.entities.Directories.Aircraft;
import alokhin.flight.entities.Directories.Place;
import alokhin.flight.entities.Objects.Flight;
import alokhin.flight.entities.Objects.Passenger;
import alokhin.flight.entities.Objects.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println();

        List list = DataHelper.getInstance().getPlacesBusy(1L, 4L);

        for(Object o : list) {
            Place p = (Place) o;
            System.out.println(p.getId());
            System.out.println(p.getRow());
            System.out.println(p.getSeat());
            System.out.println(p.getFlightClass());
            System.out.println(p.getBusy());
            System.out.println("-----------");
        }

        DataHelper.closeTransaction();

    }
}
