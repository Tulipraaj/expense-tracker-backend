package com.tulip.FinProj.repository;

import com.tulip.FinProj.entity.Goal;
import com.tulip.FinProj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUser(User user);
}
