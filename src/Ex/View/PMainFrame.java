package Ex.View;

import Ex.ValueObject.VAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class PMainFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private WindowHandler windowHandler;
    private PLoginDialog loginDialog;
    private Main main;
    private PAccountPanel accountPanel;
    private PSugangSincheongPanel sugangSincheongPanel;
    private VAccount vAccount;

    public void setVAccount(VAccount vAccount){this.vAccount = vAccount;}

    //constructor
    //public PMainFrame(String name) throws IOException {    //컴포넌트 생성
        public PMainFrame(VAccount vAccount) throws IOException {    //컴포넌트 생성
        //attribute
        //본인의 속성은 본인이 지정하도록 해야함 외부에서(Main) 하는 것이 아닌.
        this.setSize(1000, 600);//창의 크기
        this.setBackground(Color.lightGray);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.windowHandler = new WindowHandler();
        this.addWindowListener(windowHandler);

        //component 자식
        //그림을 그릴 수 있는 패널 생성.
        this.setLayout(new BorderLayout(50,50));

        this.vAccount=vAccount;
        this.accountPanel=new PAccountPanel(this.vAccount);
//        String name = this.loginDialog.login();
//        this.accountPanel = new PAccountPanel(name);
        this.add(this.accountPanel, BorderLayout.NORTH);

        this.sugangSincheongPanel = new PSugangSincheongPanel();
        this.add(sugangSincheongPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public void initialize() {
        this.setVisible(true);
    }

    public class WindowHandler implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {}
        @Override
        public void windowClosing(WindowEvent e) {
            int a= JOptionPane.showConfirmDialog(null, "프로그램을 종료하시겠습니까?","프로그램 종료",JOptionPane.OK_CANCEL_OPTION);
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
