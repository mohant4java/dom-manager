package com.dmc.dao.impl;

import com.dmc.dao.ApiRequestDao;
import com.dmc.model.ApiRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class ApiRequestDaoImpl implements ApiRequestDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(ApiRequest apiRequest) {
        entityManager.persist(apiRequest);
    }

    @Override
    public void update(ApiRequest apiRequest) {
        entityManager.merge(apiRequest);
    }

    @Override
    public ApiRequest getApiRequestById(long id) {
        return entityManager.find(ApiRequest.class, id);
    }

    @Override
    public void delete(long id) {
        ApiRequest apiRequest = getApiRequestById(id);
        if (apiRequest != null) {
            entityManager.remove(apiRequest);
        }
    }

    @Override
    public List<ApiRequest> findAll() {
        CriteriaQuery<ApiRequest> query = entityManager.getCriteriaBuilder().createQuery(ApiRequest.class);
               return entityManager.createQuery(query.select(query.from(ApiRequest.class))).getResultList() ;
    }
}
