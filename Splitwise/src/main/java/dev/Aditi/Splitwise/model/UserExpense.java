package dev.Aditi.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "SPLITWISE_USER_EXPENSE")
public class UserExpense extends BaseModel{
    @ManyToOne
   private User user;
   private double amount;
   @Enumerated(EnumType.STRING)
   private UserExpenseType userExpenseType;


}
