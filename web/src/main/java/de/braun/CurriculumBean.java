package de.braun;

import de.braun.domain.CurriculumVitae;
import de.braun.domain.Position;
import de.braun.repositories.CurriculumVitaeProvider;
import de.braun.service.ICurriculumVitaeService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "curriculumBean")
@SessionScoped
public class CurriculumBean implements Serializable {
    //TODO put into config-file
    public String DATE_PATTERN = "dd/MM/yyyy";

    private ICurriculumVitaeService curriculumVitaeService = new CurriculumVitaeProvider();
    private List<CurriculumVitae> curriculumVitaeList;
    private CurriculumVitae selectedCurriculumVitae;
    private Position selectedPosition;

    private String message;

    public CurriculumBean() {
        curriculumVitaeList = curriculumVitaeService.get();
        selectedCurriculumVitae = curriculumVitaeList.get(0);
    }

    public List<CurriculumVitae> getCurriculumVitaeList() {
        return curriculumVitaeList;
    }

    public void setCurriculumVitaeList(List<CurriculumVitae> curriculumVitaeList) {
        this.curriculumVitaeList = curriculumVitaeList;
    }

    public CurriculumVitae getSelectedCurriculumVitae() {
        return selectedCurriculumVitae;
    }

    public void setSelectedCurriculumVitae(CurriculumVitae selectedCurriculumVitae) {
        this.selectedCurriculumVitae = selectedCurriculumVitae;
    }

    public Position getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(Position selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public String newListener() {
        return "curriculumEdit.xhtml";
    }

    public void printListener() {
        //TODO print document
    }

    public String importListener() {
        return "curriculumImport.xhtml?faces-redirect=true";
    }

    public String editListener() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("current", selectedCurriculumVitae);

        return "curriculumEdit.xhtml?faces-redirect=true";
    }

    public String viewListener() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("current", selectedCurriculumVitae);

        return "curriculumView.xhtml?faces-redirect=true";
    }

    public String getDatePattern() {
        return DATE_PATTERN;
    }

    public void deleteListener() {
        //TODO delete with dialog to submit or cancel
    }

    public void store() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("current");
    }

    public String back() {
        return "index.xhtml?faces-redirect=true";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
