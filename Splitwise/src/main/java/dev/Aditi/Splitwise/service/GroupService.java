package dev.Aditi.Splitwise.service;

import dev.Aditi.Splitwise.model.SettlementTransaction;

import java.util.List;

public interface GroupService {
    List<SettlementTransaction> settleUp(int groupId);
}
