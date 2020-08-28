package de.braun.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "ForeignKeyAssoEntity")
@Table(name = "project", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "projectId")})
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
    @SequenceGenerator(name = "project_generator", sequenceName = "project_seq", allocationSize = 1)
    private Long projectId;

    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "PROJECT_TECHNOLOGY",
            joinColumns = {@JoinColumn(name = "PROJECT_FK", referencedColumnName = "projectId")},
            inverseJoinColumns = {@JoinColumn(name = "TECHNOLOGY_FK", referencedColumnName = "technologyId")}
    )
    private List<Technology> technologies;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    public Project() {
    }

    public Project(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
