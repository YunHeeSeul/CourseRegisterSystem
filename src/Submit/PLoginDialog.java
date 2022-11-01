package Submit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PLoginDialog extends JDialog{//JDialog를 확장했다는 것

    private static final long serialVersionUID = 1L;

    //components
    private SLogin sLogin;
    private JLabel LIntro,LID,LPW,imageLabel;
    private JTextField TID;
    private JPasswordField TPW;
    private JButton loginBt;
    private JPanel loginPanel, innerPanel2, buttonPanel;
    private ImageIcon imageIcon;

    public PLoginDialog(JFrame parent){//JDialog를 상속받음. 확장한 것임. 그리고 필요한 기능 추가한 것
        super(parent);//원래 JDialog의 constructor를 불러주는 것
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout(0,10));
        this.setSize(900,900);
        this.setLocation(178,0);
//        this.setBackground(Color.getHSBColor((222f/360),0.14f, 0.87f));


        imageLabel = new JLabel();
        imageLabel.setBackground(Color.getHSBColor((222f/360),0.14f, 0.87f));
        imageIcon = new ImageIcon("image/title.jpg");
        imageLabel.setIcon(imageIcon);
        imageLabel.setOpaque(true);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);   //이미지 중앙 정렬
        this.add(imageLabel,BorderLayout.NORTH);

        loginPanel = new JPanel(); //login, password, 라벨과 입력창을 담은 패널
        innerPanel2 = new JPanel(); //Intro라벨과 loginPanel을 담은 패널
        buttonPanel = new JPanel(); //버튼을 담은 패널

        loginPanel.setLayout(new GridLayout(2,2,50,10));
        loginPanel.setBackground(Color.getHSBColor((222f/360),0.14f, 0.87f));

        innerPanel2.setLayout(new FlowLayout(FlowLayout.CENTER,500,50));
        innerPanel2.setBackground(Color.getHSBColor((222f/360),0.14f, 0.87f));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,500,10));
        buttonPanel.setBackground(Color.getHSBColor((222f/360),0.14f, 0.87f));

        //라벨 만들기
        Font f1 = new Font("나눔고딕",Font.BOLD,30);
        Font f2 = new Font("serif",Font.BOLD,15);

        LIntro = new JLabel("명지대학교 수강신청시스템",JLabel.CENTER);
        LIntro.setHorizontalAlignment(SwingConstants.CENTER);
        LIntro.setFont(f1);
        innerPanel2.add(LIntro);

        LID = new JLabel("ID",JLabel.CENTER);
        LID.setFont(f2);
        LID.setSize(50,30);
        loginPanel.add(LID);

        TID = new JTextField(10);
        TID.setFont(f2);
        TID.setSize(50,30);
        loginPanel.add(TID);

        LPW = new JLabel("PW",JLabel.CENTER);
        LPW.setFont(f2);
        LPW.setSize(50,30);
        loginPanel.add(LPW);

        //입력 내용이 표시되지 않음
        TPW = new JPasswordField(10);
        TPW.setSize(50,30);
        loginPanel.add(TPW);

        //button 만들기
        loginBt = new JButton("Login");
        loginBt.setSize(100,50);
        buttonPanel.add(loginBt);

        innerPanel2.add(loginPanel);
        innerPanel2.add(buttonPanel);
        this.add(innerPanel2,BorderLayout.CENTER);

        ActionHandler actionHandler = new ActionHandler();
        //button에 기능 추가
        loginBt.addActionListener(actionHandler);

        this.sLogin =new SLogin();
    }
    public void login(){
        //id가 있는지 없는지 컨트롤러한테 체크해봐야 함.
        String ID = TID.getText();
        String PW = new String((TPW.getPassword()));

        VAccount vAccount=this.sLogin.login(ID,PW);//sLogin는 얘의 account 정보를 리턴 시켜 줌.

        if(vAccount==null){//id가 없거나 비밀번호가 틀린 경우
            JOptionPane.showMessageDialog(null,"아이디나 비밀번호를 잘못 입력하셨습니다.");
        }
        else
            JOptionPane.showMessageDialog(null,vAccount.getName()+"님 로그인에 성공하였습니다.");
    }

    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {//로그인 버튼 액션 설정하는 메소드
            if(e.getActionCommand().equals("Login")){   //로그인 버튼 눌렀을 때
                login();
            }
        };
    }
}

