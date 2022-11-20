package de.braun;


import de.braun.domain.CurriculumVitae;
import de.braun.domain.Person;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "personBean")
@SessionScoped
public class PersonBean implements Serializable {
    private Person person;
    private CurriculumVitae currentCurriculumVitae;

    public PersonBean() {
        currentCurriculumVitae = (CurriculumVitae) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("current");
        person = currentCurriculumVitae.getPerson();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getMessage() {
        return "Hello World Marco from Named Bean";
    }
}
