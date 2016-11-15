package alokhin.flight.entities.Objects;

import alokhin.flight.entities.Directories.Aircraft;
import alokhin.flight.entities.Directories.City;

import java.util.Calendar;

public class Flight {
    private Long id;
    private String code;
    private Calendar flightDate;
    private Calendar flightTime;
    private Aircraft aircraft;
    private Long duration;
    private City cityFrom;
    private City cityTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Calendar getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Calendar flightDate) {
        this.flightDate = flightDate;
    }

    public Calendar getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Calendar flightTime) {
        this.flightTime = flightTime;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (id.equals(flight.id)) return false;
        if (flightDate.equals(flight.flightDate)) return false;
        if (flightTime.equals(flight.flightTime)) return false;
        if (!aircraft.equals(flight.aircraft)) return false;
        if (duration.equals(flight.duration)) return false;
        if (cityFrom.equals(flight.cityFrom)) return false;
        if (cityTo.equals(flight.cityTo)) return false;
        if (code != null ? !code.equals(flight.code) : flight.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (flightDate.hashCode());
        result = 31 * result + (flightTime.hashCode());
        result = 31 * result + (aircraft.hashCode());
        result = 31 * result + (duration.hashCode());
        result = 31 * result + (cityFrom.hashCode());
        result = 31 * result + (cityTo.hashCode());
        return result;
    }
}
