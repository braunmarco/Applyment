package de.braun.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address", schema = "public")
@JsonIgnoreProperties({"id"})
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;
    private String additional;
    private int type;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "addressList")
    private Set<Person> personList = new HashSet<>();

    public Address() {
    }

    public Address(final String streetName, final String streetNumber, final String postalCode, final String city, final String additional, final int type) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.additional = additional;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public Set<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(Set<Person> personList) {
        this.personList = personList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return this.streetName.equals(address.streetName) &&
                this.streetNumber.equals(address.streetNumber) &&
                this.postalCode.equals(address.postalCode) &&
                this.city.equals(address.city) &&
                this.additional.equals(address.additional) &&
                this.type == address.type;
    }

    @Override
    public int hashCode() {
        int hashCode = 7;

        return hashCode + 31 +
                type +
                streetNumber.hashCode() +
                streetNumber.hashCode() +
                postalCode.hashCode() +
                city.hashCode() +
                additional.hashCode();
    }
}
