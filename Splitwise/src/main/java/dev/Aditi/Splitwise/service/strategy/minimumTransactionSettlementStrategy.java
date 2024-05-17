package dev.Aditi.Splitwise.service.strategy;

import dev.Aditi.Splitwise.dto.UserAmount;
import dev.Aditi.Splitwise.model.*;

import java.util.*;

public class minimumTransactionSettlementStrategy implements  settleUpStrategy{
    @Override
    public List<SettlementTransaction> getSettlementTransactions(List<Expense> expenses) {
       HashMap<User,Double> map = getOutstandingBalance( expenses);
       Comparator<UserAmount> minHeapComparator = Comparator.comparingDouble(UserAmount::getAmount);
       Comparator<UserAmount> maxHeapComparator = Comparator.comparingDouble(UserAmount::getAmount).reversed();
        PriorityQueue<UserAmount> maxHeap = new PriorityQueue<>(maxHeapComparator);
        PriorityQueue<UserAmount> minHeap = new PriorityQueue<>(minHeapComparator);
        List<SettlementTransaction> settlementTransactions = new ArrayList<>();

        for(Map.Entry<User,Double> entry : map.entrySet())
        {
            if(entry.getValue()<0)
            {
                minHeap.add(new UserAmount(entry.getKey(),entry.getValue()));
            }
            else if(entry.getValue()>0)
            {
                maxHeap.add(new UserAmount(entry.getKey(), entry.getValue()));
            }else
            {
                System.out.println("user does not need to participate in settle up");
            }
            while(!minHeap.isEmpty() && !maxHeap.isEmpty())
            {
                    UserAmount borrower = minHeap.poll();
                    UserAmount lender = maxHeap.poll();
                    if(Math.abs(borrower.getAmount()) > Math.abs(lender.getAmount()) )
                    {
                        borrower.setAmount(borrower.getAmount()+lender.getAmount());
                        minHeap.add(borrower);
                        SettlementTransaction settlementTransaction = new SettlementTransaction(borrower.getUser(), lender.getUser(), lender.getAmount());
                        settlementTransactions.add(settlementTransaction);
                    }
                    else if(Math.abs(borrower.getAmount()) < Math.abs(lender.getAmount()))
                    {
                        lender.setAmount(borrower.getAmount()+lender.getAmount());
                        maxHeap.add(lender);
                        SettlementTransaction settlementTransaction = new SettlementTransaction(borrower.getUser(), lender.getUser(), borrower.getAmount());
                        settlementTransactions.add(settlementTransaction);

                    }else
                    {
                        System.out.println("Both are equal");
                        SettlementTransaction settlementTransaction = new SettlementTransaction(borrower.getUser(),lender.getUser(), lender.getAmount());
                        settlementTransactions.add(settlementTransaction);
                    }
            }

        }
        return settlementTransactions;


    }
    private HashMap<User,Double> getOutstandingBalance(List<Expense> expenses)
    {   HashMap<User,Double> expenseMap = new HashMap<>();
        for(Expense e : expenses)
        {
            for(UserExpense u : e.getUserExpenses())
            {
                    User participant = u.getUser();
                    double amount = u.getAmount();
                    if(expenseMap.containsKey(participant))
                    {
                        if(u.getUserExpenseType().equals(UserExpenseType.PAID))
                        {
                            expenseMap.put(participant, expenseMap.get(participant)+amount);
                        }
                        else
                        {
                            expenseMap.put(participant, expenseMap.get(participant)+amount);

                        }
                    }
                    else
                    {
                        if(u.getUserExpenseType().equals(UserExpenseType.PAID))
                        {
                            expenseMap.put(participant, 0+amount);
                        }
                        else
                        {
                            expenseMap.put(participant, 0-amount);

                        }
                    }
                    return expenseMap;


            }

        }
    }
}
