package Ex;

import javax.swing.*;

public class PDirectoryPanel extends JPanel {
    private JList campusList;

    public PDirectoryPanel(){
        this.campusList = new JList();
        this.add(this.campusList);
    }
}
