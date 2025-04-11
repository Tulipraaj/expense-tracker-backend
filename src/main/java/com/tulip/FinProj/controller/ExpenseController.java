package com.tulip.FinProj.controller;


import com.tulip.FinProj.entity.Expense;
import com.tulip.FinProj.entity.User;
import com.tulip.FinProj.repository.ExpenseRepository;
import com.tulip.FinProj.service.ExpenseService;
import com.tulip.FinProj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Expense addExpense(@RequestBody Expense expense){
        return expenseService.saveExpense(expense);
    }

    @GetMapping("/user/{username}")
    public List<Expense> getUserExpense(@PathVariable String username){
        User user = userService.getByUsername(username).orElse(null);
        return (user != null) ? expenseService.getUserExpenses(user) : null;
    }

    @GetMapping("/user/{username}/range")
    public List<Expense> getUserExpensesInRange(
            @PathVariable String username,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ){
        User user = userService.getByUsername(username).orElse(null);
        return (user != null) ? expenseService.getUserExpenseBetween(user, start, end) : null;
    }

}
