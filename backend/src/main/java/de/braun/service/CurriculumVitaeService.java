package de.braun.service;

import de.braun.domain.CurriculumVitae;
import de.braun.repositories.CurriculumVitaeRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

public class CurriculumVitaeService extends BaseService<CurriculumVitae> {
    //todo mittels CDI injecten
    public CurriculumVitaeService() {
        super(new CurriculumVitaeRepository());
    }

    public CurriculumVitae find(final String title) {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(CurriculumVitae.class)
                .add(Property.forName("title").eq(title));

        return super.findOneByCriteria(detachedCriteria);
    }

    public <T> CurriculumVitae save(CurriculumVitae entity) {
        if (entity.getId() == null) {
            super.persist(entity);
        } else {
            entity = super.update(entity);
        }

        return entity;
    }
}
