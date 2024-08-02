package Model;

public class Credit {
    private int creditScore;
    private String creditHistory;

    public Credit(int creditScore, String creditHistory) {
        this.creditScore = creditScore;
        this.creditHistory = creditHistory;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public String getCreditHistory() {
        return creditHistory;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public void setCreditHistory(String creditHistory) {
        this.creditHistory = creditHistory;
    }

    @Override
    public String toString(){
        return "Credit Score: " + creditScore +"\n Credit History: " + creditHistory;
    }
}
