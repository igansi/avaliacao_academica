package br.edu.infnet.avaliacaoAcademica.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.infnet.avaliacaoAcademica.hibernate.dao.core.GenericDaoImpl;
import br.edu.infnet.avaliacaoAcademica.hibernate.dao.util.HibernateSessionFactory;
import br.edu.infnet.avaliacaoAcademica.hibernate.domain.Student;

/**
 * DAO para persistência da entidade {@link Student estudante}.
 */
public class StudentDao extends GenericDaoImpl<Student> {
    
    private static final String SELECT_BY_FULLNAME = "FROM Student WHERE (LOWER(name) = :value)";
    private static final String SELECT_BY_LOGIN = "FROM Student WHERE (LOWER(login) = :value)";

    public StudentDao() {
        super(Student.class);
    }

    /**
     * Encontra um {@link Student estudante} pelo seu login.
     * @param login Login de usuário do estudante a ser encontrado
     * @return Estudante que possui o login especificado
     */
    public Student findByLogin(String login) {
        return findByProperty(SELECT_BY_LOGIN, login);
    }
    
    /**
     * Encontra um {@link Student estudante} pelo seu nome completo.
     * @param fullName Nome completo de usuário do estudante a ser encontrado
     * @return Estudante que possui o nome completo especificado
     */
    public Student findByFullName(String fullName) {
        return findByProperty(SELECT_BY_FULLNAME, fullName);
    }
    
    /**
     * Encontra um {@link Student estudante} pelo seu login.
     * @param hqlQuery Consulta hibernate SQL
     * @param value Valor da propriedade de um estudante
     * @return Estudante que possui o nome especificado
     */
    @SuppressWarnings("unchecked")
    public Student findByProperty(String hqlQuery, String value) {
        Student student = new Student();
        List<Student> candidateStundents = new ArrayList<>();
        Session session = HibernateSessionFactory.INSTANCE.getSessionFactory().openSession();
        Query query = session.createQuery(hqlQuery);

        try {
            query.setParameter("value", value.toLowerCase());
            candidateStundents = (List<Student>) query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        if ((candidateStundents != null) && (!candidateStundents.isEmpty())) {
            student = candidateStundents.get(0);
        }
        return student;
    }
}
