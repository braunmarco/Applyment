package de.braun;

import de.braun.domain.PositionDetail;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "positionEditBean")
@SessionScoped
public class PositionEditBean implements Serializable {
    LanguageBean languageBean = new LanguageBean();

    public PositionEditBean() {
    }

    public void onRowEdit(RowEditEvent event) {
        PositionDetail newPosition = (PositionDetail) event.getObject();
        String message = languageBean.getString("edit.item.successful");
        FacesMessage msg = new FacesMessage(message, "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        Object obj = event.getObject();
        String message = languageBean.getString("edit.item.canceled");
        FacesMessage msg = new FacesMessage(message, "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
