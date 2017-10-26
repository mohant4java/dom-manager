package com.dmc.service;

import com.dmc.model.ApiRequest;

import java.util.List;


public interface ApiRequestService {
    void create(ApiRequest apiRequest);

    List<ApiRequest> finAll();
}
