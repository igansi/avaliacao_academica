package br.edu.infnet.avaliacaoAcademica.hibernate.dao.core;

import java.util.List;

import br.edu.infnet.avaliacaoAcademica.hibernate.dao.core.exception.DaoException;

/**
 * Protocolo que entidades que desejam ser persistidas devem cumprir.
 * @param <E> Tipo de entidade a ser persistida
 */
public interface IGenericDao<E> {
    
    /**
     * Adiciona uma entidade na base de dados.
     * @param entity Entidade a ser adicionada
     * @throws DaoException Exceção indicando erro ao adicionar entidade ao repositório
     */
    public void add(E entity) throws DaoException;

    /**
     * Remove uma entidade da base de dados.
     * @param entity Entidade a ser removida
     * @throws DaoException Exceção indicando erro ao remover entidade do repositório
     */
    public void remove(E entity) throws DaoException;

    /**
     * Atualiza uma entidade na base de dados.
     * @param entity Entidade a ser atualizada
     * @throws DaoException Exceção indicando erro ao atualizar entidade no repositório
     */
    public void update(E entity) throws DaoException;

    /**
     * Encontra a entidade na base de dados dado um identificador.
     * @param id Identificador da entidade a ser encontrada
     */
    public E find(int id);

    /**
     * Encontra todas as entidades na base de dados
     * @return Todas as entidades mantidas no banco de dados.
     */
    public List<E> findAll();
}
