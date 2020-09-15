package de.braun.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class PositionDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public PositionDetail() {
    }

    public PositionDetail(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionDetail positionDetail = (PositionDetail) o;

        return this.title.equals(positionDetail.title);
    }

    @Override
    public int hashCode() {
        int hashCode = 19;

        return hashCode + 83 + this.title.hashCode();
    }
}
