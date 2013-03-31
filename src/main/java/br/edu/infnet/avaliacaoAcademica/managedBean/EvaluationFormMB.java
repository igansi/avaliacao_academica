package br.edu.infnet.avaliacaoAcademica.managedBean;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.infnet.avaliacaoAcademica.AvailableNavigableUrls;
import br.edu.infnet.avaliacaoAcademica.dao.core.DaoException;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.StudentDao;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Question;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Student;
import br.edu.infnet.avaliacaoAcademica.filter.SessionProperty;

/**
 * {@link ManagedBean Controlador} para o formulário de avaliação acadêmica. 
 */
@ManagedBean(name = ManagedBeanType.EVALUATION_FORM_MB)
@SessionScoped
public class EvaluationFormMB {

    private static final String EVALUATION_SENT_SUCCESS = "Avalição acadêmica enviada com sucesso.";
    private static final String ERROR_SEND_EVALUATION = "Erro ao enviar a avalição acadêmica enviada com sucesso.";

    private Student loggedStudent;
    private StudentDao dao;
    
    private Question q1;
    private Question q2;
    private Question q3;
    private Question q4;
    private Question q5;
    private Question q6;
    private Question q7;
    private Question q8;
    private Question q9;
    private Question q10;
    private Question q11;
    private Question q12;
    private Question q13;
    private Question q14;
    private Question q15;
    private Question q16;
    private Question q17;

    public EvaluationFormMB() {
        loggedStudent = ManagedBeanHelper.getAttributeOfSession(SessionProperty.LOGGED_USER.getPropertyName());
        dao = new StudentDao();
        q1 = createQuestion(1);
        q2 = createQuestion(2);
        q3 = createQuestion(3);
        q4 = createQuestion(4);
        q5 = createQuestion(5);
        q6 = createQuestion(6);
        q7 = createQuestion(7);
        q8 = createQuestion(8);
        q9 = createQuestion(9);
        q10 = createQuestion(10);
        q11 = createQuestion(11);
        q12 = createQuestion(12);
        q13 = createQuestion(13);
        q14 = createQuestion(14);
        q15 = createQuestion(15);
        q16 = createQuestion(16);
        q17 = createQuestion(17);
    }
    
    private Question createQuestion(int questionId) {
        return new Question(questionId);
    }

    /**
     * Envia a avaliação acadêmica do estudante para o repositório.
     */
    public void enviarAvaliacao() {
        loggedStudent.setQuestions(new ArrayList<Question>());
        loggedStudent.addQuestion(q1);
        loggedStudent.addQuestion(q2);
        loggedStudent.addQuestion(q3);
        loggedStudent.addQuestion(q4);
        loggedStudent.addQuestion(q5);
        loggedStudent.addQuestion(q6);
        loggedStudent.addQuestion(q7);
        loggedStudent.addQuestion(q8);
        loggedStudent.addQuestion(q9);
        loggedStudent.addQuestion(q10);
        loggedStudent.addQuestion(q11);
        loggedStudent.addQuestion(q12);
        loggedStudent.addQuestion(q13);
        loggedStudent.addQuestion(q14);
        loggedStudent.addQuestion(q15);
        loggedStudent.addQuestion(q16);
        loggedStudent.addQuestion(q17);
        try {
            dao.update(loggedStudent);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(EVALUATION_SENT_SUCCESS));
        } catch (DaoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ERROR_SEND_EVALUATION));
            e.printStackTrace();
        }
    }

    /**
     * Volta para o menu da aplicação.
     */
    public void backMenu() {
        ManagedBeanHelper.redirectNavigation(AvailableNavigableUrls.MENU.getUrl());
    }

    public Question getQ1() {
        return q1;
    }


    public void setQ1(Question q1) {
        this.q1 = q1;
    }


    public Question getQ2() {
        return q2;
    }


    public void setQ2(Question q2) {
        this.q2 = q2;
    }


    public Question getQ3() {
        return q3;
    }


    public void setQ3(Question q3) {
        this.q3 = q3;
    }


    public Question getQ4() {
        return q4;
    }


    public void setQ4(Question q4) {
        this.q4 = q4;
    }


    public Question getQ5() {
        return q5;
    }


    public void setQ5(Question q5) {
        this.q5 = q5;
    }


    public Question getQ6() {
        return q6;
    }


    public void setQ6(Question q6) {
        this.q6 = q6;
    }


    public Question getQ7() {
        return q7;
    }


    public void setQ7(Question q7) {
        this.q7 = q7;
    }


    public Question getQ8() {
        return q8;
    }


    public void setQ8(Question q8) {
        this.q8 = q8;
    }


    public Question getQ9() {
        return q9;
    }


    public void setQ9(Question q9) {
        this.q9 = q9;
    }


    public Question getQ10() {
        return q10;
    }


    public void setQ10(Question q10) {
        this.q10 = q10;
    }


    public Question getQ11() {
        return q11;
    }


    public void setQ11(Question q11) {
        this.q11 = q11;
    }


    public Question getQ12() {
        return q12;
    }


    public void setQ12(Question q12) {
        this.q12 = q12;
    }


    public Question getQ13() {
        return q13;
    }


    public void setQ13(Question q13) {
        this.q13 = q13;
    }


    public Question getQ14() {
        return q14;
    }


    public void setQ14(Question q14) {
        this.q14 = q14;
    }


    public Question getQ15() {
        return q15;
    }


    public void setQ15(Question q15) {
        this.q15 = q15;
    }


    public Question getQ16() {
        return q16;
    }


    public void setQ16(Question q16) {
        this.q16 = q16;
    }


    public Question getQ17() {
        return q17;
    }


    public void setQ17(Question q17) {
        this.q17 = q17;
    }
}
