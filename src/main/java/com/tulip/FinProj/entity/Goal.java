package com.tulip.FinProj.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double targetAmount;
    private Boolean achieved;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Goal() {}

    public Goal(String description, Double targetAmount, Boolean achieved, User user) {
        this.description = description;
        this.targetAmount = targetAmount;
        this.achieved = achieved;
        this.user = user;
    }

    // Getters and setters ...

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getTargetAmount() { return targetAmount; }
    public void setTargetAmount(Double targetAmount) { this.targetAmount = targetAmount; }

    public Boolean getAchieved() { return achieved; }
    public void setAchieved(Boolean achieved) { this.achieved = achieved; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
