package org.mathero.restapi.userservice.implementations;

import org.mathero.restapi.ui.model.request.UserDetailRequestModel;
import org.mathero.restapi.ui.model.response.UserRest;
import org.mathero.restapi.userservice.UserService;
import org.mathero.restapi.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;

    Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailRequestModel userDetailRequestModel) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail("test@tes.com");
        returnValue.setName("Tales");
        returnValue.setSurname("Geronimo");

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }
}
