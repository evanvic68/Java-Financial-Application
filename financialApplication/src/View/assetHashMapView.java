package View;

import javax.swing.*;
import java.awt.*;

public class assetHashMapView extends JFrame {

    private assetHashMapForm form;
    private assetTableModel t1;
    public assetHashMapView(){
        this.form = new assetHashMapForm();
        JPanel content = form.getMainPanel();
        this.setContentPane(content);
        this.setPreferredSize(new Dimension(500, 500));
        this.pack();
        this.setTitle("Finance Application");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public assetHashMapForm form(){
        return form;
    }
}