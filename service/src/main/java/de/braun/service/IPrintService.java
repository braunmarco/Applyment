package de.braun.service;

import de.braun.domain.CurriculumVitae;

public interface IPrintService {
    void printCV(final String destinantion, final CurriculumVitae cv);
}
