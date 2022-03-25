package util;

import controllers.ReimbursementController;
import controllers.SessionController;
import controllers.UserController;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.staticfiles.Location;
import models.User;
import services.ReimbursementService;
import services.UserService;



public class MainDriver {
    public static void main(String[] args) {


        Javalin app = Javalin.create(config -> {
           config.addStaticFiles("/", Location.CLASSPATH);
        }).start(9001);

        UserController userController = new UserController();
        ReimbursementController reimbursementController = new ReimbursementController();
        SessionController sessionController = new SessionController();


        app.post("/user/", userController::createUser);
        app.post("/login/", sessionController:: login);
        app.get("/session/", sessionController::checkSession);
        app.delete("/session/", sessionController::logout);

        //order all reimbursements
        app.get("/reimbursement/order/", reimbursementController::displayAllReimbursementByStatusId);
        app.post("/reimbursement/{userId}/reimbursement", reimbursementController::createReimbursementRequest);
        app.get("/reimbursement/",reimbursementController:: displayAllReimbursements);
        app.patch("/reimbursement/{reimbursementId}/{resolverId}/{statusId}",reimbursementController::updateReimbursement);
        app.get("/reimbursement/{userId}/list", reimbursementController::displayReimbursementsByUserId);
    }


}

