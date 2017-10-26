package com.dmc;

import com.dmc.model.User;
import com.dmc.service.SecurityService;
import com.dmc.service.UserService;
import com.dmc.service.impl.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;


import javax.ws.rs.*;
import java.util.List;

@Path("/user")
public class UserResource {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @POST
    @Path("/registration")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public String registration(@QueryParam("userName") String userName, @QueryParam("password") String password) {
        //userValidator.validate(userForm, bindingResult);
        System.out.println("userName"+userName);
        System.out.println("password"+password);
        userService.save(userName, password);
//        securityService.autologin(userName, password);
        return "registered";
    }

    @GET
    @Path("/registration")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<User> getRegisteredUsers() {
        return userService.findAllUsers();
    }
}
