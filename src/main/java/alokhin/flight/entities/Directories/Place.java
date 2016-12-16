package alokhin.flight.entities.Directories;

public class Place {
    private Long id;
    private String row;
    private Integer seat;
    private FlightClass flightClass;

    private Boolean busy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (id.equals(place.id)) return false;
        if (seat.equals(place.seat)) return false;
        if (busy == place.busy) return false;
        if (flightClass.equals(place.flightClass)) return false;
        if (row != null ? !row.equals(place.row) : place.row != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (row != null ? row.hashCode() : 0);
        result = 31 * result + seat.hashCode();
        result = 31 * result + flightClass.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return row + seat + " (" + flightClass.getName() + ")";
    }
}
