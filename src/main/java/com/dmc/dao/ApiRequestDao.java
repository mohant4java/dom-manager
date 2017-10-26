package com.dmc.dao;

import com.dmc.model.ApiRequest;

import java.util.List;

public interface ApiRequestDao {
    void create(ApiRequest apiRequest);

    void update(ApiRequest apiRequest);

    ApiRequest getApiRequestById(long id);

    void delete(long id);

    List<ApiRequest> findAll();
}
