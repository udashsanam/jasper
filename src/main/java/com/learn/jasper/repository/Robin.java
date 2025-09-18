package com.learn.jasper.repository;

import java.util.ArrayList;
import java.util.List;

public class Robin {

    private String status;

    private String clientName;

    private String dealCode;

    private String product;

    private String transactionType;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDealCode() {
        return dealCode;
    }

    public void setDealCode(String dealCode) {
        this.dealCode = dealCode;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public static List<Robin> createDemoData() {
        List<Robin> list = new ArrayList<>();

        Robin r1 = new Robin();
        r1.setStatus("Active");
        r1.setClientName("ABC Corp");
        r1.setDealCode("D123");
        r1.setProduct("Loan");
        r1.setTransactionType("Credit");
        list.add(r1);

        Robin r2 = new Robin();
        r2.setStatus("Closed");
        r2.setClientName("XYZ Ltd");
        r2.setDealCode("D456");
        r2.setProduct("Insurance");
        r2.setTransactionType("Debit");
        list.add(r2);

        Robin r3 = new Robin();
        r3.setStatus("Pending");
        r3.setClientName("MNO Pvt");
        r3.setDealCode("D789");
        r3.setProduct("Mortgage");
        r3.setTransactionType("Credit");
        list.add(r3);

        Robin r4 = new Robin();
        r4.setStatus("In Progress");
        r4.setClientName("QRS Ltd");
        r4.setDealCode("D321");
        r4.setProduct("Deposit");
        r4.setTransactionType("Debit");
        list.add(r4);

        Robin r5 = new Robin();
        r5.setStatus("Rejected");
        r5.setClientName("TUV Corp");
        r5.setDealCode("D654");
        r5.setProduct("Mutual Fund");
        r5.setTransactionType("Credit");
        list.add(r5);

        return list;
    }
}
