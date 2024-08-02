package Model;

public class Loan extends Liability{
    private int loanAmount;
    public Loan(String liabilityName, String liabilityType, double estimateYearlyInterest, double interestRate, int loanAmount){
        super(liabilityName, liabilityType, estimateYearlyInterest, interestRate);
        this.loanAmount = loanAmount;
    }

    public Loan(){
        loanAmount = 20;
    }

    public int getLoanAmount(){
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public void somePayment(){
        System.out.println("Payment for loan made.");
        loanAmount--;
    }

    @Override
    public String toString(){
        return super.toString() + "\n Loan Amount: " + loanAmount;
    }
}
