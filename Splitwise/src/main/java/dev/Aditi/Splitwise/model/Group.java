package dev.Aditi.Splitwise.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name="SPLITWISE_GROUP")
public class Group extends  BaseModel{
    private String name;
    private String description;
    @ManyToOne
    private User createdBy;
    @ManyToMany
    private List<User> members;
    private LocalDateTime creationDate;
    private Double totalAmount;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<SettlementTransaction> settlementTransactions;



}
