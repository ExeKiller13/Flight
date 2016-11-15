package alokhin.flight.entities.Directories;

/**
 * Created by ExeKiller on 14.11.2016.
 */
public class City {
    private Long id;
    private String name;
    private Country country;
    private String code;
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id.equals(city.id)) return false;
        if (country.equals(city.country)) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (code != null ? !code.equals(city.code) : city.code != null) return false;
        if (desc != null ? !desc.equals(city.desc) : city.desc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country.hashCode());
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }
}
