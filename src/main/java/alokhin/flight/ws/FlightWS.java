package alokhin.flight.ws;

import alokhin.flight.entities.Directories.City;
import alokhin.flight.entities.Directories.Place;
import alokhin.flight.entities.Objects.Flight;
import alokhin.flight.entities.Objects.Passenger;
import alokhin.flight.entities.Objects.Reservation;
import alokhin.flight.impls.BuyImpl;
import alokhin.flight.impls.CheckImpl;
import alokhin.flight.impls.SearchImpl;
import alokhin.flight.interfaces.Buy;
import alokhin.flight.interfaces.Check;
import alokhin.flight.interfaces.Search;
import alokhin.flight.sei.FlightSEI;

import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;
import java.util.ArrayList;

@MTOM
@WebService (endpointInterface = "alokhin.flight.sei.FlightSEI")
//@HandlerChain(file = "FlightWSHandler.xml")
//@BindingType(SOAPBinding.SOAP12HTTP_MTOM_BINDING)
public class FlightWS implements FlightSEI {

    private Search searchImpl = new SearchImpl();
    private Buy buyImpl = new BuyImpl();
    private Check checkImpl = new CheckImpl();

    public Reservation checkReservationByCode(String code) {
        return checkImpl.checkReservationByCode(code);
    }

    public ArrayList<Reservation> checkReservationByDocumentNumber(String documentNumber) {
        return checkImpl.checkReservationByDocumentNumber(documentNumber);
    }

    public ArrayList<Reservation> checkReservationByDateReserv(Long date, Integer interval) {
        return checkImpl.checkReservationByDateReserv(date, interval);
    }

    public ArrayList<Reservation> checkReservationByFamilyName(String familyName) {
        return checkImpl.checkReservationByFamilyName(familyName);
    }

    public ArrayList<Flight> searchFlight(Long date, City cityFrom, City cityTo, Integer interval) {
        return searchImpl.searchFlight(date, cityFrom, cityTo, interval);
    }

    public ArrayList<City> getAllCities() {
        return searchImpl.getAllCities();
    }

    public ArrayList<Place> getPlacesBusy(Long aircraft_id, Long flight_id) {
        return searchImpl.getPlacesBusy(aircraft_id, flight_id);
    }

    public ArrayList<Place> getFreePlaces(Long aircraft_id, Long flight_id) {
        return searchImpl.getFreePlaces(aircraft_id, flight_id);
    }

    public Integer buyTicket(Flight flight, Place place, Passenger passenger, String addInfo) {
        return buyImpl.buyTicket(flight, place, passenger, addInfo);
    }
}
