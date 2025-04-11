package com.tulip.FinProj.controller;

import com.tulip.FinProj.entity.Budget;
import com.tulip.FinProj.entity.User;
import com.tulip.FinProj.service.BudgetService;
import com.tulip.FinProj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Budget addBudget(@RequestBody Budget budget){
        return budgetService.saveBudget(budget);
    }

    @GetMapping("/user/{username}")
    public List<Budget> getUserBudgets(@PathVariable String username){
        User user = userService.getByUsername(username).orElse(null);
        return (user != null) ? budgetService.getUserBudgets(user) : null;
    }

    @GetMapping("/user/{username}/category")
    public List<Budget> getUserBudgetsByCategory(
            @PathVariable String username,
            @RequestParam String category) {
        User user = userService.getByUsername(username).orElse(null);
        return (user != null) ? budgetService.getBudgetsByCategory(user, category) : null;
    }

}
