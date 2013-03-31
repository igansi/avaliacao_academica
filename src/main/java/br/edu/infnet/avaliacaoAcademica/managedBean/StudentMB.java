package br.edu.infnet.avaliacaoAcademica.managedBean;

import java.text.MessageFormat;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.infnet.avaliacaoAcademica.AvailableNavigableUrls;
import br.edu.infnet.avaliacaoAcademica.dao.core.DaoException;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.StudentDao;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Student;

/**
 * {@link ManagedBean Controlador} para o objeto de domínio {@link Student estudante}. 
 */
@ManagedBean(name = ManagedBeanType.STUDENT_MB)
@SessionScoped
public class StudentMB {
    
    private static final String STUDENT_CRUD_SUCCESS = "Estudante {0} com sucesso!";
    private static final String ERROR_CRUD_STUDENT_PATTERN_TEXT = "Erro ao {0} estudante.";
    private static final String ADDED = "cadastrado";
    private static final String REMOVED = "removido";
    private static final String UPDATED = "atualizar";
    private static final String ADD = "cadastrar";
    private static final String REMOVE = "remover";
    private static final String UPDATE = "atualizar";

    private Student student;
    private StudentDao dao;

    public StudentMB() {
        student = new Student();
        dao = new StudentDao();
    }

    /**
     * Adiciona um {@linkplain Student estudante}.
     */
    public void add() {
        try {
            dao.add(student);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(MessageFormat.format(STUDENT_CRUD_SUCCESS, ADDED)));
        } catch (DaoException e) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(MessageFormat.format(ERROR_CRUD_STUDENT_PATTERN_TEXT, ADD)));
            e.printStackTrace();
        }
    }

    /**
     * Remove um {@linkplain Student estudante}.
     */
    public void remove() {
        try {
            dao.remove(student);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(MessageFormat.format(STUDENT_CRUD_SUCCESS, REMOVED)));
        } catch (DaoException e) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(MessageFormat.format(ERROR_CRUD_STUDENT_PATTERN_TEXT, REMOVE)));
            e.printStackTrace();
        }
    }
    
    /**
     * Edita um {@linkplain Student estudante}.
     */
    public void update() {
        try {
            dao.update(student);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(MessageFormat.format(STUDENT_CRUD_SUCCESS, UPDATED)));
        } catch (DaoException e) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(MessageFormat.format(ERROR_CRUD_STUDENT_PATTERN_TEXT, UPDATE)));
            e.printStackTrace();
        }
    }
    
    /**
     * Busca um {@linkplain student estudante} pelo nome.
     */
    public void findByName() {
        student = dao.findByFullName(getStudent().getName());
    }

    /**
     * Cria um novo {@linkplain student estudante} de forma que o formulário fique em branco.
     */
    public void newStudent() {
        student = new Student();
    }
    
    /**
     * Volta para o menu da aplicação.
     */
    public void backMenu() {
        ManagedBeanHelper.redirectNavigation(AvailableNavigableUrls.MENU.getUrl());
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
