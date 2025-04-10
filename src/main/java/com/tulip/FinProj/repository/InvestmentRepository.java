package com.tulip.FinProj.repository;

import com.tulip.FinProj.entity.Investment;
import com.tulip.FinProj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByUser(User user);
}
