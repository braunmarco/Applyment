package de.braun;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class PositionValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        //Date date = (Date) o;
    }
}
