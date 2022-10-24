package Ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame extends JFrame {
    private WindowHandler windowHandler;

    //constructor
    public MainFrame() {    //컴포넌트 생성
        //본인의 속성은 본인이 지정하도록 해야함 외부에서(Main) 하는 것이 아닌.
        this.setTitle("명지대학교 수강신청시스템"); //JFrame을 상속받은 것이 PMainFrame이니까 this 사용
        this.setSize(1000, 600);//창의 크기
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //창닫기 누르면 아무것도 안함
        this.setBackground(Color.lightGray);   //배경색 lightgray
        this.windowHandler = new WindowHandler();
        this.addWindowListener(windowHandler);
        this.setLayout(new BorderLayout(50,50));

        //그림을 그릴 수 있는 패널 생성.
//        LoginPanel loginPanel = new LoginPanel();
//        this.add(loginPanel);
        LoginDialog loginDialog = new LoginDialog(this); //MainFrame을 부모로 주는 것
        //다른 패널들과 달리 얘는 부모에 등록하지 않고 독립적으로 함
        loginDialog.setVisible(true);

        SugangSincheongPanel sugangSincheongPanel = new SugangSincheongPanel();
        //this.add(sugangSincheongPanel);
    }

    public class WindowHandler implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {}
        @Override
        public void windowClosing(WindowEvent e) {}
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
