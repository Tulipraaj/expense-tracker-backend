package com.tulip.FinProj.service;

import com.tulip.FinProj.entity.Investment;
import com.tulip.FinProj.entity.User;
import com.tulip.FinProj.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    public Investment saveInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    public List<Investment> getUserInvestments(User user) {
        return investmentRepository.findByUser(user);
    }
}
