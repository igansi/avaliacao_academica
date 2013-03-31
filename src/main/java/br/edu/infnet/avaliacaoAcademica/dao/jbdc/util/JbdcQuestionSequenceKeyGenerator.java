package br.edu.infnet.avaliacaoAcademica.dao.jbdc.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe utilitária para gerar o próximo ID da sequency da tabela Question.
 */
public final class JbdcQuestionSequenceKeyGenerator {
    
    private static final String NEXT_ID = "SELECT nextval('question_seq') AS next_id";

    private JbdcQuestionSequenceKeyGenerator() {}
    
    public synchronized static long getNextId() {
        Statement stm = null;
        ResultSet rs = null;
        long nextId = 0L;

        try {
            stm = JbdcConnectionFactory.INSTANCE.getConnection().createStatement();
            rs = stm.executeQuery(NEXT_ID);
            if (rs.next()) {
                nextId = rs.getLong("next_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nextId;
    }

}
