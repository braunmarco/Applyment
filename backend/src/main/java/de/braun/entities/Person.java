package de.braun.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "ForeignKeyAssoEntity")
@Table(name = "person", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "EMAIL")})
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", sequenceName = "person_seq", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    private Long personId;

    private String name;
    private String surname;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    private String telefon;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private List<Position> positionList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private List<Address> addressList;

    public Person() {
    }

    public Person(String name, String surname, String email, String telefon) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telefon = telefon;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
