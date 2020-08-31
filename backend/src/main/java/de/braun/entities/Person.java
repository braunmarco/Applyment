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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private List<Position> positionList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private List<Address> addressList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private List<Project> projectList;

    public Person() {
    }

    public Person(final String name, final String surname, final String email, final String telefon) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telefon = telefon;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(final Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(final String telefon) {
        this.telefon = telefon;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(final List<Position> positionList) {
        this.positionList = positionList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(final List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", positionList=" + positionList +
                ", addressList=" + addressList +
                '}';
    }
}
