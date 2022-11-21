package Ex.View;

import javax.swing.*;
import java.io.IOException;

public class PSugangSincheongPanel extends JPanel {

    private PDirectoryPanel pDirectoryPanel;
    private PControlPanel pControlPanel1, pControlPanel2;
    private PMiriDamgiPanel pMiriDamgiPanel;
    private PSincheongPanel pSincheongPanel;
    public PSugangSincheongPanel() throws IOException {
        //this.setLayout(new GridLayout(1,2,10,10));
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        this.pDirectoryPanel=new PDirectoryPanel();
        this.add(this.pDirectoryPanel);

        this.pControlPanel1 = new PControlPanel();
        this.add(this.pControlPanel1);

        JScrollPane jScrollPane1 = new JScrollPane();
        this.pMiriDamgiPanel = new PMiriDamgiPanel();
        jScrollPane1.setViewportView(this.pMiriDamgiPanel);
        this.add(jScrollPane1);

        this.pControlPanel2 = new PControlPanel();
        this.add(this.pControlPanel2);

        JScrollPane jScrollPane2 = new JScrollPane();
        this.pSincheongPanel = new PSincheongPanel();
        jScrollPane2.setViewportView(this.pSincheongPanel);
        this.add(jScrollPane2);
    }
}
