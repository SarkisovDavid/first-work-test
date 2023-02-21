package com.example.test;

public class BankInfoItemModel implements CardInfoItemModel{

    private String bankInfo;
    private String bankName;
    private String bankUrl;
    private String bankPhone;

    public BankInfoItemModel(String bankInfo, String bankName, String bankUrl, String bankPhone) {
        this.bankInfo = bankInfo;
        this.bankName = bankName;
        this.bankUrl = bankUrl;
        this.bankPhone = bankPhone;
    }

    @Override
    public String header() {
        return bankInfo;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankUrl() {
        return bankUrl;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    @Override
    public String toString() {
        return "BankInfoItemModel{" +
                "bankInfo='" + bankInfo + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankUrl='" + bankUrl + '\'' +
                ", bankPhone='" + bankPhone + '\'' +
                '}';
    }
}
