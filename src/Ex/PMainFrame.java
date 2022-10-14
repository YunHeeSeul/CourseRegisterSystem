package Ex;

import javax.swing.*;
import javax.swing.plaf.ToolBarUI;
import java.awt.*;
import java.awt.Panel;

public class PMainFrame extends JFrame {
    //로그인 되었습니다. 비밀번호가 틀렸습니다 다시 입력하세요 등. 작성
    //components
    private PLogin pLogin;

    //라벨
    private JLabel LIntro;
    private JLabel LID;
    private JLabel LPW;

    //textfield
    private JTextField TID;
    private JPasswordField TPW; //입력 내용이 표시되지 않음

    //button
    private JButton bt;

    //constructor
    public PMainFrame(){    //컴포넌트 생성
        this.setTitle("명지대학교 수강신청시스템"); //JFrame을 상속받은 것이 PMainFrame이니까 this 사용
        this.setSize(700,600);//창의 크기
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //창닫기 누르면 아무것도 안함
        this.setBackground(Color.lightGray);   //배경색 lightgray

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
        TPW = new JPasswordField(10);
        TPW.setBounds(550,350,200,30);

        //button 만들기
        bt = new JButton("Login");
        bt.setBounds(600,460,100,30);

        //컴포넌트 등록
        c.add(LIntro);
        c.add(LID);
        c.add(LPW);
        c.add(TID);
        c.add(TPW);
        c.add(bt);

        this.pLogin =new PLogin();
    }
    public void run(){
        //처음에 런이 실행되는 초기화면이 실행되야 함
        VAccount vAccount=this.pLogin.login();

        if(vAccount==null){
            //id가 없거나 비밀번호가 틀린 경우
        }
    }
}
