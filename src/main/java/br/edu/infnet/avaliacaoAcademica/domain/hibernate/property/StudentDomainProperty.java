package br.edu.infnet.avaliacaoAcademica.domain.hibernate.property;

import br.edu.infnet.avaliacaoAcademica.domain.hibernate.Student;

/**
 * Define as propriedades da entidade {@link Student estudante}.
 */
public final class StudentDomainProperty {

	public static final String TABLE_NAME = "student";
	public static final String COLUMN_ID_NAME = "id";
	public static final String COLUMN_NAME_NAME = "name";
	public static final byte COLUMN_NAME_LENGHT = 50;
	public static final String COLUMN_EMAIL_NAME = "email";
	public static final byte COLUMN_EMAIL_LENGHT = 50;
	public static final String COLUMN_USER_NAME = "user";
    public static final byte COLUMN_USER_LENGHT = 8;
    public static final String COLUMN_PASSWORD_NAME = "password";
    public static final byte COLUMN_PASSWORD_LENGHT = 12;

	private StudentDomainProperty() {}
}
