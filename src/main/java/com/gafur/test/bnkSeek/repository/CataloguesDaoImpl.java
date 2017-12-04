package com.gafur.test.bnkSeek.repository;

import com.gafur.test.bnkSeek.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Ivan
 * @since 02.12.2017
 */
@Repository
@Transactional
public class CataloguesDaoImpl implements CataloguesDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<PznEntity> findAllPzn() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PznEntity> criteriaQuery = builder.createQuery(PznEntity.class);
        Root<PznEntity> rootEntry = criteriaQuery.from(PznEntity.class);
        CriteriaQuery<PznEntity> all = criteriaQuery.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public List<UerEntity> findAllUer() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UerEntity> criteriaQuery = builder.createQuery(UerEntity.class);
        Root<UerEntity> rootEntry = criteriaQuery.from(UerEntity.class);
        CriteriaQuery<UerEntity> all = criteriaQuery.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public List<TnpEntity> findAllTnp() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TnpEntity> criteriaQuery = builder.createQuery(TnpEntity.class);
        Root<TnpEntity> rootEntry = criteriaQuery.from(TnpEntity.class);
        CriteriaQuery<TnpEntity> all = criteriaQuery.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public List<RgnEntity> findAllRgn() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RgnEntity> criteriaQuery = builder.createQuery(RgnEntity.class);
        Root<RgnEntity> rootEntry = criteriaQuery.from(RgnEntity.class);
        CriteriaQuery<RgnEntity> all = criteriaQuery.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public AbstractEntity getByForeignKey(String foreignKey, Field field) {
        Class<? extends AbstractEntity> type = (Class<? extends AbstractEntity>) field.getType();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = builder.createQuery(type);
        Root<? extends AbstractEntity> rootEntry = criteriaQuery.from(type);
        criteriaQuery.select(rootEntry);
        entityManager.getMetamodel().entity(type);
        criteriaQuery.where(builder.equal(rootEntry.get(field.getName()), foreignKey));
        return (AbstractEntity) entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public void save(Object entity) {
        entityManager.persist(entity);
    }

}
