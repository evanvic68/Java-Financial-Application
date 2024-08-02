package Model;

public class Bill extends Liability{
    private int billFrequency;
    private double billCost;

    public Bill(String liabilityName, String liabilityType, double estimateYearlyInterest, double interestRate, int billFrequency, double billCost) {
        super(liabilityName, liabilityType, estimateYearlyInterest, interestRate);
        this.billFrequency = billFrequency;
        this.billCost = billCost;
    }

    public Bill() {
        billFrequency = 0;
        billCost = 1;
    }

    public int getBillFrequency() {
        return billFrequency;
    }

    public double getBillCost() {
        return billCost;
    }


    public void setBillFrequency(int billFrequency) {
        this.billFrequency = billFrequency;
    }

    public void setBillCost(double billCost) {
        this.billCost = billCost;
    }

    @Override
    public void somePayment(){
        System.out.println("Payment for bill made.");
        billCost--;
    }

    @Override
    public String toString(){
        return super.toString() + "\n Bill Frequency: " + billFrequency + "\n Cost: " + billCost;
    }
}
