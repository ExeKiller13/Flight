package alokhin.flight.entities.Objects;

/**
 * Created by ExeKiller on 14.11.2016.
 */
public class Passenger {
    private Long id;
    private String givenName;
    private String middleName;
    private String familyName;
    private String documentNumber;
    private String email;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (id.equals(passenger.id)) return false;
        if (givenName != null ? !givenName.equals(passenger.givenName) : passenger.givenName != null) return false;
        if (middleName != null ? !middleName.equals(passenger.middleName) : passenger.middleName != null) return false;
        if (familyName != null ? !familyName.equals(passenger.familyName) : passenger.familyName != null) return false;
        if (documentNumber != null ? !documentNumber.equals(passenger.documentNumber) : passenger.documentNumber != null)
            return false;
        if (email != null ? !email.equals(passenger.email) : passenger.email != null) return false;
        if (phone != null ? !phone.equals(passenger.phone) : passenger.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (givenName != null ? givenName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        result = 31 * result + (documentNumber != null ? documentNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
