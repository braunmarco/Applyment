package de.braun.service;

import de.braun.domain.Position;
import de.braun.repositories.PositionRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

public class PositionService extends BaseService<Position> {
    //todo mittels CDI injecten
    public PositionService() {
        super(new PositionRepository());
    }

    public Position find(final Position position) {
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(Position.class)
                .add(Property.forName("company").eq(position.getCompany()))
                .add(Property.forName("title").eq(position.getTitle()))
                .add(Property.forName("start_pos").eq(position.getStart_pos()))
                .add(Property.forName("end_pos").eq(position.getEnd_pos()));

        return super.findOneByCriteria(detachedCriteria);
    }
}
