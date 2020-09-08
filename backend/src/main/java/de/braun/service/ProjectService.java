package de.braun.service;

import de.braun.domain.Person;
import de.braun.domain.Project;
import de.braun.repositories.ProjectRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

public class ProjectService extends BaseService<Project> {
    public ProjectService() {
        super(new ProjectRepository());
    }

    public Project findByTitle(final String value) {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(Person.class)
                .add(Property.forName("title").eq(value));

        return super.findOneByCriteria(detachedCriteria);
    }

    @Override
    public void persist(Project entity) {
        Project project = findByTitle(entity.getTitle());

        // save
        if (project == null) {
            super.persist(entity);
        }
        // update
        else {
            final Long id = project.getProjectId();
            entity.setProjectId(id);
            super.update(entity);
        }
    }
}
