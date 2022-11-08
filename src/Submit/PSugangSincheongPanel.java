package Submit;

import javax.swing.*;
import java.awt.*;

public class PSugangSincheongPanel extends JPanel {

    private PDirectoryPanel pDirectoryPanel;
    public PSugangSincheongPanel(){
        this.pDirectoryPanel=new PDirectoryPanel();
        this.setLayout(new GridLayout(1,2,10,10));
        this.add(pDirectoryPanel);
    }
}
