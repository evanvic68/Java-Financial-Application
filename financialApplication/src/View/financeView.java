package View;

import javax.swing.*;
import java.awt.*;

public class financeView extends JFrame {

    private financeForm form;
    public financeView(){
        this.form = new financeForm();
        JPanel content = form.getMainForm();
        this.setContentPane(content);
        this.setPreferredSize(new Dimension(600, 600));
        this.pack();
        this.setTitle("Finance Application");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public financeForm form(){
        return form;
    }
}
