package de.braun;

import de.braun.domain.Position;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "positionBean")
@SessionScoped
public class PositionBean implements Serializable {
    private Position selectedPosition;

    public PositionBean() {
    }

    public Position getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(Position selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public String viewListener() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentPosition", selectedPosition);

        return "positionView.xhtml?faces-redirect=true";
    }

    public String editListener() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentPosition", selectedPosition);

        return "positionEdit.xhtml?faces-redirect=true";
    }

    public String back() {
        return "curriculumView.xhtml?faces-redirect=true";
    }
}
