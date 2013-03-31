package br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.property;

import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Question;

/**
 * Define as propriedades da entidade {@link Question questão}.
 */
public final class QuestionDomainProperty {

	public static final String TABLE_NAME = "question";
	public static final String COLUMN_ID_NAME = "id";
	public static final String COLUMN_STUDENT_ID_NAME = "student_id";
	public static final String COLUMN_QUESTION_NUMBER_NAME = "question_number";
	public static final String COLUMN_QUESTION_VALUE_NAME = "value";
    public static final int COLUMN_QUESTION_NUMBER_LENGHT = 2;
    public static final int COLUMN_QUESTION_VALUE_LENGHT = 1;

	private QuestionDomainProperty() {}
}
