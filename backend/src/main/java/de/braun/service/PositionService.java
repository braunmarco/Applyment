package de.braun.service;

import de.braun.domain.Position;
import de.braun.repositories.PositionRepository;

public class PositionService extends BaseService<Position> {
    public PositionService() {
        super(new PositionRepository());
    }
}
