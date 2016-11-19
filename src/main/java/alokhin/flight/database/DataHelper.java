package alokhin.flight.database;

import alokhin.flight.entities.Directories.*;
import alokhin.flight.entities.Objects.*;
import alokhin.flight.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    private static DataHelper dataHelper;

    private static SessionFactory sessionFactory = null;
    private static DetachedCriteria currentCriteria;

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
}
