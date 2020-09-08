package de.braun.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "techology", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "technologyId")
})
public class Technology implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technology_generator")
    @SequenceGenerator(name = "technology_generator", sequenceName = "technology_seq", allocationSize = 1)
    private Long technologyId;

    //@Column(name = "TITLE", unique = true, nullable = false)
    private String title;

    private String description;

    //@Column(name = "VERSION", unique = true, nullable = false)
    private String version;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PROJECT_TECHNOLOGY",
            joinColumns = {@JoinColumn(name = "TECHNOLOGY_FK", insertable = false,
                    updatable = false, referencedColumnName = "technologyId")},
            inverseJoinColumns = {@JoinColumn(name = "PROJECT_FK", insertable = false,
                    updatable = false, referencedColumnName = "projectId")}
    )
    private List<Project> projects;

    public Technology() {
    }

    public Technology(String title, String description, String version) {
        this.title = title;
        this.description = description;
        this.version = version;
    }

    public Long getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Long technologyId) {
        this.technologyId = technologyId;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
