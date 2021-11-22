package org.mathero.restapi.userservice;

import org.mathero.restapi.ui.model.request.UserDetailRequestModel;
import org.mathero.restapi.ui.model.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailRequestModel userDetailRequestModel);

}
