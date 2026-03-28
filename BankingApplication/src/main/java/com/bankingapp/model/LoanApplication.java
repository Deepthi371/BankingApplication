package com.bankingapp.model;

import java.sql.Timestamp;

public class LoanApplication {
    private int id;
    private int accno;
    private int amount;
    private int tenure;
    private String purpose;
    private String status;
    private Timestamp appliedAt;
    private Timestamp approvedAt;
    private String adminRemark;
    private int cibilScore;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getAccno() {
        return accno;
    }
    public void setAccno(int accno) {
        this.accno = accno;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTenure() {
        return tenure;
    }
    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getAppliedAt() {
        return appliedAt;
    }
    public void setAppliedAt(Timestamp appliedAt) {
        this.appliedAt = appliedAt;
    }

    public Timestamp getApprovedAt() {
        return approvedAt;
    }
    public void setApprovedAt(Timestamp approvedAt) {
        this.approvedAt = approvedAt;
    }

    public String getAdminRemark() {
        return adminRemark;
    }
    public void setAdminRemark(String adminRemark) {
        this.adminRemark = adminRemark;
    }

    public int getCibilScore() {
        return cibilScore;
    }
    public void setCibilScore(int cibilScore) {
        this.cibilScore = cibilScore;
    }
}

