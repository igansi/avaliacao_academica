package br.edu.infnet.avaliacaoAcademica.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.infnet.avaliacaoAcademica.hibernate.domain.property.QuestionDomainProperty;

@Entity
@Table(name = QuestionDomainProperty.TABLE_NAME)
public class Question implements Serializable {

    private static final long serialVersionUID = -1742781731797637437L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = QuestionDomainProperty.COLUMN_ID_NAME)
    private int id;

    @Column(name = QuestionDomainProperty.COLUMN_QUESTION_NUMBER_NAME, length = QuestionDomainProperty.COLUMN_QUESTION_NUMBER_LENGHT)
    private int questionId;

    @Column(name = QuestionDomainProperty.COLUMN_QUESTION_VALUE_NAME, length = QuestionDomainProperty.COLUMN_QUESTION_VALUE_LENGHT)
    private byte questionValue;

    public Question() {}
    
    public Question(int questionId) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + questionId;
        result = prime * result + questionValue;
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
        return true;
    }

    @Override
    public String toString() {
        return String.format("Question [id=%s, questionId=%s, questionValue=%s]", id, questionId, questionValue);
    }
}
