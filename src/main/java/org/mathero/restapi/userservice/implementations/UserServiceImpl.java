package org.mathero.restapi.userservice.implementations;

import org.mathero.restapi.ui.model.request.UserDetailRequestModel;
import org.mathero.restapi.ui.model.response.UserRest;
import org.mathero.restapi.userservice.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;


    @Override
    public UserRest createUser(UserDetailRequestModel userDetailRequestModel) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail("test@tes.com");
        returnValue.setName("Tales");
        returnValue.setSurname("Geronimo");

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }
}
