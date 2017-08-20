package com.org.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.org.models.Entity;

import javax.persistence.EntityTransaction;

public abstract class RepositoryBase<T extends Entity, PK extends Serializable> implements IRepository<T, PK> {

    /**
     * EntityManager
     */

    protected EntityManager entityManager = Persistence.createEntityManagerFactory("JPA2-Marketplace")
            .createEntityManager();

    /**
     * Base Class
     */
    protected final Class<T> entityClass;

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public RepositoryBase() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public List<T> getAll() throws Exception {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.entityClass);
        Root<T> rootEntry = criteriaQuery.from(this.entityClass);
        CriteriaQuery<T> allQuery = criteriaQuery.select(rootEntry);
        TypedQuery<T> query = entityManager.createQuery(allQuery);

        return query.getResultList();
    }

    @Override
    public T create(T entity) throws Exception {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityTransaction.commit();

        return entity;
    }

    @Override
    public void delete(T entity) throws Exception {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(entity);
        entityManager.flush();
        entityTransaction.commit();
    }

    @Override
    public T read(PK key) throws Exception {
        return entityManager.find(this.entityClass, key);
    }

    @Override
    public T update(T entity) throws Exception {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(entity);
        entityManager.flush();
        entityTransaction.commit();

        return entity;
    }
}