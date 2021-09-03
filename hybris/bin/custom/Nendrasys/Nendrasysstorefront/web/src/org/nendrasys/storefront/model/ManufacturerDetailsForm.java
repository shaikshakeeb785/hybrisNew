package org.nendrasys.storefront.model;


public class ManufacturerDetailsForm {
    public String id;
    public String name;
    public String city;
    public CountryForm country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CountryForm getCountry() {
        return country;
    }

    public void setCountry(CountryForm country) {
        this.country = country;
    }
}
