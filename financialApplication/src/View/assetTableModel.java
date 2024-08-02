package View;

import Model.Asset;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class assetTableModel extends AbstractTableModel {
    private String[] columnNames = {"Asset Name", "Asset Type", "Estimated Yearly Income", "Income Rate"};

    private ArrayList<Asset> assetList;

    public assetTableModel(ArrayList<Asset> newAssetList){
        assetList = newAssetList;
    }

    public int getRowCount() {
        return assetList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        switch(col){
            case 0: return (Object) assetList.get(row).getAssetName();
            case 1: return (Object) assetList.get(row).getAssetType();
            case 2: return (Object) assetList.get(row).getEstimatedYearlyIncome();
            case 3: return (Object) assetList.get(row).getIncomeRate();
            default: return null;
        }
    }
}
