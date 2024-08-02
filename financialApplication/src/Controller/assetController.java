package Controller;

import Model.*;
import View.*;

import javax.swing.*;

public class assetController extends JFrame {

    private financeView view;
    private Asset a1;
    public assetList aList;
    public int assetListCounter;
    private detailedView v2 = new detailedView();
    private assetListView v3 = new assetListView();
    private assetTableModel t1;
    private assetHashMap ah1 = new assetHashMap();
    private assetHashMapView v4 = new assetHashMapView();

    public assetController(financeView view) {

        this.view = view;
        aList = new assetList();

        if(aList.getAList().isEmpty()){
            a1 = new Asset();
            view.form().getTxtOne().setText(a1.getAssetName());
            view.form().getTxtTwo().setText(a1.getAssetType());
            view.form().getTxtThree().setText(Double.toString((a1.getEstimatedYearlyIncome())));
            view.form().getTxtFour().setText(Double.toString((a1.getIncomeRate())));
        }
        else{
            a1 = aList.getAList().get(0);
            view.form().getTxtOne().setText(a1.getAssetName());
            view.form().getTxtTwo().setText(a1.getAssetType());
            view.form().getTxtThree().setText(Double.toString((a1.getEstimatedYearlyIncome())));
            view.form().getTxtFour().setText(Double.toString((a1.getIncomeRate())));
        }

        //View 1
        view.form().getListLabel().setText("Asset Number: " + assetListCounter);

        view.form().getPreviousButton().addActionListener(e -> {
            checkCounterPrevious();
            System.out.println(assetListCounter);
            //a1 = aList.getAList().get(assetListCounter);
            view.form().getTxtOne().setText(a1.getAssetName());
            view.form().getTxtTwo().setText(a1.getAssetType());
            view.form().getTxtThree().setText(Double.toString((a1.getEstimatedYearlyIncome())));
            view.form().getTxtFour().setText(Double.toString((a1.getIncomeRate())));
            view.form().getListLabel().setText("Asset Number: " + assetListCounter);
        });

        view.form().getNextButton().addActionListener(e -> {
            checkCounterNext();
            System.out.println(assetListCounter);
            //a1 = aList.getAList().get(assetListCounter);
            view.form().getTxtOne().setText(a1.getAssetName());
            view.form().getTxtTwo().setText(a1.getAssetType());
            view.form().getTxtThree().setText(Double.toString((a1.getEstimatedYearlyIncome())));
            view.form().getTxtFour().setText(Double.toString((a1.getIncomeRate())));
            view.form().getListLabel().setText("Asset Number: " + assetListCounter);
        });

        view.form().getAddButton().addActionListener(e -> {
            String txtOne = view.form().getTxtOne().getText();
            String txtTwo = view.form().getTxtTwo().getText();
            double txtThree = Double.parseDouble(view.form().getTxtThree().getText());
            double txtFour = Double.parseDouble(view.form().getTxtFour().getText());

            a1 = new Asset(txtOne, txtTwo, txtThree, txtFour);
            aList.getAList().add(a1);
            aList.writeAssetFile();

            for (int i = 0; i < aList.getAList().size(); i++) {
                System.out.println(aList.getAList().get(i));
                System.out.println("Size: " + (i + 1));
            }
        });

        view.form().getUpdateButton().addActionListener(e -> {
            if(aList.getAList().isEmpty()){
                JOptionPane.showMessageDialog(null, "List is currently empty.");
            }
            else{
                String txtOne = view.form().getTxtOne().getText();
                String txtTwo = view.form().getTxtTwo().getText();
                String txtThree = view.form().getTxtThree().getText();
                String txtFour = view.form().getTxtFour().getText();

                a1 = new Asset(txtOne, txtTwo, Double.parseDouble(txtThree), Double.parseDouble(txtFour));
                aList.getAList().set(assetListCounter, a1);
                aList.writeAssetFile();
                aList.readAssetFile();
            }
        });

        view.form().getDeleteButton().addActionListener(e -> {
            checkCounterDelete();
            System.out.println(assetListCounter);
            view.form().getTxtOne().setText(a1.getAssetName());
            view.form().getTxtTwo().setText(a1.getAssetType());
            view.form().getTxtThree().setText(Double.toString((a1.getEstimatedYearlyIncome())));
            view.form().getTxtFour().setText(Double.toString((a1.getIncomeRate())));
            view.form().getListLabel().setText("Asset Number: " + assetListCounter);
        });

        view.form().getQuitButton().addActionListener(e -> {
            System.exit(0);
        });

        view.form().getDetailedViewButton().addActionListener(e -> {

            if(aList.getAList().isEmpty()){
                JOptionPane.showMessageDialog(null, "List is currently empty.");
            }
            else{
                v2.setVisible(true);

                v2.form().getAssetNameTwo().setText("Asset Name: ");
                v2.form().getAssetTypeTwo().setText("Asset Type: ");
                v2.form().getEstIncoTwo().setText("Estimated Yearly Income: ");
                v2.form().getIncRateTwo().setText("Income Rate: ");

                String message = view.form().getTxtOne().getText();
                String message2 = view.form().getTxtTwo().getText();
                String message3 = view.form().getTxtThree().getText();
                String message4 = view.form().getTxtFour().getText();

                v2.form().getAssetNameField().setText(message);
                v2.form().getAssetTypeField().setText(message2);
                v2.form().getEstIncomeField().setText(message3);
                v2.form().getIncomeRateField().setText(message4);
                v2.form().getListCounterTwo().setText(String.valueOf(assetListCounter));
            }
        });

        view.form().getViewAllButton().addActionListener(e -> {

            if(aList.getAList().isEmpty()){
                JOptionPane.showMessageDialog(null, "List is currently empty.");
            }
            else{
                v3.setVisible(true);
                t1 = new assetTableModel(aList.getAList());
                v3.form().getAssetTable().setModel(t1);
                v3.form().getAssetTable().setAutoCreateRowSorter(true);
            }
        });

        view.form().getMapButton().addActionListener(e -> {
            ah1.addAssets(aList.getAList().get(assetListCounter).getAssetName(), a1);
            JOptionPane.showMessageDialog(null, "Asset Added: \n" + a1);
        });

        view.form().getViewMapButton().addActionListener(e -> {
            v4.setVisible(true);
            v4.form().getTextArea1().setText(ah1.getAh1().toString());
        });

        //View2
        v2.form().getSaveButton().addActionListener(e -> {
            String txtOne = v2.form().getAssetNameField().getText();
            String txtTwo = v2.form().getAssetTypeField().getText();
            String txtThree = v2.form().getEstIncomeField().getText();
            String txtFour = v2.form().getIncomeRateField().getText();

            view.form().getTxtOne().setText(txtOne);
            view.form().getTxtTwo().setText(txtTwo);
            view.form().getTxtThree().setText(txtThree);
            view.form().getTxtFour().setText(txtFour);

            a1 = new Asset(txtOne, txtTwo, Double.parseDouble(txtThree), Double.parseDouble(txtFour));
            aList.getAList().set(assetListCounter, a1);
            aList.writeAssetFile();
            System.out.println("Saving");
        });

        v2.form().getDeleteButton().addActionListener(e -> {
            checkCounterDelete();
            view.form().getTxtOne().setText(a1.getAssetName());
            view.form().getTxtTwo().setText(a1.getAssetType());
            view.form().getTxtThree().setText(Double.toString((a1.getEstimatedYearlyIncome())));
            view.form().getTxtFour().setText(Double.toString((a1.getIncomeRate())));
            view.form().getListLabel().setText("Asset Number: " + assetListCounter);
            v2.setVisible(false);
        });

        v2.form().getDoneButton().addActionListener(e -> {
            v2.setVisible(false);
            assetTableModel t1 = new assetTableModel(aList.getAList());
            v3.form().getAssetTable().setModel(t1);
            v3.form().getAssetTable().setAutoCreateRowSorter(true);
        });

        v2.form().getAddButton().addActionListener(e -> {
            String txtOne = v2.form().getAssetNameField().getText();
            String txtTwo = v2.form().getAssetTypeField().getText();
            double txtThree = Double.parseDouble(v2.form().getEstIncomeField().getText());
            double txtFour = Double.parseDouble(v2.form().getIncomeRateField().getText());

            a1 = new Asset(txtOne, txtTwo, txtThree, txtFour);
            aList.getAList().add(a1);
            aList.writeAssetFile();
        });

        //View 3
        v3.form().getNewButton().addActionListener(e -> {
            v2.setVisible(true);
            v3.setVisible(false);
        });

        v3.form().getDetailsButton().addActionListener(e -> {
            int selectedRow = v3.form().getAssetTable().getSelectedRow();

            if (selectedRow < 0) {
                checkCounterPrevious();
                selectedRow = 0;
            } else if (selectedRow > aList.getAList().size()) {
                checkCounterNext();
                selectedRow = 0;
            } else {
                a1 = (Asset) aList.getAList().get(selectedRow);

                v2.form().getAssetNameTwo().setText("Asset Name: ");
                v2.form().getAssetTypeTwo().setText("Asset Type: ");
                v2.form().getEstIncoTwo().setText("Estimated Yearly Income: ");
                v2.form().getIncRateTwo().setText("Income Rate: ");

                view.form().getTxtOne().setText(a1.getAssetName());
                view.form().getTxtTwo().setText(a1.getAssetType());
                view.form().getTxtThree().setText(Double.toString((a1.getEstimatedYearlyIncome())));
                view.form().getTxtFour().setText(Double.toString((a1.getIncomeRate())));
                view.form().getListLabel().setText("Asset Number: " + selectedRow);
                assetListCounter = selectedRow;

                v2.setVisible(true);
                v3.setVisible(false);
                v2.form().getAssetNameField().setText(a1.getAssetName());
                v2.form().getAssetTypeField().setText(a1.getAssetType());
                v2.form().getEstIncomeField().setText(String.valueOf(a1.getEstimatedYearlyIncome()));
                v2.form().getIncomeRateField().setText(String.valueOf(a1.getIncomeRate()));
                v2.form().getListCounterTwo().setText(String.valueOf(selectedRow));
            }
        });

        v3.form().getDoneButton().addActionListener(e -> {
            v3.setVisible(false);
        });

        v4.form().getSearchButton().addActionListener(e -> {
            try{
                String searchTxt = v4.form().getTextField5().getText();
                a1 = ah1.searchMap(searchTxt);
                v4.form().getTextField1().setText(a1.getAssetName());
                v4.form().getTextField2().setText(a1.getAssetType());
                v4.form().getTextField3().setText(Double.toString(a1.getEstimatedYearlyIncome()));
                v4.form().getTextField4().setText(Double.toString(a1.getIncomeRate()));
            }
            catch (Exception e2){
                JOptionPane.showMessageDialog(null, "Asset not found.");
            }
        });

        v4.form().getDeleteButton().addActionListener(e -> {
            if(v4.form().getTextField1().getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Nothing to delete.");
            }
            else{
                ah1.removeAssets(a1.getAssetName());
                JOptionPane.showMessageDialog(null, "Item has been deleted.");
            }
        });
    }

    private void checkCounterPrevious() {

        if(aList.getAList().isEmpty()){
            JOptionPane.showMessageDialog(null, "List is currently empty.");
        }
        else{
            if (assetListCounter == 0) {
                assetListCounter = 0;
                a1 = aList.getAList().get(assetListCounter);
                JOptionPane.showMessageDialog(null, "Out of bounds of the current list.");
            } else {
                assetListCounter--;
                a1 = aList.getAList().get(assetListCounter);
            }
        }
    }

    private void checkCounterNext() {

        if(aList.getAList().isEmpty()){
            JOptionPane.showMessageDialog(null, "List is currently empty.");
        }
        else{
            if (assetListCounter == aList.getAList().size() - 1) {
                assetListCounter = aList.getAList().size() - 1;
                a1 = aList.getAList().get(assetListCounter);
                JOptionPane.showMessageDialog(null, "Out of bounds of the current list.");
            } else {
                assetListCounter++;
                a1 = aList.getAList().get(assetListCounter);
            }
        }
    }
    private void checkCounterDelete() {

        if(aList.getAList().isEmpty()){
            JOptionPane.showMessageDialog(null, "List is currently empty.");
        }
        else{
            if (assetListCounter == 0) {
                assetListCounter = 0;
                a1 = (Asset) aList.getAList().get(assetListCounter);
                JOptionPane.showMessageDialog(null, "The default item in the list can't be deleted. It can only be updated.");
            } else {
                aList.getAList().remove(a1);
                aList.writeAssetFile();
                assetListCounter--;
                a1 = aList.getAList().get(assetListCounter);
            }
        }
    }
}
