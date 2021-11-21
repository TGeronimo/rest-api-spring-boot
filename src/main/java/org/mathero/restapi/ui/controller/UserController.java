package org.mathero.restapi.ui.controller;

import org.mathero.restapi.ui.model.request.UpdateUserDetailRequestModel;
import org.mathero.restapi.ui.model.request.UserDetailRequestModel;
import org.mathero.restapi.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    Map<String, UserRest> users;

    @GetMapping(path = "/")
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
                           ) {
        return "get users called with page = " + page + " and limit = " + limit + " and sort order = " + sort;
    }

    @GetMapping(path = "/{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

//        CREATED TO PROVOKE AN EXCEPTION
        String firstName = null;
        int firstNameLenght = firstName.length();

        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Validated @RequestBody UserDetailRequestModel userDetails) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail("test@tes.com");
        returnValue.setName("Tales");
        returnValue.setSurname("Geronimo");

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Validated @RequestBody UpdateUserDetailRequestModel userDetails) {

        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setName(userDetails.getFirstName());
        storedUserDetails.setSurname(userDetails.getLastName());

        users.put(userId, storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        users.remove(userId);

        return ResponseEntity.noContent().build();
    }

}
