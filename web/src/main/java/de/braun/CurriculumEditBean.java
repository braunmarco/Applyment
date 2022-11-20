package de.braun;

import de.braun.domain.CurriculumVitae;
import de.braun.domain.Person;
import de.braun.domain.Position;
import de.braun.repositories.BaseDao;
import de.braun.service.ICrudService;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.Date;

@ManagedBean(name = "curriculumEditBean")
@SessionScoped
public class CurriculumEditBean implements Serializable {
    private Person person;
    private CurriculumVitae selectedCurriculumVitae;

    public CurriculumEditBean() {
        selectedCurriculumVitae = (CurriculumVitae) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("current");
    }

    public void updatePersonalData() {
    }

    public void addPosition() {
    }

    public void removePosition() {
    }

    public void update() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public CurriculumVitae getSelectedCurriculumVitae() {
        return selectedCurriculumVitae;
    }

    public void valueChanged(ValueChangeEvent e) {
        selectedCurriculumVitae = (CurriculumVitae) e.getNewValue();
    }

    public void onRowEdit(RowEditEvent event) {
        Position newPosition = (Position) event.getObject();
        FacesMessage msg = new FacesMessage("Item sucessfull edited", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        //TODO implement Position-Service
        ICrudService service = new BaseDao();
        CurriculumVitae curriculum = (CurriculumVitae) newPosition.getCurriculumVitae().toArray()[0];
        Position oldPosition = (Position) service.find(Position.class, newPosition.getId());
        Position updatePosition = getUpdatedPosition(oldPosition, newPosition);
        System.out.println("test");
        //service.update(updatePosition);
    }

    private Position getUpdatedPosition(Position oldPosition, Position newPosition) {
        Position updatedPosition = oldPosition;

        String newCompany = newPosition.getCompany();
        String newTitle = newPosition.getTitle();
        Date newStartDate = newPosition.getStart_pos();
        Date newEndDate = newPosition.getEnd_pos();

        String oldCompany = oldPosition.getCompany();
        String oldTitle = oldPosition.getTitle();
        Date oldStartDate = oldPosition.getStart_pos();
        Date oldEndDate = oldPosition.getEnd_pos();

        if (StringUtils.isNotBlank(newCompany) && !newCompany.equals(oldCompany)) {
            updatedPosition.setCompany(newCompany);
        }
        if (StringUtils.isNotBlank(newTitle) && !newTitle.equals(oldTitle)) {
            updatedPosition.setTitle(newTitle);
        }
        if (newStartDate != null && !newStartDate.equals(oldStartDate)) {
            updatedPosition.setStart_pos(newStartDate);
        }
        if (newEndDate != null && !newEndDate.equals(oldEndDate)) {
            updatedPosition.setEnd_pos(newEndDate);
        }

        return updatedPosition;
    }

    public void onRowCancel(RowEditEvent event) {
        Object obj = event.getObject();
        FacesMessage msg = new FacesMessage("Edit cancelled", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String back() {
        return "index.xhtml?faces-redirect=true";
    }

    public String editListener() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("current", selectedCurriculumVitae);

        return "curriculumEdit.xhtml?faces-redirect=true";
    }

    public void setSelectedCurriculumVitae(CurriculumVitae selectedCurriculumVitae) {
        this.selectedCurriculumVitae = selectedCurriculumVitae;
    }
}
