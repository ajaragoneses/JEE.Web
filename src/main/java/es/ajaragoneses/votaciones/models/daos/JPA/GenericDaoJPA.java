package es.ajaragoneses.votaciones.models.daos.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;

import es.ajaragoneses.votacion.models.daos.GenericDao;

public class GenericDaoJPA<T, ID> implements GenericDao<T, ID> {

    private Class<T> persistentClass;

    public GenericDaoJPA(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public void create(T entity) {
        EntityManager entityManager = DaoJPAFactory.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDaoJPA.class).debug("create: " + entity);
        } catch (Exception e) {
            LogManager.getLogger(GenericDaoJPA.class).error("create: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public T read(ID id) {
        EntityManager entityManager = DaoJPAFactory.getEntityManagerFactory().createEntityManager();
        T entity = entityManager.find(persistentClass, id);
        entityManager.close();
        return entity;
    }

    public void update(T entity) {
        EntityManager entityManager = DaoJPAFactory.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDaoJPA.class).debug("update: " + entity);
        } catch (Exception e) {
            LogManager.getLogger(GenericDaoJPA.class).error("update: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void deleteById(ID id) {
        EntityManager entityManager = DaoJPAFactory.getEntityManagerFactory().createEntityManager();
        T entity = entityManager.find(persistentClass, id);
        if (entity != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(entity);
                entityManager.getTransaction().commit();
                LogManager.getLogger(GenericDaoJPA.class).debug("delete: " + entity);
            } catch (Exception e) {
                LogManager.getLogger(GenericDaoJPA.class).error("delete: " + e);
                if (entityManager.getTransaction().isActive())
                    entityManager.getTransaction().rollback();
            } finally {
                entityManager.close();
            }
        }
    }
}
