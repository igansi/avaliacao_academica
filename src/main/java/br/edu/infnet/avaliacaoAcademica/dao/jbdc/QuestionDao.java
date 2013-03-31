package br.edu.infnet.avaliacaoAcademica.dao.jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.edu.infnet.avaliacaoAcademica.dao.core.DaoException;
import br.edu.infnet.avaliacaoAcademica.dao.core.IGenericDao;
import br.edu.infnet.avaliacaoAcademica.dao.hibernate.domain.Question;
import br.edu.infnet.avaliacaoAcademica.dao.jbdc.util.JbdcConnectionFactory;
import br.edu.infnet.avaliacaoAcademica.dao.jbdc.util.JbdcQuestionSequenceKeyGenerator;

/**
 * Implementação de DAO para a entidade {@linkplain Question questão}.
 */
public class QuestionDao implements IGenericDao<Question> {

    private static final String ERROR_ADDING_QUESTION = "Erro ao adicionar uma questão.";
    private static final String ERROR_DOING_ROLLBACK = "Erro ao realizar rollback.";

    private static final String INSERT = "INSERT INTO question (id, student_id, question_number, value)"
            + "    VALUES (?, ?, ?, ?)";

    private static final String SELECT_BY_STUDENT_ID = "SELECT *"
            + "    FROM question"
            + "    WHERE (student_id = ?)"
            + "    ORDER BY question_number";

    private final Connection connection;

    public QuestionDao() {
        this.connection = JbdcConnectionFactory.INSTANCE.getConnection();
    }

    /**
     * Adiciona questões na base de dados.
     * @param questions Questões a serem adicionadas
     * @throws DaoException Exceção indicando erro ao adicionar questões ao repositório
     */
    public void addAll(Collection<Question> questions) throws DaoException {
        for (Question question : questions) {
            add(question);
        }
    }

    @Override
    public void add(Question entity) throws DaoException {
        PreparedStatement ps = null;

        entity.setId((int) JbdcQuestionSequenceKeyGenerator.getNextId());
        try {
            ps = connection.prepareStatement(INSERT);
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getStudentId());
            ps.setInt(3, entity.getQuestionId());
            ps.setByte(4, entity.getQuestionValue());
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new DaoException(ERROR_DOING_ROLLBACK, e1);
            }
            throw new DaoException(ERROR_ADDING_QUESTION, e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remove(Question entity) throws DaoException {}

    @Override
    public void update(Question entity) throws DaoException {}

    @Override
    public Question find(int id) {
        return null;
    }

    @Override
    public List<Question> findAll() {
        return null;
    }

    public List<Question> findAllByStudentId(int studentId) {
        List<Question> questions = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = JbdcConnectionFactory.INSTANCE.getConnection().prepareStatement(SELECT_BY_STUDENT_ID);
            pstm.setInt(1, studentId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                questions.add(buildQuestion(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return questions;
    }

    private Question buildQuestion(ResultSet rs) throws SQLException {
        Question question = new Question(rs.getInt("student_id"), rs.getInt("question_number"));

        question.setId(rs.getInt("id"));
        question.setQuestionValue(rs.getByte("value"));
        return question;
    }

}
