package alokhin.flight.main;

import alokhin.flight.entities.Directories.Aircraft;
import alokhin.flight.entities.Directories.City;
import alokhin.flight.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

/**
 * Created by ExeKiller on 15.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        System.out.println(session);
        ArrayList<Aircraft> aircrafts = (ArrayList<Aircraft>) session.createCriteria(Aircraft.class).list();

        for(Aircraft a : aircrafts) {
            System.out.println("--------------------");
            System.out.println("Id - " + a.getId());
            System.out.println("Name - " + a.getName());
            System.out.println("Company name - " + a.getCompany().getName());
            System.out.println("Desc - " + a.getDesc());
            System.out.println("--------------------");
        }
        session.close();
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        System.out.println(session);
        ArrayList<City> cities = (ArrayList<City>) session2.createCriteria(City.class).list();

        for(City c : cities) {
            System.out.println("--------------------");
            System.out.println("Id - " + c.getId());
            System.out.println("Name - " + c.getName());
            System.out.println("--------------------");
        }
        session2.close();
    }
}
