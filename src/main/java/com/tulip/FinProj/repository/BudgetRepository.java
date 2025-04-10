package com.tulip.FinProj.repository;

import com.tulip.FinProj.entity.Budget;
import com.tulip.FinProj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUser(User user);
    List<Budget> findByUserAndCategory(User user, String category);
}
