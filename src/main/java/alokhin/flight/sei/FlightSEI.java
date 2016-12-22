package alokhin.flight.sei;

import alokhin.flight.entities.Directories.City;
import alokhin.flight.entities.Directories.Place;
import alokhin.flight.entities.Objects.Flight;
import alokhin.flight.entities.Objects.Passenger;
import alokhin.flight.entities.Objects.Reservation;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

@WebService(name = "FlightWS")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface FlightSEI {

    Reservation checkReservationByCode(@WebParam(name = "code") String code);

    ArrayList<Reservation> checkReservationByDocumentNumber(@WebParam(name = "documentNumber") String documentNumber);

    ArrayList<Reservation> checkReservationByDateReserv(@WebParam(name = "date") Long date, @WebParam(name = "interval") Integer interval);

    ArrayList<Reservation> checkReservationByFamilyName(@WebParam(name = "familyName") String familyName);

    ArrayList<Flight> searchFlight(@WebParam(name = "date") Long date, @WebParam(name = "cityFrom") City cityFrom, @WebParam(name = "cityTo") City cityTo, @WebParam(name = "interval") Integer interval);

    ArrayList<City> getAllCities();

    ArrayList<Place> getPlacesBusy(@WebParam(name = "aircraft_id") Long aircraft_id, @WebParam(name = "flight_id") Long flight_id);

    ArrayList<Place> getFreePlaces(@WebParam(name = "aircraft_id") Long aircraft_id, @WebParam(name = "flight_id") Long flight_id);

    Integer buyTicket(@WebParam(name = "flight") Flight flight, @WebParam(name = "place") Place place, @WebParam(name = "passenger") Passenger passenger, @WebParam(name = "addInfo") String addInfo);
}
