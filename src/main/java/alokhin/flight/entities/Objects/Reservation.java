package alokhin.flight.entities.Objects;

import alokhin.flight.entities.Directories.Place;

import java.util.Calendar;

/**
 * Created by ExeKiller on 14.11.2016.
 */
public class Reservation {
    private Long id;
    private Flight flight;
    private Passenger passenger;
    private Place place;
    private String addInfo;
    private Calendar reserveDatetime;
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public Calendar getReserveDatetime() {
        return reserveDatetime;
    }

    public void setReserveDatetime(Calendar reserveDatetime) {
        this.reserveDatetime = reserveDatetime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (id.equals(that.id)) return false;
        if (flight.equals(that.flight)) return false;
        if (passenger.equals(that.passenger)) return false;
        if (place.equals(that.place)) return false;
        if (reserveDatetime.equals(that.reserveDatetime)) return false;
        if (addInfo != null ? !addInfo.equals(that.addInfo) : that.addInfo != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (flight.hashCode());
        result = 31 * result + (passenger.hashCode());
        result = 31 * result + (place.hashCode());
        result = 31 * result + (addInfo != null ? addInfo.hashCode() : 0);
        result = 31 * result + (reserveDatetime.hashCode());
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}
