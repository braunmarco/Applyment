package de.braun.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "position", schema = "public")
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "positions")
    private Set<CurriculumVitae> curriculumVitae = new HashSet<>();

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

    public Set<CurriculumVitae> getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(Set<CurriculumVitae> curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;

        return this.title.equals(position.getTitle()) &&
                this.company.equals(position.company) &&
                this.start_pos.equals(position.getStart_pos()) &&
                this.end_pos.equals(position.getEnd_pos());
    }

    @Override
    public int hashCode() {
        int hashCode = 98;

        return hashCode + 33 +
                this.title.hashCode() +
                this.company.hashCode() +
                this.start_pos.hashCode() +
                this.end_pos.hashCode();
    }
}
