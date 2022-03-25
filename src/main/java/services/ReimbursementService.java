package services;

import models.Reimbursement;
import models.Status;
import models.User;
import repositories.ReimbursementDAO;
import repositories.ReimbursementDAOImpl;

import java.util.List;

public class ReimbursementService {

    private ReimbursementDAO reimbursementDAO;

    public ReimbursementService(){
        this.reimbursementDAO = new ReimbursementDAOImpl();
    }
    public ReimbursementService(ReimbursementDAO reimbursementDAO){
        this.reimbursementDAO = reimbursementDAO;
    }

    public List<Reimbursement> getReimbursementById(Integer userId){
        return this.reimbursementDAO.getReimbursementById(userId);
    }

    public void createReimbursement(Reimbursement reimbursement){
        this.reimbursementDAO.createReimbursement(reimbursement);
    }
    public  List<Reimbursement> getReimbursementByStatusId(){
        return this.reimbursementDAO.getReimbursementByStatusId();
    }
    public void updateReimbursement(Integer reimbursementId, Integer resolverId, Integer statusId){
        this.reimbursementDAO.update(reimbursementId,resolverId, statusId);
    }

    public List<Reimbursement> getAllReimbursements(){
        return this.reimbursementDAO.getAllReimbursements();
    }

}






