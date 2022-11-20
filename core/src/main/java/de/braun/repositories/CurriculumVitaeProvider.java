package de.braun.repositories;

import de.braun.domain.CurriculumVitae;
import de.braun.service.ICurriculumVitaeService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import java.util.List;

public class CurriculumVitaeProvider implements ICurriculumVitaeService {
    private BaseDao<CurriculumVitae> curriculumVitaeBaseDao = new BaseDao<>();

    @Override
    public CurriculumVitae findByTitle(final String title) {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(CurriculumVitae.class)
                .add(Property.forName("title").eq(title));

        return curriculumVitaeBaseDao.findOne(detachedCriteria);
    }

    @Override
    public List<CurriculumVitae> get() {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(CurriculumVitae.class);

        return curriculumVitaeBaseDao.loadAll(detachedCriteria);
    }
}

