package com.tulip.FinProj.service;

import com.tulip.FinProj.entity.Budget;
import com.tulip.FinProj.entity.User;
import com.tulip.FinProj.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public Budget saveBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public List<Budget> getUserBudgets(User user) {
        return budgetRepository.findByUser(user);
    }

    public List<Budget> getBudgetsByCategory(User user, String category) {
        return budgetRepository.findByUserAndCategory(user, category);
    }
}
