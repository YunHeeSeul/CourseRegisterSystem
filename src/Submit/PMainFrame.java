package Submit;

import Ex.PLogin;
import Ex.VAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PMainFrame extends JFrame {
    //로그인 되었습니다. 비밀번호가 틀렸습니다 다시 입력하세요 등. 작성
    //components
    private PLogin pLogin;
    private JLabel LIntro;
    private JLabel LID;
    private JLabel LPW;
    private JTextField TID;
    private JPasswordField TPW;
    private JButton loginBt;

    private WindowHandler windowHandler;

    //constructor
    public PMainFrame(){    //컴포넌트 생성

        this.setTitle("명지대학교 수강신청시스템"); //JFrame을 상속받은 것이 PMainFrame이니까 this 사용
        this.setSize(1000,600);//창의 크기
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //창닫기 누르면 아무것도 안함
        this.setBackground(Color.lightGray);   //배경색 lightgray
        this.windowHandler = new WindowHandler();
        this.addWindowListener(windowHandler);

        Container c = getContentPane(); //컨팬트팬 알아내기
        c.setLayout(null); //컨텐트팬에 borderlayout 배치관리자 달기&간격 설정

        //패널을 한 개의 gridlayout으로 합치기
        //GridLayout g = new GridLayout(2,1,5,5);

        //라벨 만들기
        Font f1 = new Font("info",Font.BOLD,30);
        Font f2 = new Font("login",Font.BOLD,15);

        LIntro = new JLabel("명지대학교 수강신청시스템",JLabel.CENTER);
        LIntro.setBounds(430,180,400,50);
        LIntro.setFont(f1);

        LID = new JLabel("ID",JLabel.CENTER);
        LID.setBounds(400,300,200,30);
        LID.setFont(f2);

        LPW = new JLabel("PW",JLabel.CENTER);
        LPW.setBounds(400,350,200,30);
        LPW.setFont(f2);

        //textfield 만들기
        TID = new JTextField(10);
        TID.setBounds(550,300,200,30);
        TID.setFont(f2);

        //입력 내용이 표시되지 않음
        TPW = new JPasswordField(10);
        TPW.setBounds(550,350,200,30);

        //button 만들기
        loginBt = new JButton("Login");
        loginBt.setBounds(600,460,100,30);

        //button에 기능 추가
        loginBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//로그인 버튼 액션 설정하는 메소드
                if(e.getActionCommand().equals("Login")){   //로그인 버튼 눌렀을 때
                    run();
                }
            }
        });

        //컴포넌트 등록
        c.add(LIntro);c.add(LID);c.add(LPW);
        c.add(TID);c.add(TPW);
        c.add(loginBt);

        this.pLogin =new PLogin();
    }
    public void run(){
        String ID = TID.getText();
        String PW = new String((TPW.getPassword()));

        VAccount vAccount=this.pLogin.login(ID,PW);

        if(vAccount==null){//id가 없거나 비밀번호가 틀린 경우
            JOptionPane.showMessageDialog(null,"아이디나 비밀번호를 잘못 입력하셨습니다.");
        }
        else
            JOptionPane.showMessageDialog(null,"로그인에 성공하였습니다.");
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
