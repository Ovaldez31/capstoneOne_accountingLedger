package com.ps;

public class LedgerScreen {

    private double date;
    private double time;
    private String description;
    private String vendor;
    private float amount;

    public LedgerScreen(double date, double time, String description, String vendor, float amount) {

    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }


    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }


}
