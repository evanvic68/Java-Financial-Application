package View;

import javax.swing.*;

public class liabilityQueueForm {
    private JTextField txtOne;
    private JTextField txtTwo;
    private JTextField txtThree;
    private JTextField txtFour;
    private JButton addCollectionButton;
    private JButton deleteCollectionButton;
    private JButton exitButton;
    private JButton searchByNameButton;
    private JTextField txtFive;
    private JPanel queuePanel;
    private JLabel labelOne;
    private JLabel labelTwo;
    private JLabel LabelThree;
    private JLabel labelFour;
    private JTextArea queueData;

    public JPanel getQueuePanel() {
        return queuePanel;
    }

    public JTextField getTxtOne() {
        return txtOne;
    }

    public JTextField getTxtTwo() {
        return txtTwo;
    }

    public JTextField getTxtThree() {
        return txtThree;
    }

    public JTextField getTxtFour() {
        return txtFour;
    }

    public JButton getAddCollectionButton() {
        return addCollectionButton;
    }

    public JButton getDeleteCollectionButton() {
        return deleteCollectionButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getSearchByNameButton() {
        return searchByNameButton;
    }

    public JTextField getTxtFive() {
        return txtFive;
    }

    public JLabel getLabelOne() {
        return labelOne;
    }

    public JLabel getLabelTwo() {
        return labelTwo;
    }

    public JLabel getLabelThree() {
        return LabelThree;
    }

    public JLabel getLabelFour() {
        return labelFour;
    }

    public JTextArea getQueueData() {
        return queueData;
    }
}
