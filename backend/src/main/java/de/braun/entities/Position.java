package de.braun.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ForeignKeyAssoEntity")
@Table(name = "position", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pos_generator")
    @SequenceGenerator(name = "pos_generator", sequenceName = "pos_seq", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    private Long positionId;

    @ManyToOne
    private Person person;

    private String title;
    private String company;
    private String worktask;

    public Position() {
    }

    public Position(String title, String company, String worktask) {
        this.title = title;
        this.company = company;
        this.worktask = worktask;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorktask() {
        return worktask;
    }

    public void setWorktask(String worktask) {
        this.worktask = worktask;
    }
}
