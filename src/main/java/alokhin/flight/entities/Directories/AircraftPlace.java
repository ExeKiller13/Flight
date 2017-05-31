package alokhin.flight.entities.Directories;

public class AircraftPlace {
    private Long id;
    private Aircraft aircraft;
    private Place place;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AircraftPlace that = (AircraftPlace) o;

        if (id.equals(that.id)) {
            return false;
        }
        if (aircraft.equals(that.aircraft)) {
            return false;
        }
        if (place.equals(that.place)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + aircraft.hashCode();
        result = 31 * result + place.hashCode();
        return result;
    }
}
