package Model;

import java.io.Serializable;

public class Liability implements Payment, Serializable, Comparable<Liability>{
    private String liabilityName;
    private String liabilityType;
    private double estimateYearlyInterest;
    private double interestRate;

    public Liability(String liabilityName, String liabilityType, double estimateYearlyInterest, double interestRate) {
        this.liabilityName = liabilityName;
        this.liabilityType = liabilityType;
        this.estimateYearlyInterest = estimateYearlyInterest;
        this.interestRate = interestRate;
    }

    public Liability(){
        liabilityName = "liabilityName";
        liabilityType = "liabilityType";
        estimateYearlyInterest = 0;
        interestRate = 0;
    }

    public String getLiabilityName() {
        return liabilityName;
    }

    public String getLiabilityType() {
        return liabilityType;
    }

    public double getEstimateYearlyInterest() {
        return estimateYearlyInterest;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setLiabilityName(String liabilityName) {
        this.liabilityName = liabilityName;
    }

    public void setLiabilityType(String liabilityType) {
        this.liabilityType = liabilityType;
    }

    public void setEstimateYearlyInterest(double estimateYearlyInterest) {
        this.estimateYearlyInterest = estimateYearlyInterest;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void somePayment(){
        estimateYearlyInterest--;
    }

    @Override
    public String toString(){
        return "Liability: " + liabilityName + "\n Liability Type: " + liabilityType + "\n Estimated Yearly Interest: " + estimateYearlyInterest + "\n Interest Rate: " + interestRate;
    }

    @Override
    public int compareTo(Liability l2) {
       return Double.compare(l2.interestRate, this.interestRate);
    }
}
