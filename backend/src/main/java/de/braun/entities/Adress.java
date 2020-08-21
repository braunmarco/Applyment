package de.braun.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ForeignKeyAssoEntity")
@Table(name = "adress", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
public class Adress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adress_generator")
    @SequenceGenerator(name = "adress_generator", sequenceName = "adress_seq", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    private Long adressId;

    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;
    private String additional;

    @ManyToOne
    private Person person;


    public Adress() {
    }

    public Adress(String streetName, String streetNumber, String postalCode, String city, String additional) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.additional = additional;
    }

    public Long getAdressId() {
        return adressId;
    }

    public void setAdressId(Long adressId) {
        this.adressId = adressId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
}
