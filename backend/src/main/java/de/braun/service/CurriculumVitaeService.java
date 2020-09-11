package de.braun.service;

import de.braun.domain.CurriculumVitae;
import de.braun.repositories.CurriculumVitaeRepository;

public class CurriculumVitaeService extends BaseService<CurriculumVitae> {
    //todo mittels CDI injecten
    public CurriculumVitaeService() {
        super(new CurriculumVitaeRepository());
    }
}
