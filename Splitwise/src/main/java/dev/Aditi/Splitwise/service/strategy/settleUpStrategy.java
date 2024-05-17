package dev.Aditi.Splitwise.service.strategy;

import dev.Aditi.Splitwise.model.Expense;
import dev.Aditi.Splitwise.model.SettlementTransaction;

import java.util.List;

public interface settleUpStrategy {
  List<SettlementTransaction> getSettlementTransactions(List<Expense> expenses);

}
