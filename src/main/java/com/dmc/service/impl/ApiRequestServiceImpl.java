package com.dmc.service.impl;

import com.dmc.dao.ApiRequestDao;
import com.dmc.model.ApiRequest;
import com.dmc.service.ApiRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApiRequestServiceImpl implements ApiRequestService {

    @Autowired
    private ApiRequestDao apiRequestDao;

    @Override
    public void create(ApiRequest apiRequest) {
        apiRequestDao.create(apiRequest);
    }

    @Override
    public List<ApiRequest> finAll() {
       return apiRequestDao.findAll();
    }
}
