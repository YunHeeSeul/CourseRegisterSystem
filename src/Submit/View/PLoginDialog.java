package Submit.View;

import Submit.Model.SLogin;
import Submit.ValueObject.VAccount;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class PLoginDialog extends JDialog{//JDialog를 확장했다는 것

    private static final long serialVersionUID = 1L;
    //components
    private WindowHandler windowHandler;
    private SLogin sLogin;
    private PSignUpDialog pSignUpDialog;
    private JLabel LIntro,LID,LPW,imageLabel;
    private JTextField TID;
    private JPasswordField TPW;
    private JButton loginBt, signUpBt;
    private JPanel loginPanel, innerPanel2, buttonPanel;
    private ImageIcon imageIcon;
    public Main main = new Main();

    public PLoginDialog(Main.ActionHandler actionHandler) throws IOException{//JDialog를 상속받음. 확장한 것임. 그리고 필요한 기능 추가한 것
//        super(parent);//원래 JDialog의 constructor를 불러주는 것
        this.setModal(true);
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout(0,10));
        this.setSize(900,900);
        this.setLocation(178,0);
        this.windowHandler = new WindowHandler();
        this.addWindowListener(windowHandler);

        this.imageLabel = new JLabel();
        this.imageLabel.setBackground(Color.getHSBColor((222f/360),0.14f, 0.87f));
        this.imageIcon = new ImageIcon("image/title.jpg");
        this.imageLabel.setIcon(this.imageIcon);
        this.imageLabel.setOpaque(true);
        this.imageLabel.setHorizontalAlignment(JLabel.CENTER);   //이미지 중앙 정렬
        this.add(imageLabel,BorderLayout.NORTH);

        this.loginPanel = new JPanel(); //login, password, 라벨과 입력창을 담은 패널
        this.innerPanel2 = new JPanel(); //Intro라벨과 loginPanel을 담은 패널
        this.buttonPanel = new JPanel(); //버튼을 담은 패널

        this.loginPanel.setLayout(new GridLayout(2,2,30,10));
        this.loginPanel.setBackground(Color.getHSBColor((220f/360),0.65f, 0.42f));

        this.innerPanel2.setLayout(new FlowLayout(FlowLayout.CENTER,500,50));
        this.innerPanel2.setBackground(Color.getHSBColor((220f/360),0.65f, 0.42f));
        this.buttonPanel.setLayout(new GridLayout(1,2,50,10));
        this.buttonPanel.setBackground(Color.getHSBColor((220f/360),0.65f, 0.42f));

        Font f1 = new Font("돋움",Font.BOLD,30);
        Font f2 = new Font("serif",Font.BOLD,15);

        this.LIntro = new JLabel("명지대학교 수강신청시스템",JLabel.CENTER);
        this.LIntro.setHorizontalAlignment(SwingConstants.CENTER);
        this.LIntro.setForeground(Color.WHITE);
        this.LIntro.setFont(f1);
        this.innerPanel2.add(this.LIntro);

        this.LID = new JLabel("ID",JLabel.CENTER);
        this.LID.setFont(f2);
        this.LID.setForeground(Color.WHITE);
        this.LID.setSize(50,30);
        this.loginPanel.add(this.LID);

        this.TID = new JTextField(10);
        this.TID.setFont(f2);
        this.TID.setSize(50,30);
        this.loginPanel.add(this.TID);

        this.LPW = new JLabel("PW",JLabel.CENTER);
        this.LPW.setFont(f2);
        this.LPW.setForeground(Color.WHITE);
        this.LPW.setSize(50,30);
        this.loginPanel.add(this.LPW);

        //입력 내용이 표시되지 않음
        this.TPW = new JPasswordField(10);
        this.TPW.setSize(50,30);
        this.loginPanel.add(this.TPW);

        //button 만들기
        this.loginBt = new JButton("Login");
        this.loginBt.setSize(100,50);
        this.loginBt.setFont(f2);
        this.loginBt.setBackground(Color.getHSBColor((222f/360),0.14f, 0.87f));
        this.buttonPanel.add(this.loginBt);

        this.signUpBt = new JButton("SignUp");
        this.signUpBt.setSize(100,50);
        this.signUpBt.setFont(f2);
        this.signUpBt.setBackground(Color.getHSBColor((222f/360),0.14f, 0.87f));
        this.buttonPanel.add(this.signUpBt);

        this.innerPanel2.add(this.loginPanel);
        this.innerPanel2.add(this.buttonPanel);
        this.add(innerPanel2,BorderLayout.CENTER);
        this.add(this.innerPanel2);

        //button에 기능 추가
        this.loginBt.addActionListener(actionHandler);
        this.signUpBt.addActionListener(actionHandler);

        this.sLogin =new SLogin();
        this.pSignUpDialog = new PSignUpDialog();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public VAccount login() throws IOException { //id가 있는지 없는지 컨트롤러한테 체크해봐야 함.
        String ID = TID.getText();
        String PW = new String((TPW.getPassword()));

        VAccount v = this.sLogin.read(ID,PW);//sLogin는 account 정보를 리턴 시켜 줌.

        if (this.sLogin.login(ID, PW).equals("wrong")) {//id나 비밀번호가 틀린 경우
            int option = JOptionPane.showConfirmDialog(null, "아이디나 비밀번호를 잘못 입력하셨습니다.\n로그인을 다시 시도하시겠습니까?", "로그인", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {//확인 버튼을 누른 경우
                this.TID.setText("");
                this.TPW.setText("");
                this.dispose();
                main.initialize();
            } else {
                option = JOptionPane.showConfirmDialog(null, "수강 신청 시스템을 종료하시겠습니까?");
                if (option == JOptionPane.NO_OPTION) {//확인 버튼을 누른 경우
                    this.TID.setText("");
                    this.TPW.setText("");
                    this.dispose();
                    main.initialize();
                } else System.exit(0);
            }
        } else if (this.sLogin.login(ID, PW).equals("none")) {//계정이 없는 경우
            int result = JOptionPane.showConfirmDialog(null, "존재하지 않는 계정입니다.\n계정 생성 하시겠습니까?", "로그인", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {//확인 버튼을 누른 경우
                this.dispose();
                new PSignUpDialog();
                pSignUpDialog.setVisible(true);  //다른 패널들과 달리 얘는 부모에 등록하지 않고 독립적으로 함
            } else {
                JOptionPane.showMessageDialog(null, "로그인 화면으로 돌아갑니다.");
                this.TID.setText("");
                this.TPW.setText("");
                this.dispose();
                main.initialize();
            }
        } else if (this.sLogin.login(ID, PW).equals("correct")) { //로그인에 성공한 경우
            JOptionPane.showMessageDialog(null, v.getName() + "님 로그인에 성공하였습니다.", "로그인 성공", JOptionPane.PLAIN_MESSAGE); //,"로그인 성공",JOptionPane.OK_OPTION
            this.dispose();
        }return v;
    }

    public class WindowHandler implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {}
        @Override
        public void windowClosing(WindowEvent e) {
            int a= JOptionPane.showConfirmDialog(null, "프로그램을 종료하시겠습니까?","프로그램 종료",JOptionPane.OK_CANCEL_OPTION);
            if(a==JOptionPane.OK_OPTION) System.exit(0);
            else if(a==JOptionPane.CANCEL_OPTION) setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
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
