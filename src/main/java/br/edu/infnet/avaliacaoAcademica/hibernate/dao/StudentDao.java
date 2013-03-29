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
    
    private static final String SELECT_BY_LOGIN = "FROM Student WHERE (LOWER(login) = ?)";

    public StudentDao() {
        super(Student.class);
    }
    
    /**
     * Encontra um {@link Student estudante} pelo seu login.
     * @param login Nome de usuário do estudante a ser encontrado
     * @return Estudante que possui o nome especificado
     */
    @SuppressWarnings("unchecked")
    public Student findByLogin(String login) {
        Student student = new Student();
        List<Student> candidateStundents = new ArrayList<>();
        Session session = HibernateSessionFactory.INSTANCE.getSessionFactory().openSession();
        Query query = session.createQuery(SELECT_BY_LOGIN);

        try {
            query.setString(0, login.toLowerCase());
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
