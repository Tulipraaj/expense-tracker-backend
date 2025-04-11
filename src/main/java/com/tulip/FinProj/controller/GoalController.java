package com.tulip.FinProj.controller;

import com.tulip.FinProj.entity.Goal;
import com.tulip.FinProj.entity.User;
import com.tulip.FinProj.service.GoalService;
import com.tulip.FinProj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Goal addGoal(@RequestBody Goal goal) {
        return goalService.saveGoal(goal);
    }

    @GetMapping("/user/{username}")
    public List<Goal> getUserGoals(@PathVariable String username) {
        User user = userService.getByUsername(username).orElse(null);
        return (user != null) ? goalService.getUserGoals(user) : null;
    }
}
