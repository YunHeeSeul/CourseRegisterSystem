package Submit.View;

import javax.swing.*;

import Submit.Global.Constants;
import Submit.Global.Locale;
import Submit.ValueObject.VAccount;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class PMainFrame extends JFrame {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
    private WindowHandler windowHandler;
    private PAccountPanel accountPanel;
    private PSugangSincheongPanel sugangSincheongPanel;
    private VAccount vAccount;

    public void setVAccount(VAccount vAccount){this.vAccount = vAccount;}

    //constructor
    //public PMainFrame(String name) throws IOException {    //컴포넌트 생성
    public PMainFrame(VAccount vAccount) throws IOException {    //컴포넌트 생성
        //attribute
        //본인의 속성은 본인이 지정하도록 해야함 외부에서(Main) 하는 것이 아닌.
        this.setSize(Constants.CMainFrame.WIDTH, Constants.CMainFrame.HEIGHT);//창의 크기
        this.setBackground(Color.lightGray);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.windowHandler = new WindowHandler();
        this.addWindowListener(windowHandler);

        this.vAccount=vAccount;

        //component 자식
        //그림을 그릴 수 있는 패널 생성.
        this.setLayout(new BorderLayout(Constants.CMainFrame.HGAP,Constants.CMainFrame.VGAP));


        this.accountPanel=new PAccountPanel(this.vAccount);
        this.add(this.accountPanel, BorderLayout.NORTH);

        this.sugangSincheongPanel = new PSugangSincheongPanel();
        this.add(sugangSincheongPanel, BorderLayout.CENTER);
    }

    public void initialize() {
        this.setVisible(true);
    }

    public class WindowHandler implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {}
        @Override
        public void windowClosing(WindowEvent e) {
            int a= JOptionPane.showConfirmDialog(null, Locale.EXIT_SYSTEM_MESSAGE,Locale.EXIT_TITLE,JOptionPane.OK_CANCEL_OPTION);
            if(a==JOptionPane.OK_OPTION) setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            else if(a==JOptionPane.CANCEL_OPTION) setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        @Override
        public void windowClosed(WindowEvent e) {}
        @Override
        public void windowIconified(WindowEvent e) {}
        @Override
        public void windowDeiconified(WindowEvent e) {}
        @Override
        public void windowActivated(WindowEvent e) {}
        @Override
        public void windowDeactivated(WindowEvent e) {}
    }
}
