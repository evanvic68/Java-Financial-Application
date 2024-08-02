package View;

import javax.swing.*;
import java.awt.*;

public class liabilityQueueView extends JFrame {

    private liabilityQueueForm form;
    private assetTableModel t1;
    public liabilityQueueView(){
        this.form = new liabilityQueueForm();
        JPanel content = form.getQueuePanel();
        this.setContentPane(content);
        this.setPreferredSize(new Dimension(500, 500));
        this.pack();
        this.setTitle("Finance Application");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public liabilityQueueForm form(){
        return form;
    }
}