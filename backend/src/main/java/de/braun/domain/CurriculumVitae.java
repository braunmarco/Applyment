package de.braun.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class CurriculumVitae implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "curriculum_position",
            joinColumns = {
                    @JoinColumn(name = "curriculumId", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "positionId", nullable = false, updatable = false)})
    private Set<Position> positions = new HashSet<>();

    public CurriculumVitae() {
    }

    public CurriculumVitae(String title, Person person) {
        this.title = title;
        this.person = person;
    }

    public CurriculumVitae(final String title, final Person person, final Set<Position> positions) {
        this.title = title;
        this.person = person;
        this.positions = positions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public void addPosition(final Position position) {
        positions.add(position);
    }

    public void removePosition(final Position position) {
        positions.remove(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurriculumVitae that = (CurriculumVitae) o;
        return title.equals(that.title) &&
                person.equals(that.person) &&
                positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, person, positions);
    }
}
