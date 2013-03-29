package br.edu.infnet.avaliacaoAcademica.hibernate.dao.core;

import java.util.List;

/**
 * Protocolo que entidades que desejam ser persistidas devem cumprir.
 * @param <E> Tipo de entidade a ser persistida
 */
public interface IGenericDao<E> {
    
    /**
     * Adiciona uma entidade na base de dados.
     * @param entity Entidade a ser adicionada
     */
    public void add(E entity);

    /**
     * Remove uma entidade da base de dados.
     * @param entity Entidade a ser removida
     */
    public void remove(E entity);

    /**
     * Atualiza uma entidade na base de dados.
     * @param entity Entidade a ser atualizada
     */
    public void update(E entity);

    /**
     * Encontra a entidade na base de dados dado um identificador.
     * @param
     * @param id Identificador da entidade a ser encontrada
     */
    public E find(int id);

    /**
     * Encontra todas as entidades na base de dados
     * @return Todas as entidades mantidas no banco de dados.
     */
    public List<E> findAll();
}
