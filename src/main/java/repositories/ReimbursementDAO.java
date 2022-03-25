package repositories;

import models.Reimbursement;
import models.Status;

import java.util.List;

public interface ReimbursementDAO {

    List <Reimbursement> getReimbursementById(Integer userId);
    void createReimbursement(Reimbursement reimbursement);



    public List<Reimbursement>getAllReimbursements();

    public void update(Integer reimbursementId, Integer userId, Integer statusId);

    public List<Reimbursement> getReimbursementByStatusId();



}
