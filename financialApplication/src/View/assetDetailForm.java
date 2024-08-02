package View;

import javax.swing.*;

public class assetDetailForm {
    private JTextField assetNameField;
    private JTextField assetTypeField;
    private JTextField estIncomeField;
    private JTextField incomeRateField;
    private JButton saveButton;
    private JButton doneButton;
    private JButton deleteButton;
    private JLabel assetNameTwo;
    private JLabel assetTypeTwo;
    private JLabel estIncoTwo;
    private JLabel incRateTwo;
    private JPanel assetDetailPanel;
    private JLabel counterTxt;
    private JLabel listCounterTwo;
    private JButton addButton;

    public JPanel getAssetDetailPanel() {
        return assetDetailPanel;
    }

    public JTextField getAssetNameField() {
        return assetNameField;
    }

    public JTextField getAssetTypeField() {
        return assetTypeField;
    }

    public JTextField getEstIncomeField() {
        return estIncomeField;
    }

    public JTextField getIncomeRateField() {
        return incomeRateField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getDoneButton() {
        return doneButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JLabel getAssetNameTwo() {
        return assetNameTwo;
    }

    public JLabel getAssetTypeTwo() {
        return assetTypeTwo;
    }

    public JLabel getEstIncoTwo() {
        return estIncoTwo;
    }

    public JLabel getIncRateTwo() {
        return incRateTwo;
    }

    public JLabel getCounterTxt() {
        return counterTxt;
    }

    public JLabel getListCounterTwo() {
        return listCounterTwo;
    }

    public JButton getAddButton() {
        return addButton;
    }
}
