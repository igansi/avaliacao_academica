package br.edu.infnet.avaliacaoAcademica.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.infnet.avaliacaoAcademica.dao.core.DaoException;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Question;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Student;
import br.edu.infnet.avaliacaoAcademica.dao.jbdc.QuestionDao;
import br.edu.infnet.avaliacaoAcademica.filter.SessionProperty;

/**
 * {@link ManagedBean Controlador} para o formulário de avaliação acadêmica. 
 */
@ManagedBean(name = ManagedBeanType.EVALUATION_FORM_MB)
@RequestScoped
public class EvaluationFormMB {

    private static final String EVALUATION_SENT_SUCCESS = "Avalição acadêmica enviada com sucesso.";
    private static final String ERROR_SEND_EVALUATION = "Erro ao enviar a avalição acadêmica enviada com sucesso.";

    private Student loggedStudent;
    private QuestionDao dao;
    
    private List<Question> questions;
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
        questions =  new QuestionDao().findAllByStudentId(loggedStudent.getId());
        if (!questions.isEmpty()) {
            q1 = questions.get(0);
            q2 = questions.get(1);
            q3 = questions.get(2);
            q4 = questions.get(3);
            q5 = questions.get(4);
            q6 = questions.get(5);
            q7 = questions.get(6);
            q8 = questions.get(7);
            q9 = questions.get(8);
            q10 = questions.get(9);
            q11 = questions.get(10);
            q12 = questions.get(11);
            q13 = questions.get(12);
            q14 = questions.get(13);
            q15 = questions.get(14);
            q16 = questions.get(15);
            q17 = questions.get(16);
        }
    }

    /**
     * Envia a avaliação acadêmica do estudante para o repositório.
     */
    public void enviarAvaliacao() {
        List<Question> questions = new ArrayList<>();

        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
        questions.add(q6);
        questions.add(q7);
        questions.add(q8);
        questions.add(q9);
        questions.add(q10);
        questions.add(q11);
        questions.add(q12);
        questions.add(q13);
        questions.add(q14);
        questions.add(q15);
        questions.add(q16);
        questions.add(q17);
        try {
            dao.addAll(questions);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(EVALUATION_SENT_SUCCESS));
        } catch (DaoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ERROR_SEND_EVALUATION));
            e.printStackTrace();
        }
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
