package de.braun.repositories;

import de.braun.domain.Project;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class ProjectRepository extends BaseRepository<Project> {
    @SuppressWarnings("unchecked")
    public List<Project> loadAll() {
        return getCurrentSession().createCriteria(Project.class).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Project> getAllByCriteria(final DetachedCriteria detachedCriteria) {
        return detachedCriteria.getExecutableCriteria(getCurrentSession()).list();
    }
}
