package Ex.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class PMainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private WindowHandler windowHandler;
    private PLoginDialog loginDialog;
    private PAccountPanel accountPanel;
    private PSugangSincheongPanel sugangSincheongPanel;

    //constructor
    public PMainFrame() throws IOException {    //컴포넌트 생성
        //attribute
        //본인의 속성은 본인이 지정하도록 해야함 외부에서(Main) 하는 것이 아닌.
        this.setTitle("명지대학교 수강신청시스템"); //JFrame을 상속받은 것이 PMainFrame이니까 this 사용
        this.setSize(1000, 600);//창의 크기
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //창닫기 누르면 아무것도 안함
        this.setBackground(Color.lightGray);
        this.windowHandler = new WindowHandler();
        this.addWindowListener(windowHandler);
        this.setLayout(new BorderLayout(50,50));

        //component 자식
        //그림을 그릴 수 있는 패널 생성.
        this.loginDialog = new PLoginDialog(this); //MainFrame을 부모로 주는 것
        loginDialog.setVisible(true);  //다른 패널들과 달리 얘는 부모에 등록하지 않고 독립적으로 함

        String name = this.loginDialog.login();
        this.accountPanel = new PAccountPanel(name);
        this.add(this.accountPanel, BorderLayout.NORTH);

        this.sugangSincheongPanel = new PSugangSincheongPanel();
        this.add(sugangSincheongPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
