package de.braun.service;

import de.braun.domain.Person;
import de.braun.domain.Project;
import de.braun.repositories.ProjectRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

public class ProjectService extends BaseService<Project> {
    //todo mittels CDI injecten
    public ProjectService() {
        super(new ProjectRepository());
    }

    public Project findByTitle(final String value) {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(Person.class)
                .add(Property.forName("title").eq(value));

        return super.findOneByCriteria(detachedCriteria);
    }

    public <T> Project persist(Project entity) {
        if (entity.getId() == null) {
            super.persist(entity);
        } else {
            entity = super.update(entity);
        }

        return entity;
    }
}
