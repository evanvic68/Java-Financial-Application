package View;

import javax.swing.*;
import java.awt.*;

public class assetListView extends JFrame {

    private assetListForm form;
    private assetTableModel t1;
    public assetListView(){
        this.form = new assetListForm();
        JPanel content = form.getMainPanel();
        this.setContentPane(content);
        this.setPreferredSize(new Dimension(500, 500));
        this.pack();
        this.setTitle("Finance Application");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public assetListForm form(){
        return form;
    }
}