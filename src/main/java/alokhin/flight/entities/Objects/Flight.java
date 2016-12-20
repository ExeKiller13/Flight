package alokhin.flight.entities.Objects;

import alokhin.flight.entities.Directories.Aircraft;
import alokhin.flight.entities.Directories.City;

import java.util.Calendar;

public class Flight {
    private String duration;

    private Long id;
    private String code;
    private Long dateDepart;
    private Long dateCome;
    private Aircraft aircraft;
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

    public Long getDateDepart() {
        return dateDepart;
    }

    public Long getDateCome() {
        return dateCome;
    }

    public Calendar getDateDepartCalendar() {
        Calendar dateDepart = Calendar.getInstance();
        dateDepart.setTimeInMillis(this.dateDepart);
        return dateDepart;
    }

    public void setDateDepart(Long dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Calendar getDateComeCalendar() {
        Calendar dateCome = Calendar.getInstance();
        dateCome.setTimeInMillis(this.dateCome);
        return dateCome;
    }

    public void setDateCome(Long dateCome) {
        this.dateCome = dateCome;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
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

    public String getDuration() {
        if (duration == null) {
            fillDuration();
        }
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    private static final String MIN = " min.";
    private static final String HOUR = " hours.  ";
    private static final String DAY = " days.  ";

    private void fillDuration() {

        StringBuilder resultString = new StringBuilder();

        long diff = getDateCome() - getDateDepart();
        int diffmin = (int) (diff / (60 * 1000));

        int num_hours = (diffmin - (diffmin % 60)) / 60;
        int num_minutes = (diffmin % 60);
        int num_days = (num_hours - (num_hours % 24)) / 24;

        num_hours = (num_hours % 24);

        if (num_days > 0) {
            resultString.append(num_days + DAY);
        }
        if (num_hours > 0) {
            resultString.append(num_hours + HOUR);
        }
        if (num_minutes > 0) {
            resultString.append(num_minutes + MIN);
        }

        setDuration(resultString.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (id.equals(flight.id)) return false;
        if (dateDepart.equals(flight.dateDepart)) return false;
        if (dateCome.equals(flight.dateCome)) return false;
        if (aircraft.equals(flight.aircraft)) return false;
        if (cityFrom.equals(flight.cityFrom)) return false;
        if (cityTo.equals(flight.cityTo)) return false;
        if (code != null ? !code.equals(flight.code) : flight.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + dateDepart.hashCode();
        result = 31 * result + dateCome.hashCode();
        result = 31 * result + aircraft.hashCode();
        result = 31 * result + cityFrom.hashCode();
        result = 31 * result + cityTo.hashCode();
        return result;
    }
}
