package Submit.View;

import javax.swing.*;

public class PControlPanel extends JPanel {
    private JButton rightButton, leftButton;
    public PControlPanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        rightButton = new JButton(">>");
        this.add(rightButton);
        leftButton = new JButton("<<");
        this.add(leftButton);
    }
}
