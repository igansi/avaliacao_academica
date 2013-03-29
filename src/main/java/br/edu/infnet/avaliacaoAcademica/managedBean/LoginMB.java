package br.edu.infnet.avaliacaoAcademica.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.infnet.avaliacaoAcademica.AvailableNavigableUrls;
import br.edu.infnet.avaliacaoAcademica.filter.SessionProperty;
import br.edu.infnet.avaliacaoAcademica.hibernate.dao.StudentDao;
import br.edu.infnet.avaliacaoAcademica.hibernate.domain.Student;

/**
 * {@link ManagedBean Controlador} para requisições de login no sistema. 
 */
@ManagedBean(name = ManagedBeanType.LOGIN_MB)
@SessionScoped
public class LoginMB {
    
    private static final String WRONG_LOGIN_PASSWORD_MESSAGE = "Login ou senha incorretos.";

    private Student loggedStudent;
    private StudentDao dao;

    public LoginMB() {
        loggedStudent = new Student();
        dao = new StudentDao();
    }

    public Student getLoggedStudent() {
        return loggedStudent;
    }
    
    public void efetuarLogin() {
        Student candidateStudent = dao.findByLogin(getLoggedStudent().getLogin());

        if (isValidLogon(candidateStudent)) {
            ManagedBeanHelper.setAttributeInSession(SessionProperty.LOGGED_USER.getPropertyName(), candidateStudent);
            ManagedBeanHelper.redirectNavigation(AvailableNavigableUrls.MENU.getUrl());
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(WRONG_LOGIN_PASSWORD_MESSAGE));
        }
    }

    /**
     * Indica se o login e senha do estudante a ser logar no sistema está correto.
     * @param candidateStudent Informações do estudante provindas do repositório
     * @return <code>true</code> caso o logon seja permitido; <code>false</code>, caso contrário
     */
    private boolean isValidLogon(Student candidateStudent) {
        return ((getLoggedStudent().getLogin().equals(candidateStudent.getLogin()))
                && (getLoggedStudent().getPassword().equals(candidateStudent.getPassword())));
    }
}
