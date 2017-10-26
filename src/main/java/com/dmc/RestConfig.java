package com.dmc;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
@Configuration
public class RestConfig extends ResourceConfig {
    public RestConfig(){
        register(ApiRequestResource.class);
        register(UserResource.class);
        register(FlatResource.class);
        register(TreasuryResource.class);

    }
}
