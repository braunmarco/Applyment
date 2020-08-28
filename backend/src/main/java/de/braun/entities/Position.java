package de.braun.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "ForeignKeyAssoEntity")
@Table(name = "position", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pos_generator")
    @SequenceGenerator(name = "pos_generator", sequenceName = "pos_seq", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    private Long positionId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    private String title;
    private String company;

    @Temporal(TemporalType.DATE)
    private Date start_pos;

    @Temporal(TemporalType.DATE)
    private Date end_pos;

    public Position() {
    }

    public Position(String title, String company, Date start_pos, Date end_pos) {
        this.title = title;
        this.company = company;
        this.start_pos = start_pos;
        this.end_pos = end_pos;
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

    public Date getStart_pos() {
        return start_pos;
    }

    public void setStart_pos(Date start_pos) {
        this.start_pos = start_pos;
    }

    public Date getEnd_pos() {
        return end_pos;
    }

    public void setEnd_pos(Date end_pos) {
        this.end_pos = end_pos;
    }
}
