package br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.property.QuestionDomainProperty;

@Entity
@Table(name = QuestionDomainProperty.TABLE_NAME)
public class Question implements Serializable {

    private static final long serialVersionUID = -1742781731797637437L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = QuestionDomainProperty.COLUMN_ID_NAME)
    private int id;
    
    private int studentId;

    @Column(name = QuestionDomainProperty.COLUMN_QUESTION_NUMBER_NAME, length = QuestionDomainProperty.COLUMN_QUESTION_NUMBER_LENGHT)
    private int questionId;

    @Column(name = QuestionDomainProperty.COLUMN_QUESTION_VALUE_NAME, length = QuestionDomainProperty.COLUMN_QUESTION_VALUE_LENGHT)
    private byte questionValue;

    public Question() {}
    
    public Question(int studentId, int questionId) {
        this.studentId = studentId;
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public byte getQuestionValue() {
        return questionValue;
    }

    public void setQuestionValue(byte questionValue) {
        this.questionValue = questionValue;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + questionId;
        result = prime * result + questionValue;
        result = prime * result + studentId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Question other = (Question) obj;
        if (id != other.id)
            return false;
        if (questionId != other.questionId)
            return false;
        if (questionValue != other.questionValue)
            return false;
        if (studentId != other.studentId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Question [id=%s, studentId=%s, questionId=%s, questionValue=%s]",
                id, studentId, questionId, questionValue);
    }
}
