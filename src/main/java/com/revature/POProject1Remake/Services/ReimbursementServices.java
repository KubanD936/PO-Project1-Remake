package com.revature.POProject1Remake.Services;

import com.revature.POProject1Remake.models.Reimbursement;
import com.revature.POProject1Remake.models.Status;
import com.revature.POProject1Remake.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementServices extends JpaRepository<Reimbursement, Integer> {
    List<Reimbursement> findById(int id);
    List<Reimbursement> findByStatus(Status status);
    List<Reimbursement> findByAmount(int amount);
    List<Reimbursement> findByUser(User user);
}
