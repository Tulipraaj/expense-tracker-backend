package com.tulip.FinProj.controller;

import com.tulip.FinProj.entity.Investment;
import com.tulip.FinProj.entity.User;
import com.tulip.FinProj.service.InvestmentService;
import com.tulip.FinProj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Investment addInvestment(@RequestBody Investment investment) {
        return investmentService.saveInvestment(investment);
    }

    @GetMapping("/user/{username}")
    public List<Investment> getUserInvestments(@PathVariable String username) {
        User user = userService.getByUsername(username).orElse(null);
        return (user != null) ? investmentService.getUserInvestments(user) : null;
    }
}
