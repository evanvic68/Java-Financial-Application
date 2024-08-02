package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import java.util.PriorityQueue;
public class liabilityController extends JFrame {

    private financeView view;
    private Liability l1;
    public liabilityList lList;
    public int assetListCounter;
    private detailedView v2 = new detailedView();
    private assetListView v3 = new assetListView();
    private liabilityTableModel t1;
    private liabilityQueueView v4 = new liabilityQueueView();
    private liabilityPriorityQueue q1 = new liabilityPriorityQueue();

    public liabilityController(financeView view) {

        this.view = view;
        lList = new liabilityList();

        if(lList.getlList().isEmpty()){
            l1 = new Liability();
            view.form().getTxtFive().setText(l1.getLiabilityName());
            view.form().getTxtSix().setText(l1.getLiabilityType());
            view.form().getTxtSeven().setText(Double.toString((l1.getEstimateYearlyInterest())));
            view.form().getTxtEight().setText(Double.toString((l1.getInterestRate())));
        }
        else{
            l1 = lList.getlList().get(0);
            view.form().getTxtFive().setText(l1.getLiabilityName());
            view.form().getTxtSix().setText(l1.getLiabilityType());
            view.form().getTxtSeven().setText(Double.toString((l1.getEstimateYearlyInterest())));
            view.form().getTxtEight().setText(Double.toString((l1.getInterestRate())));
        }
        //View 1
        view.form().getLiabilityCounter().setText("Liability Number: " + assetListCounter);
        view.form().getPreviousButtonTwo().addActionListener(e -> {
            checkCounterPrevious();
            System.out.println(assetListCounter);
            view.form().getTxtFive().setText(l1.getLiabilityName());
            view.form().getTxtSix().setText(l1.getLiabilityType());
            view.form().getTxtSeven().setText(Double.toString((l1.getEstimateYearlyInterest())));
            view.form().getTxtEight().setText(Double.toString((l1.getInterestRate())));
            view.form().getLiabilityCounter().setText("Liability Number: " + assetListCounter);
        });

        view.form().getNextButtonTwo().addActionListener(e -> {
            checkCounterNext();
            System.out.println(assetListCounter);
            view.form().getTxtFive().setText(l1.getLiabilityName());
            view.form().getTxtSix().setText(l1.getLiabilityType());
            view.form().getTxtSeven().setText(Double.toString((l1.getEstimateYearlyInterest())));
            view.form().getTxtEight().setText(Double.toString((l1.getInterestRate())));
            view.form().getLiabilityCounter().setText("Liability Number: " + assetListCounter);
        });

        view.form().getAddButtonTwo().addActionListener(e -> {
            String txtOne = view.form().getTxtFive().getText();
            String txtTwo = view.form().getTxtSix().getText();
            double txtThree = Double.parseDouble(view.form().getTxtSeven().getText());
            double txtFour = Double.parseDouble(view.form().getTxtEight().getText());

            l1 = new Liability(txtOne, txtTwo, txtThree, txtFour);
            lList.getlList().add(l1);
            lList.writelListFile();

            for (int i = 0; i < lList.getlList().size(); i++) {
                System.out.println(lList.getlList().get(i));
                System.out.println("Size: " + (i + 1));
            }
        });

        view.form().getUpdateButtonTwo().addActionListener(e -> {
            if(lList.getlList().isEmpty()){
                JOptionPane.showMessageDialog(null, "List is currently empty.");
            }
            else{
                String txtOne = view.form().getTxtFive().getText();
                String txtTwo = view.form().getTxtSix().getText();
                String txtThree = view.form().getTxtSeven().getText();
                String txtFour = view.form().getTxtEight().getText();

                l1 = new Liability(txtOne, txtTwo, Double.parseDouble(txtThree), Double.parseDouble(txtFour));
                lList.getlList().set(assetListCounter, l1);
                lList.writelListFile();
            }

        });

        view.form().getDeleteButtonTwo().addActionListener(e -> {
            checkCounterDelete();
            System.out.println(assetListCounter);
            view.form().getTxtFive().setText(l1.getLiabilityName());
            view.form().getTxtSix().setText(l1.getLiabilityType());
            view.form().getTxtSeven().setText(Double.toString((l1.getEstimateYearlyInterest())));
            view.form().getTxtEight().setText(Double.toString((l1.getInterestRate())));
            view.form().getLiabilityCounter().setText("Liability Number: " + assetListCounter);
        });

        view.form().getQuitButtonTwo().addActionListener(e -> {
            System.exit(0);
        });

        view.form().getDetailedViewButtonTwo().addActionListener(e -> {
            if(lList.getlList().isEmpty()){
                JOptionPane.showMessageDialog(null, "List is currently empty.");
            }
            else{
                v2.setVisible(true);

                v2.form().getAssetNameTwo().setText("Liability Name: ");
                v2.form().getAssetTypeTwo().setText("Liability Type: ");
                v2.form().getEstIncoTwo().setText("Estimated Yearly Interest: ");
                v2.form().getIncRateTwo().setText("Interest Rate: ");

                String message = view.form().getTxtFive().getText();
                String message2 = view.form().getTxtSix().getText();
                String message3 = view.form().getTxtSeven().getText();
                String message4 = view.form().getTxtEight().getText();

                v2.form().getAssetNameField().setText(message);
                v2.form().getAssetTypeField().setText(message2);
                v2.form().getEstIncomeField().setText(message3);
                v2.form().getIncomeRateField().setText(message4);
                v2.form().getListCounterTwo().setText(String.valueOf(assetListCounter));
            }
        });

        view.form().getViewAllButtonTwo().addActionListener(e -> {

            if(lList.getlList().isEmpty()){
                JOptionPane.showMessageDialog(null, "List is currently empty.");
            }
            else{
                v3.setVisible(true);
                t1 = new liabilityTableModel(lList.getlList());
                v3.form().getAssetTable().setModel(t1);
                v3.form().getAssetTable().setAutoCreateRowSorter(true);
            }
        });

        view.form().getAddToQueueButton().addActionListener(e -> {
            q1.addLiability(lList.getlList().get(assetListCounter));
            System.out.println(q1.getLiabilities());
        });

        view.form().getViewQueueButton().addActionListener(e -> {
            v4.setVisible(true);
            for(int i = 0; i < q1.getLiabilities().size(); i++){
                v4.form().getQueueData().setText(q1.toString());
            }
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

            l1 = new Liability(txtOne, txtTwo, Double.parseDouble(txtThree), Double.parseDouble(txtFour));
            lList.getlList().set(assetListCounter, l1);
            lList.writelListFile();
            System.out.println("Saving");
        });

        v2.form().getDeleteButton().addActionListener(e -> {
            checkCounterDelete();
            view.form().getTxtOne().setText(l1.getLiabilityName());
            view.form().getTxtTwo().setText(l1.getLiabilityType());
            view.form().getTxtThree().setText(Double.toString((l1.getEstimateYearlyInterest())));
            view.form().getTxtFour().setText(Double.toString((l1.getInterestRate())));
            view.form().getListLabel().setText("Asset Number: " + assetListCounter);
            v2.setVisible(false);
        });

        v2.form().getDoneButton().addActionListener(e -> {
            v2.setVisible(false);
            liabilityTableModel t1 = new liabilityTableModel(lList.getlList());
            v3.form().getAssetTable().setModel(t1);
            v3.form().getAssetTable().setAutoCreateRowSorter(true);
        });

        v2.form().getAddButton().addActionListener(e -> {
            String txtOne = v2.form().getAssetNameField().getText();
            String txtTwo = v2.form().getAssetTypeField().getText();
            double txtThree = Double.parseDouble(v2.form().getEstIncomeField().getText());
            double txtFour = Double.parseDouble(v2.form().getIncomeRateField().getText());

            l1 = new Liability(txtOne, txtTwo, txtThree, txtFour);
            lList.getlList().add(l1);
            lList.writelListFile();
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
            } else if (selectedRow > lList.getlList().size()) {
                checkCounterNext();
                selectedRow = 0;
            } else {

                v2.form().getAssetNameTwo().setText("Liability Name: ");
                v2.form().getAssetTypeTwo().setText("Liability Type: ");
                v2.form().getEstIncoTwo().setText("Estimated Yearly Interest: ");
                v2.form().getIncRateTwo().setText("Interest Rate: ");

                view.form().getTxtOne().setText(l1.getLiabilityName());
                view.form().getTxtTwo().setText(l1.getLiabilityType());
                view.form().getTxtThree().setText(Double.toString((l1.getEstimateYearlyInterest())));
                view.form().getTxtFour().setText(Double.toString((l1.getInterestRate())));
                view.form().getListLabel().setText("Liability Number: " + selectedRow);
                assetListCounter = selectedRow;

                l1 = lList.getlList().get(selectedRow);
                v2.setVisible(true);
                v3.setVisible(false);
                v2.form().getAssetNameField().setText(l1.getLiabilityName());
                v2.form().getAssetTypeField().setText(l1.getLiabilityType());
                v2.form().getEstIncomeField().setText(String.valueOf(l1.getEstimateYearlyInterest()));
                v2.form().getIncomeRateField().setText(String.valueOf(l1.getInterestRate()));
                v2.form().getListCounterTwo().setText(String.valueOf(selectedRow));
            }
        });

        v3.form().getDoneButton().addActionListener(e -> {
            v3.setVisible(false);
        });

        v4.form().getSearchByNameButton().addActionListener(e -> {
            try{
                l1 = q1.searchLiability(v4.form().getTxtFive().getText());
                v4.form().getTxtOne().setText(l1.getLiabilityName());
                v4.form().getTxtTwo().setText(l1.getLiabilityType());
                v4.form().getTxtThree().setText(Double.toString(l1.getEstimateYearlyInterest()));
                v4.form().getTxtFour().setText(Double.toString(l1.getInterestRate()));
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Liability not found.");
            }
        });

        v4.form().getDeleteCollectionButton().addActionListener(e -> {
            System.out.println(q1.getLiabilities());
            q1.removeLiability(l1);
            System.out.println(q1.getLiabilities());
        });

        v4.form().getExitButton().addActionListener(e -> {
            v4.setVisible(false);
        });
    }

    private void checkCounterPrevious() {

        if(lList.getlList().isEmpty()){
            JOptionPane.showMessageDialog(null, "Out of bounds of the current list.");
        }
        else{
            if (assetListCounter == 0) {
                assetListCounter = 0;
                l1 = lList.getlList().get(assetListCounter);
                JOptionPane.showMessageDialog(null, "Out of bounds of the current list.");
            } else {
                assetListCounter--;
                l1 = lList.getlList().get(assetListCounter);
            }
        }
    }

    private void checkCounterNext() {

        if(lList.getlList().isEmpty()){
            JOptionPane.showMessageDialog(null, "Out of bounds of the current list.");
        }
        else{
            if (assetListCounter == lList.getlList().size() - 1) {
                assetListCounter = lList.getlList().size() - 1;
                l1 = lList.getlList().get(assetListCounter);
                JOptionPane.showMessageDialog(null, "Out of bounds of the current list.");
            } else {
                assetListCounter++;
                l1 = lList.getlList().get(assetListCounter);
            }
        }
    }

    private void checkCounterDelete() {

        if(lList.getlList().isEmpty()){
            JOptionPane.showMessageDialog(null, "Out of bounds of the current list.");
        }
        else{
            if (assetListCounter == 0) {
                assetListCounter = 0;
                l1 = lList.getlList().get(assetListCounter);
                JOptionPane.showMessageDialog(null, "The default item in the list can't be deleted. It can only be updated.");
            } else {
                lList.getlList().remove(l1);
                lList.writelListFile();
                assetListCounter--;
                l1 = lList.getlList().get(assetListCounter);
            }
        }
    }
}
