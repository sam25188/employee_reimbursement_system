package services;

import models.Reimbursement;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repositories.ReimbursementDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementServiceTest {

    ReimbursementService reimbursementService;

    ReimbursementDAO reimbursementDAO = Mockito.mock(ReimbursementDAO.class);

    public ReimbursementServiceTest(){
        reimbursementService = new ReimbursementService(reimbursementDAO);
    }

    @Test
    void getReimbursementById() {

        List<Reimbursement> expectedOutput = new ArrayList<>();
       expectedOutput.add(new Reimbursement(1,100));
        expectedOutput.add(new Reimbursement(2, 200));
        Mockito.when(reimbursementDAO.getReimbursementById(2)).thenReturn(expectedOutput);

        List<Reimbursement> actualOutput = reimbursementService.getReimbursementById(2);

        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    void createReimbursement() {
        Reimbursement newReimbursement = new Reimbursement(100,6,2);

        reimbursementService.createReimbursement(newReimbursement);

        Mockito.verify(reimbursementDAO, Mockito.times(1)).createReimbursement(newReimbursement);
    }

    @Test
    void getReimbursementByStatusId() {
        List<Reimbursement> expectedOutput = new ArrayList<>();
        expectedOutput.add(new Reimbursement(125 ,3,2));
        expectedOutput.add(new Reimbursement(100,2,1));
        Mockito.when(reimbursementDAO.getReimbursementByStatusId()).thenReturn(expectedOutput);

        List<Reimbursement> actualOutput = reimbursementService.getReimbursementByStatusId();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void updateReimbursement() {
    Reimbursement approveOrDeny = new Reimbursement(100,12,2);

    reimbursementService.updateReimbursement(1,6,2);

    Mockito.verify(reimbursementDAO, Mockito.times(1));




    }

    @Test
    void getAllReimbursements() {
        List<Reimbursement> expectedOutput = new ArrayList<>();
        expectedOutput.add(new Reimbursement());
        Mockito.when(reimbursementDAO.getAllReimbursements()).thenReturn(expectedOutput);

        List<Reimbursement> actualOutput = reimbursementService.getAllReimbursements();

        assertEquals(expectedOutput,actualOutput);

    }
}