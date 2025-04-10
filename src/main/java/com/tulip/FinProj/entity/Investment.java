package com.tulip.FinProj.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "investments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;            // e.g. Stock, Mutual Fund
    private String name;            // e.g. Apple, SBI Equity Fund
    private Double amount;          // Amount invested
    private LocalDate investmentDate;
    private Double currentValue;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
