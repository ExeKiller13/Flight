package alokhin.flight.database;

import alokhin.flight.entities.Directories.*;
import alokhin.flight.entities.Objects.*;
import alokhin.flight.utils.GMTCalendar;
import alokhin.flight.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class DataHelper {
    private static DataHelper dataHelper;

    private static SessionFactory sessionFactory = null;
    private static DetachedCriteria currentCriteria;

    public static final int INTERVAL = 1;

    private DataHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static DataHelper getInstance() {
        if(dataHelper == null) {
            DataHelper dataHelper = new DataHelper();
            getSession().beginTransaction();
            return dataHelper;
        }
        else
            return dataHelper;
    }

    private static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public static void closeTransaction() {
        getSession().getTransaction().commit();
    }

    public List getAllAircrafts() {
        return getSession().createCriteria(Aircraft.class).list();
    }

    public Aircraft getAircraftById(Long id) {
        return (Aircraft) getSession().createCriteria(Aircraft.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    public List getAllCities() {
        return getSession().createCriteria(City.class).list();
    }

    public City getCityById(Long id) {
        return (City) getSession().createCriteria(City.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    public City getCityByName(String name) {
        return (City) getSession().createCriteria(City.class).add(Restrictions.eq("name", name)).uniqueResult();
    }

    public List getAllCompanies() {
        return getSession().createCriteria(Company.class).list();
    }

    public Company getCompanyById(Long id) {
        return (Company) getSession().createCriteria(Company.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    public List getAllCountries() {
        return getSession().createCriteria(Country.class).list();
    }

    public Country getCountryById(Long id) {
        return (Country) getSession().createCriteria(Country.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    public List getAllFlightClasses() {
        return getSession().createCriteria(FlightClass.class).list();
    }

    public FlightClass getFlightClassById(Long id) {
        return (FlightClass) getSession().createCriteria(FlightClass.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    public List getAllPlaces() {
        return getSession().createCriteria(Place.class).list();
    }

    public Place getPlaceById(Long id) {
        return (Place) getSession().createCriteria(Place.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    public List getPlacesByFlightClassId(Long id) {
        return getSession().createCriteria(Place.class).add(Restrictions.eq("flightClass.id", id)).list();
    }

    public List getPlacesByAircraftId(long id) {
        List aircraftPlaces = getSession()
                .createCriteria(AircraftPlace.class)
                .add(Restrictions.eq("aircraft.id", id))
                .list();

        List places_id = new ArrayList<Long>();
        for(Object o : aircraftPlaces) {
            AircraftPlace aircraftPlace = (AircraftPlace) o;
            places_id.add(aircraftPlace.getPlace().getId());
        }


        return  getSession()
                .createCriteria(Place.class)
                .add(Restrictions.in("id",places_id))
                .addOrder(Order.asc("flightClass.id"))
                .addOrder(Order.asc("row")).list();
    }


    public List getAllFlights() {
        return getSession().createCriteria(Flight.class).list();
    }

    public Flight getFlightById(Long id) {
        return (Flight) getSession().createCriteria(Flight.class).add(Restrictions.eq("id", id)).uniqueResult();
    }


    public List getFlight(Long dateTime, City cityFrom, City cityTo) {

        Calendar searchDate = GMTCalendar.getInstance();
        searchDate.setTimeInMillis(dateTime);
        GMTCalendar.clearTime(searchDate);

        Calendar dateTimeInterval = (Calendar)(searchDate.clone());
        dateTimeInterval.add(Calendar.DATE, INTERVAL);

        GMTCalendar.print(searchDate);
        GMTCalendar.print(dateTimeInterval);

        return getSession().createCriteria(Flight.class)
                .add(Restrictions.and(Restrictions.ge("dateDepart", searchDate.getTimeInMillis()), Restrictions.lt("dateCome", dateTimeInterval.getTimeInMillis())))
                .add(Restrictions.eq("cityFrom", cityFrom))
                .add(Restrictions.eq("cityTo", cityTo))
                .list();
    }

    public List getAllPassengers() {
        return getSession().createCriteria(Passenger.class).list();
    }

    public Passenger getPassengerById(Long id) {
        return (Passenger) getSession().createCriteria(Passenger.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    public void insertPassenger(Passenger passenger) {
        getSession().save(passenger);
    }

    public List getAllReservations() {
        return getSession().createCriteria(Reservation.class).list();
    }

    public Reservation getReservationById(Long id) {
        return (Reservation) getSession().createCriteria(Reservation.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    public void insertReservation(Reservation reservation) {
        getSession().save(reservation);
    }

    public List getReservationsByFamilyName(String familyName) {
        return  getSession().createCriteria(Reservation.class).
                createCriteria("passenger").
                add(Restrictions.eq("familyName", familyName)).
                list();
    }

    public Reservation getReservationByCode(String code) {
        return (Reservation) getSession().createCriteria(Reservation.class).add(Restrictions.eq("code", code)).uniqueResult();
    }

    public List getReservationsByDate(Long date) {
        Calendar reservationDate = GMTCalendar.getInstance();
        reservationDate.setTimeInMillis(date);
        GMTCalendar.clearTime(reservationDate);
        Calendar dateTimeInterval = (Calendar) (reservationDate.clone());
        dateTimeInterval.add(Calendar.DATE, INTERVAL);

        return getSession().createCriteria(Reservation.class).add(
                Restrictions.and(
                        Restrictions.ge("reserveDatetime", reservationDate.getTimeInMillis()),
                        Restrictions.lt("reserveDatetime", dateTimeInterval.getTimeInMillis())
                )
        ).list();
    }

    public List getReservationsByDocumentNumber(String documentNumber) {
        return  getSession().createCriteria(Reservation.class).
                createCriteria("passenger").
                add(Restrictions.eq("documentNumber", documentNumber)).
                list();
    }

    public List getPlacesBusy(Long aircraft_id, Long flight_id) {
        List result = new ArrayList();

        String q = "select p.id, p.row, p.seat,p.flightClass.id, " +
            "case when ((select r.id from Reservation r where r.flight.id=" + flight_id + " and r.place.id=p.id)>0) then 1 else 0 end as busy " +
            "from Place p where id in (select place.id from AircraftPlace a1 where a1.aircraft.id=" + aircraft_id + ") order by flightClass.id, row";
        Query query = getSession().createQuery(q);
        List list = query.list();

        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            Object[] objects = (Object[]) iterator.next();

            Place place = new Place();

            place.setId(Long.parseLong(String.valueOf(objects[0]))); // id
            place.setRow(String.valueOf(objects[1])); // row
            place.setSeat((Integer) objects[2]); // seat

            Long flightClassId = (Long) objects[3];
            place.setFlightClass(getFlightClassById(flightClassId)); // flightClass

            place.setBusy((Integer) objects[4]); // busy

            result.add(place);
        }
        return result;
    }

}
