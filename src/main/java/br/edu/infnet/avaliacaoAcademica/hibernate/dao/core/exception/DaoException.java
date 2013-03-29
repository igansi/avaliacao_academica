package br.edu.infnet.avaliacaoAcademica.hibernate.dao.core.exception;

/**
 * Exceção indica problema ao acesso ao repositório via DAO.
 */
public class DaoException extends Exception {

    private static final long serialVersionUID = 6406802114497175519L;

    public DaoException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}
