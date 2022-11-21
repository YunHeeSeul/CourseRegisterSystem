package Submit.View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PSugangSincheongPanel extends JPanel {

    private PDirectoryPanel pDirectoryPanel;
    private PControlPanel pControlPanel;
    public PSugangSincheongPanel() throws IOException {
        this.setLayout(new GridLayout(1,2,10,10));

        this.pDirectoryPanel=new PDirectoryPanel();
        this.add(pDirectoryPanel);

        this.pControlPanel=new PControlPanel();
    }
}
