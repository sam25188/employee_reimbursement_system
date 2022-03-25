package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.Reimbursement;
import services.ReimbursementService;

import java.util.List;

public class ReimbursementController {
    ReimbursementService reimbursementService;

    public ReimbursementController(){
        this.reimbursementService = new ReimbursementService();
    }

    public ReimbursementController(ReimbursementService reimbursementService){
        this.reimbursementService = reimbursementService;
    }

    public void displayAllReimbursementByStatusId(Context context){


        List<Reimbursement> lists = reimbursementService.getReimbursementByStatusId();
        context.json(new JsonResponse(true, "listing all reimbursements by status", lists));
    }

    public void createReimbursementRequest(Context context){
        Reimbursement reimbursement = context.bodyAsClass(Reimbursement.class);

        reimbursementService.createReimbursement(reimbursement);

        context.json(new JsonResponse(true, "new reimbursement request created" , null));
    }

    public void displayAllReimbursements(Context context){

        List<Reimbursement> lists = reimbursementService.getAllReimbursements();
        context.json(new JsonResponse(true, "listing all reimbursements for all employees", lists));
    }

    public void updateReimbursement(Context context){
        Integer reimbursementId = Integer.parseInt(context.pathParam("reimbursementId"));
        Integer resolverId = Integer.parseInt(context.pathParam("resolverId"));
        Integer statusId = Integer.parseInt(context.pathParam("statusId"));

        reimbursementService.updateReimbursement(reimbursementId,resolverId,statusId);

        context.json(new JsonResponse(true, "reimbursement updated", null ));


    }

    public void displayReimbursementsByUserId(Context context) {
        Integer userId = Integer.parseInt(context.pathParam("userId"));

        List<Reimbursement>lists = reimbursementService.getReimbursementById(userId);
        context.json(new JsonResponse(true, "listing all your reimbursements" , lists));
    }
}
