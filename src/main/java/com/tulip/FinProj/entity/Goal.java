package com.tulip.FinProj.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "goals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;            // e.g. Buy a car
    private Double targetAmount;
    private Double savedSoFar;
    private LocalDate targetDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
