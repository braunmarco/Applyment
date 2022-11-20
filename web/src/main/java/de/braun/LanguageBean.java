package de.braun;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Locale;
import java.util.ResourceBundle;

@ManagedBean
@SessionScoped
public class LanguageBean {
    Locale locale = Locale.ENGLISH;

    public Locale getLocale() {
        return locale;
    }

    public String getString(String key) {
        return getString(key, this.locale);
    }

    public String getString(String key, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("de.braun.messages", locale);

        return bundle.getString(key);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Locale changeLocale(Locale locale) {
        this.locale = locale;
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);

        return locale;
    }
}
