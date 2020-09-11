package de.braun.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "projectId")})
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private String title;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "PROJECT_TECHNOLOGY",
            joinColumns = {@JoinColumn(name = "PROJECT_FK", referencedColumnName = "projectId")},
            inverseJoinColumns = {@JoinColumn(name = "TECHNOLOGY_FK", referencedColumnName = "technologyId")}
    )
    private Set<Technology> technologies = new HashSet<>();

    public Project() {
    }

    public Project(final String title, final String description) {
        this.title = title;
        this.description = description;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(final Long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Set<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(final Set<Technology> technologies) {
        this.technologies = technologies;
    }

    public void addTechnology(final Technology technology) {
        technologies.add(technology);
    }

    public void removeTechnology(final Technology technology) {
        technologies.remove(technology);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;
        return this.title.equals(project.getTitle()) &&
                this.description.equals(project.getDescription()) &&
                this.technologies.equals(project.getTechnologies());
    }

    @Override
    public int hashCode() {
        int hashCode = 3;

        return hashCode + 47 + title.hashCode() + description.hashCode() + technologies.hashCode();
    }
}
