package br.edu.infnet.avaliacaoAcademica.managedBean;

import java.text.MessageFormat;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.infnet.avaliacaoAcademica.dao.core.DaoException;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.StudentDao;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Student;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.StudentCapability;

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
    private boolean administrator;

    public StudentMB() {
        student = new Student();
        dao = new StudentDao();
        administrator = false;
    }

    /**
     * Adiciona um {@linkplain Student estudante}.
     */
    public void add() {
        student.setCapability(administrator ? StudentCapability.ADMINISTRATOR.ordinal() : StudentCapability.SIMPLE.ordinal());
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
        student.setCapability(administrator ? StudentCapability.ADMINISTRATOR.ordinal() : StudentCapability.SIMPLE.ordinal());
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
        setAdministrator(student.getCapability() == StudentCapability.ADMINISTRATOR.ordinal());
    }

    /**
     * Cria um novo {@linkplain student estudante} de forma que o formulário fique em branco.
     */
    public void newStudent() {
        student = new Student();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}
