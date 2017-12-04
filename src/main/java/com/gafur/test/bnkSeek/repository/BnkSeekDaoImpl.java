package com.gafur.test.bnkSeek.repository;

import com.gafur.test.bnkSeek.entity.BnkSeekEntity;
import com.gafur.test.bnkSeek.model.BnkSeekSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author igafurov
 * @since 04.12.2017
 */
@Repository
@Transactional
public class BnkSeekDaoImpl implements BnkSeekDao {

    @Autowired
    private EntityManager entityManager;

    public List<BnkSeekEntity> findAll(BnkSeekSearchCriteria searchCriteria) {
        Map<String, Object> optional = new HashMap<>();
        optional.put("newNum", searchCriteria.getNewNum());
        optional.put("rgn", searchCriteria.getRgn());
        optional.put("pzn", searchCriteria.getPzn());

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        Predicate predicate = builder.and();
        CriteriaQuery<BnkSeekEntity> criteriaQuery = builder.createQuery(BnkSeekEntity.class);

        Root<BnkSeekEntity> root = criteriaQuery.from(BnkSeekEntity.class);

        for (Map.Entry<String, Object> item : optional.entrySet()) {
            final Object value = item.getValue();
            if (value == null || "".equals(value))
                continue;
            Predicate searchPredicate = null;
            if ("newNum".equals(item.getKey())) {
                searchPredicate = builder.equal(root.get(item.getKey()), value);
            } else {
                searchPredicate = builder.equal(root.join(item.getKey()).get(item.getKey()), item.getValue());
            }
            predicate = builder.and(predicate, searchPredicate);
        }

        criteriaQuery.select(root).where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void save(BnkSeekEntity entityToSave) {
        entityManager.persist(entityToSave);
    }

    @Override
    public void delete(long id) {
        BnkSeekEntity entity = entityManager.find(BnkSeekEntity.class, id);
        if (entity != null) entityManager.remove(entity);
    }

}
