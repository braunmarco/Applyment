package de.braun.repositories;

import de.braun.domain.CurriculumVitae;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

//TODO darf nur sichtbar fuer den service sein
public class CurriculumVitaeRepository extends BaseRepository<CurriculumVitae> {
    @SuppressWarnings("unchecked")
    @Override
    public List<CurriculumVitae> getAllByCriteria(final DetachedCriteria detachedCriteria) {
        return detachedCriteria.getExecutableCriteria(getCurrentSession()).list();
    }
}
