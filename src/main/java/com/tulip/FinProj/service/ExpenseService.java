package com.tulip.FinProj.service;


import com.tulip.FinProj.entity.Expense;
import com.tulip.FinProj.entity.User;
import com.tulip.FinProj.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense saveExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    public List<Expense> getUserExpenses(User user){
        return expenseRepository.findByUser(user);
    }

    public List<Expense> getUserExpenseBetween(User user, LocalDate start, LocalDate end){
        return expenseRepository.findByUserAndDateBetween(user, start, end);
    }
}
