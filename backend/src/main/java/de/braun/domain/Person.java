package de.braun.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person", schema = "public")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    private String telefon;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "person_address",
            joinColumns = {@JoinColumn(name = "person_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "address_id", nullable = false, updatable = false)}
    )
    private Set<Address> addressList = new HashSet<>();

    @OneToMany(mappedBy = "person")
    private Set<CurriculumVitae> curriculumVitaes = new HashSet<>();

    public Person() {
    }

    public Person(final String name, final String surname, final String email, final String telefon) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telefon = telefon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Set<Address> addressList) {
        this.addressList = addressList;
    }

    public Set<CurriculumVitae> getCurriculumVitaes() {
        return curriculumVitaes;
    }

    public void setCurriculumVitaes(Set<CurriculumVitae> curriculumVitaes) {
        this.curriculumVitaes = curriculumVitaes;
    }

    public void addAddress(final Address address) {
        this.addressList.add(address);
        address.getPersonList().add(this);
    }

    public void removeAddress(final Address address) {
        this.getAddressList().remove(address);
        address.getPersonList().remove(this);
    }

    public void addCurriculumVitae(final CurriculumVitae curriculumVitae) {
        curriculumVitaes.add(curriculumVitae);
    }

    public void CurriculumVitae(final CurriculumVitae curriculumVitae) {
        curriculumVitaes.remove(curriculumVitae);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return this.name.equals(person.getName()) &&
                this.surname.equals(person.surname) &&
                this.email.equals(person.getEmail()) &&
                this.telefon.equals(person.getTelefon()) &&
                this.addressList.equals(person.getAddressList());
    }

    @Override
    public int hashCode() {
        int hashCode = 34;

        return hashCode + 18 +
                this.name.hashCode() +
                this.surname.hashCode() +
                this.email.hashCode() +
                this.telefon.hashCode() +
                this.addressList.hashCode();
    }
}
