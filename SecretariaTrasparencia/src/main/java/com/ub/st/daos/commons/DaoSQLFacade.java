/*
 * Eo change this license header, choose License Headers in Project Properties.
 * Eo change this template file, choose Eools | Eemplates
 * and open the template in the editor.
 */
package com.ub.st.daos.commons;

import com.ub.st.entities.commons.EntitySQL;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JPAQueryLogger;
import org.jinq.jpa.JinqJPAStreamProvider;

/**
 * Facade Data Access Object para entidades SQL
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 * @param <T> Entidad JPA a utilizar por el controlador C JPA respaldado de DaoSQLFacade
 * @param <K> Tipo de dato de la llave primaria de la entidad
 */
public abstract class DaoSQLFacade<T extends EntitySQL<K>, K> {

    private final Class<T> claseEntity;
    private final EntityManagerFactory eMFactory;
    private final JinqJPAStreamProvider streamProvider;

    /**
     * al sobreescribir considerar la fabrica de EntityManager, que sea la que apunte a la base de datos adecuada, que la clase entidad sea correcta y la clase que represente la llave primaria tambien corresponda
     *
     * @param eMFactory fabrica de manejadores de entidad EntityManager que corresponda a la base de datos con la cual trabajar
     * @param claseEntity clase de la entidad con la cual operar
     */
    public DaoSQLFacade(EntityManagerFactory eMFactory, Class<T> claseEntity) {
        this.eMFactory = eMFactory;
        this.claseEntity = claseEntity;

        streamProvider = new JinqJPAStreamProvider(eMFactory);
        //streamProvider.registerAttributeConverterType(UUID.class);
    }

    public Class<T> getClaseEntity() {
        return claseEntity;
    }

    public EntityManagerFactory geteMFactory() {
        return eMFactory;
    }

    public JinqJPAStreamProvider getStreamProvider() {
        return streamProvider;
    }

    /**
     * obtiene una nueva instancia de un EntityManager de la fabrica proporsionada al construir el objeto
     *
     * @return EntityManager de la fabrica de este Data Access Object
     */
    public EntityManager getEM() {
        return eMFactory.createEntityManager();
    }

    /**
     * construye un JPQL Query con el parametro obtenido
     *
     * @param jpql cadena con el JPQL para construir un query
     * @return query contruido con el JPQL
     */
    protected Query createQuery(String jpql) {
        return this.getEM().createQuery(jpql);
    }

    /**
     * construye un Stream de datos de tipo JPAJinq, esto para poder realizar consultas con funciones lambda
     *
     * @return strema de datos de la entidad con la cual operar
     */
    public JPAJinqStream<T> stream() {
        JPAJinqStream<T> stream = streamProvider.streamAll(eMFactory.createEntityManager(), claseEntity);
        stream.setHint("queryLogger", (JPAQueryLogger) (String query, Map<Integer, Object> positionParameters, Map<String, Object> namedParameters) -> {
            System.out.println("queryLogr -> " + query);
        });
        return stream;
    }

    //<editor-fold defaultstate="collapsed" desc="¡LEEME!">
    //Todos los metodos siguientes tiene con objetivo hacer y solo hacer lo que su nombre indica       
    //</editor-fold>
    public void persist(T entity) throws Exception {
        EntityManager em = this.getEM();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<T> persistAll(List<T> entities) throws Exception {
        EntityManager em = this.getEM();
        try {
            em.getTransaction().begin();
            entities.forEach((entity) -> {
                em.persist(entity);
            });
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return entities;
    }

    public void delete(K id) throws Exception {
        EntityManager em = this.getEM();
        try {
            em.getTransaction().begin();
            em.remove(em.getReference(claseEntity, id));
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deleteAll(List<K> ids) throws Exception {
        EntityManager em = this.getEM();
        try {
            em.getTransaction().begin();
            ids.forEach((id) -> {
                em.remove(em.getReference(claseEntity, id));
            });
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(T entity) throws Exception {
        EntityManager em = this.getEM();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public T findFirst() throws Exception {
        try {
            return findAll(false, 1, 0).get(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public T findOne(K id) throws Exception {
        return getEM().find(claseEntity, id);
    }

    public List<T> findAll(int max) throws Exception {
        return findAll(false, max, 0);
    }

    public List<T> findAll() throws Exception {
        return findAll(true, -1, -1);
    }

    public List<T> findAll(int maxResults, int firstResult) throws Exception {
        return findAll(false, maxResults, firstResult);
    }

    private List<T> findAll(boolean all, int maxResults, int firstResult) throws Exception {
        EntityManager em = getEM();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseEntity));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public long count() throws Exception {
        EntityManager em = getEM();
        long count = streamProvider.streamAll(getEM(), claseEntity).count();
        if (em != null) {
            em.close();
        }
        return count;
    }

}
