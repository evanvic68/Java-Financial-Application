package Model;

import java.io.Serializable;

public class Asset implements Serializable, Comparable<Asset>{
    private String assetName;
    private String assetType;
    private double estimatedYearlyIncome;
    private double incomeRate;

    public Asset(String assetName, String assetType, double estimatedYearlyIncome, double incomeRate) {
        this.assetName = assetName;
        this.assetType = assetType;
        this.estimatedYearlyIncome = estimatedYearlyIncome;
        this.incomeRate = incomeRate;
    }

    public Asset() {
        assetName = "Asset Name Here";
        assetType = "Asset Type Here";
        estimatedYearlyIncome = 0;
        incomeRate = 0;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public double getEstimatedYearlyIncome() {
        return estimatedYearlyIncome;
    }

    public double getIncomeRate() {
        return incomeRate;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setEstimatedYearlyIncome(double estimatedYearlyIncome) {
        this.estimatedYearlyIncome = estimatedYearlyIncome;
    }

    public void setIncomeRate(double incomeRate) {
        this.incomeRate = incomeRate;
    }

    @Override
    public int compareTo(Asset o) {
        return Double.compare(this.estimatedYearlyIncome, o.estimatedYearlyIncome);
    }

    @Override
    public String toString(){
        return "Asset: " + assetName + "\n Asset Type: " + assetType + "\n Estimated Yearly Income: $" + estimatedYearlyIncome + "\n Income Rate: %" + incomeRate;
    }
}
