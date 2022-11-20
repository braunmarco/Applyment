package de.braun.service;

import de.braun.domain.CurriculumVitae;

import java.util.List;

public interface ICurriculumVitaeService {
    CurriculumVitae findByTitle(final String title);

    List<CurriculumVitae> get();
}
