package Ex.View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PSugangSincheongPanel extends JPanel {

    private PDirectoryPanel pDirectoryPanel;
    public PSugangSincheongPanel() throws IOException {
        this.pDirectoryPanel=new PDirectoryPanel();
        this.setLayout(new GridLayout(1,2,10,10));
        this.add(pDirectoryPanel);
    }
}
