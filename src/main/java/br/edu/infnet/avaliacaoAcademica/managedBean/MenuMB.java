package br.edu.infnet.avaliacaoAcademica.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.infnet.avaliacaoAcademica.AvailableNavigableUrls;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Student;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.StudentCapability;
import br.edu.infnet.avaliacaoAcademica.filter.SessionProperty;

/**
 * {@link ManagedBean Controlador} para o menu principal da aplicação. 
 */
@ManagedBean(name = ManagedBeanType.MENU_MB)
@RequestScoped
public class MenuMB {
    
    private String url;
    private boolean enableCrud;
    private boolean disableEvaluation;
    private Student loggedStudent;

    public MenuMB() {
        loggedStudent = ManagedBeanHelper.getAttributeOfSession(SessionProperty.LOGGED_USER.getPropertyName());
        enableCrud = (loggedStudent.getCapability() != StudentCapability.ADMINISTRATOR.ordinal());
        disableEvaluation = (loggedStudent.getCapability() == StudentCapability.ADMINISTRATOR.ordinal());
    }
    
    /**
     * Disconecta estudante e redireciona para o login do sistema 
     */
    public void logoff() {
        ManagedBeanHelper.removeAttributeInSession(SessionProperty.LOGGED_USER.getPropertyName());
        ManagedBeanHelper.redirectNavigation(AvailableNavigableUrls.LOGIN.getUrl());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isEnableCrud() {
        return enableCrud;
    }

    public void setEnableCrud(boolean enableCrud) {
        this.enableCrud = enableCrud;
    }

    public boolean isDisableEvaluation() {
        return disableEvaluation;
    }

    public void setDisableEvaluation(boolean disableEvaluation) {
        this.disableEvaluation = disableEvaluation;
    }
}
