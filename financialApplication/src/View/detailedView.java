package View;

import javax.swing.*;
import java.awt.*;

public class detailedView extends JFrame {

    private assetDetailForm form;
    public detailedView(){
        this.form = new assetDetailForm();
        JPanel content = form.getAssetDetailPanel();
        this.setContentPane(content);
        this.setPreferredSize(new Dimension(500, 200));
        this.pack();
        this.setTitle("Finance Application");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public assetDetailForm form(){
        return form;
    }
}