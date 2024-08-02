import Controller.*;
import Model.*;
import View.*;

public class Main {
    public static void main(String[] args) {

        financeView v1 = new financeView();

        assetController c1 = new assetController(v1);
        liabilityController c2 = new liabilityController(v1);
        employeeController c3 = new employeeController(v1);

        System.out.println("Testing linked list below. It is ordered by yearly income. \n");

        assetLinkedList l1 = new assetLinkedList();
        l1.removeItem(l1.getItem("Stock Two"));
        l1.printList();

        v1.setVisible(true);

        //TestHarness t1 = new TestHarness();
    }
}
