package br.edu.infnet.avaliacaoAcademica.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.infnet.avaliacaoAcademica.AvailableNavigableUrls;
import br.edu.infnet.avaliacaoAcademica.filter.SessionProperty;
import br.edu.infnet.avaliacaoAcademica.hibernate.domain.Student;

/**
 * {@link ManagedBean Controlador} para requisições de login no sistema. 
 */
@ManagedBean(name = ManagedBeanType.LOGIN_MB)
@SessionScoped
public class LoginMB {
    
    private Student loggedStudent;

    public LoginMB() {
        loggedStudent = new Student();
    }

    public Student getLoggedStudent() {
        return loggedStudent;
    }
    
    public String validarLogin() {
        String urlDestination = AvailableNavigableUrls.STUDENT.getUrl();
        
        /* FIXME Implementar e usar DAO para validar o login. */
        if (true) {
            ManagedBeanHelper.setAttributeInSession(SessionProperty.LOGGED_USER.getPropertyName(), getLoggedStudent());
        }
        ManagedBeanHelper.handleNavigation(urlDestination);
        return urlDestination;
        
    }
}
