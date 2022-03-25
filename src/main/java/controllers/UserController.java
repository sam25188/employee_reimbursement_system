package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.User;
import services.UserService;
import io.javalin.http.Handler;

public class UserController {
    private UserService userService;

    public UserController(){
        this.userService = new UserService();
    }
    public UserController(UserService userService){
        this.userService = userService;
    }
    public void createUser(Context context){

        JsonResponse jsonResponse;
        //get user from json string
        User user = context.bodyAsClass(User.class);
        if(userService.createUser(user)){
             jsonResponse = new JsonResponse(true, "user has been created", null);
        }else{
            jsonResponse = new JsonResponse(false, "username already exists", null);
        }

        context.json(jsonResponse);
    }
}
