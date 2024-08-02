package View;
import Model.Liability;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class liabilityTableModel extends AbstractTableModel {
    private String[] columnNames = {"Liability Name", "Liability Type", "Estimated Yearly Interest", "Interest Rate"};

    private ArrayList<Liability> liabilityList;

    public liabilityTableModel(ArrayList<Liability> list){
        liabilityList = list;
    }

    public int getRowCount() {
        return liabilityList.size();
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
            case 0: return (Object) liabilityList.get(row).getLiabilityName();
            case 1: return (Object) liabilityList.get(row).getLiabilityType();
            case 2: return (Object) liabilityList.get(row).getEstimateYearlyInterest();
            case 3: return (Object) liabilityList.get(row).getInterestRate();
            default: return null;
        }
    }
}

