package com.tulip.FinProj.service;

import com.tulip.FinProj.entity.Goal;
import com.tulip.FinProj.entity.User;
import com.tulip.FinProj.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> getUserGoals(User user) {
        return goalRepository.findByUser(user);
    }
}
