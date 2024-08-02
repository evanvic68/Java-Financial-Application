package View;

import javax.swing.*;

public class assetListForm {

    public JPanel mainPanel;
    private JTable assetTable;
    private JButton newButton;
    private JButton doneButton;
    private JButton detailsButton;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTable getAssetTable(){
        return assetTable;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public JButton getDoneButton() {
        return doneButton;
    }

    public JButton getDetailsButton() {
        return detailsButton;
    }
}
