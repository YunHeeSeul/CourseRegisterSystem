package Ex.View;

import javax.swing.*;

public class PControlPanel extends JPanel {
    private JButton rightButton, leftButton;
    public PControlPanel(String panelID, PSugangSincheongPanel.ActionHandler actionHandler){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.rightButton = new JButton(">>");
        this.rightButton.addActionListener(actionHandler);
        this.rightButton.setActionCommand(panelID+this.rightButton.getText());
        this.add(rightButton);

        this.leftButton = new JButton("<<");
        this.leftButton.addActionListener(actionHandler);
        this.leftButton.setActionCommand(panelID+this.leftButton.getText());
        this.add(leftButton);
    }
}
