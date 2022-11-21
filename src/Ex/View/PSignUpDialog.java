package Ex.View;

import Ex.Model.SLogin;
import Ex.ValueObject.VAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class PSignUpDialog extends JDialog{//JDialog를 확장했다는 것

    private static final long serialVersionUID = 1L;

    public Main main;
    //components
    private SLogin sLogin;
    private VAccount vAccount;
    //    private EAccount eAccount;
    private JLabel LIntro,LID,LPW,LName, LEmail,LFaculty,LMajor, LStatus, LPhoneNum, LSex, LGrade;
    private JTextField TID, TName, TEmail, TPhoneNum;
    private JPasswordField TPW;
    private JButton signUpBt, cancelBt, checkBt;
    private JPanel signUpPanel, innerPanel2, buttonPanel;
    private JComboBox gradeBox, sexBox, facultyBox,majorBox;
    private PLoginDialog pLoginDialog;
    private JFrame parent;
    private WindowHandler windowHandler;

    public PSignUpDialog() throws IOException{//JDialog를 상속받음. 확장한 것임. 그리고 필요한 기능 추가한 것
//        super(parent);//원래 JDialog의 constructor를 불러주는 것
        this.setModal(true);//부모를 블라킹
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout(0,10));
        this.setSize(900,900);
        this.setLocation(178,0);
        this.windowHandler=new WindowHandler();
        this.addWindowListener(windowHandler);

        Font f1 = new Font("나눔고딕",Font.BOLD,30);
        Font f2 = new Font("나눔고딕",Font.BOLD,15);

        main = new Main();

        signUpPanel = new JPanel();
        innerPanel2 = new JPanel(); //Intro라벨과 loginPanel을 담은 패널
        buttonPanel = new JPanel(); //버튼을 담은 패널

        signUpPanel.setLayout(new GridLayout(10,2,50,10));
        signUpPanel.setBackground(Color.getHSBColor((222f/360),0.14f, 0.87f));
        innerPanel2.setLayout(new FlowLayout(FlowLayout.CENTER,500,50));
        innerPanel2.setBackground(Color.getHSBColor((222f/360),0.14f, 0.87f));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,500,10));
        buttonPanel.setBackground(Color.getHSBColor((222f/360),0.14f, 0.87f));

        LIntro = new JLabel("명지대학교 학생 등록",JLabel.CENTER);
        LIntro.setHorizontalAlignment(SwingConstants.CENTER);
        LIntro.setFont(f1);
        innerPanel2.add(LIntro);

        LID = new JLabel("ID",JLabel.CENTER);
        LID.setFont(f2);
        LID.setSize(50,30);
        signUpPanel.add(LID);
        TID = new JTextField(10);
        TID.setFont(f2);
        TID.setSize(50,30);
        signUpPanel.add(TID);

        LStatus = new JLabel("");
        LStatus.setFont(f2);
        LStatus.setSize(80,30);
        LStatus.setForeground(Color.BLUE);
        signUpPanel.add(LStatus);
        checkBt = new JButton("중복 확인");
        checkBt.setFont(f2);
        checkBt.setSize(20,30);
        signUpPanel.add(checkBt);

        LPW = new JLabel("PW",JLabel.CENTER);
        LPW.setFont(f2);
        LPW.setSize(50,30);
        signUpPanel.add(LPW);
        TPW = new JPasswordField(10);
        TPW.setSize(50,30);
        signUpPanel.add(TPW);

        LName = new JLabel("이름",JLabel.CENTER);
        LName.setFont(f2);
        LName.setSize(50,30);
        signUpPanel.add(LName);

        TName = new JTextField(10);
        TName.setFont(f2);
        TName.setSize(50,30);
        signUpPanel.add(TName);

        LPhoneNum = new JLabel("전화번호",JLabel.CENTER);
        LPhoneNum.setFont(f2);
        LPhoneNum.setSize(50,30);
        signUpPanel.add(LPhoneNum);

        TPhoneNum = new JTextField("-생략하고 입력",10);
        TPhoneNum.setFont(f2);
        TPhoneNum.setSize(50,30);
        signUpPanel.add(TPhoneNum);

        LEmail = new JLabel("E-Mail",JLabel.CENTER);
        LEmail.setFont(f2);
        LEmail.setSize(50,30);
        signUpPanel.add(LEmail);

        TEmail = new JTextField(10);
        TEmail.setFont(f2);
        TEmail.setSize(50,30);
        signUpPanel.add(TEmail);

        LFaculty = new JLabel("학부",JLabel.CENTER);
        LFaculty.setFont(f2);
        LFaculty.setSize(50,30);
        signUpPanel.add(LFaculty);

        facultyBox = new JComboBox();
        facultyBox.setModel(new DefaultComboBoxModel(new String[]{"인문대학", "사회과학대학", "경영대학", "법과대학","ICT융합대학","미래융합대학","자연과학대학","공과대학","예술체육대학","건축대학","방목기초교육대학","국제학부"}));  //model=>항목 입력
        facultyBox.setSelectedIndex(0); //selectedIndex=>처음 선택될 항목 번호
        facultyBox.setFont(f2);
        facultyBox.setSize(50,30);
        signUpPanel.add(facultyBox);

        LMajor = new JLabel("Major",JLabel.CENTER);
        LMajor.setFont(f2);
        LMajor.setSize(50,30);
        signUpPanel.add(LMajor);

        majorBox = new JComboBox();
        majorBox.setModel(new DefaultComboBoxModel(new String[]{"1","2"}));  //model=>항목 입력
        majorBox.setSelectedIndex(0); //selectedIndex=>처음 선택될 항목 번호
        majorBox.setFont(f2);
        majorBox.setSize(50,30);
        signUpPanel.add(majorBox);

        LGrade = new JLabel("학년",JLabel.CENTER);
        LGrade.setFont(f2);
        LGrade.setSize(50,30);
        signUpPanel.add(LGrade);

        gradeBox = new JComboBox();
        gradeBox.setModel(new DefaultComboBoxModel(new String[]{"1학년", "2학년", "3학년", "4학년"}));  //model=>항목 입력
        gradeBox.setSelectedIndex(0); //selectedIndex=>처음 선택될 항목 번호
        gradeBox.setFont(f2);
        gradeBox.setSize(50,30);
        signUpPanel.add(gradeBox);

        LSex = new JLabel("성별",JLabel.CENTER);
        LSex.setFont(f2);
        LSex.setSize(50,30);
        signUpPanel.add(LSex);

        sexBox = new JComboBox();
        sexBox.setModel(new DefaultComboBoxModel(new String[] {"여자", "남자"}));
        sexBox.setSelectedIndex(0);
        sexBox.setFont(f2);
        sexBox.setSize(50,30);
        signUpPanel.add(sexBox);

        //button 만들기
        signUpBt = new JButton("등록");
        signUpBt.setSize(100,50);
        buttonPanel.add(signUpBt);

        cancelBt = new JButton("취소");
        cancelBt.setSize(100,50);
        buttonPanel.add(cancelBt);

        innerPanel2.add(signUpPanel);
        innerPanel2.add(buttonPanel);
        this.add(innerPanel2,BorderLayout.CENTER);

        ActionHandler actionHandler = new ActionHandler();

        //button에 기능 추가
        signUpBt.addActionListener(actionHandler);
        cancelBt.addActionListener(actionHandler);
        checkBt.addActionListener(actionHandler);

        this.sLogin =new SLogin();
        this.vAccount =new VAccount();
    }
    public void signUp() throws IOException{
        String ID = TID.getText();
        String PW = new String((TPW.getPassword()));
        String name = TName.getText();
        String phoneNum = TPhoneNum.getText();
        String eMain = TEmail.getText();
        String faculty = String.valueOf(facultyBox.getModel());
        String major = String.valueOf(majorBox.getModel());
        String grade = String.valueOf(gradeBox.getModel());
        String sex = String.valueOf(sexBox.getModel());

        String info = ID+" "+PW+" "+name+" "+phoneNum+" "+eMain+" "+faculty+" "+major+" "+grade+" "+sex;

        if(LStatus.getText().equals("계정 생성이 가능합니다.")) {
            if(this.sLogin.signUp(info)) {
                JOptionPane.showMessageDialog(null, "계정 생성에 성공하셨습니다.");
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(null, "계정 생성에 실패하셨습니다.");
                new PSignUpDialog();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "이미 존재하는 계정입니다.\n로그인 화면으로 돌아갑니다.");
            new PLoginDialog(main.actionHandler);
        }
    }

    public void checkID() {
        String ID = TID.getText();
        if(this.sLogin.match(ID)) {LStatus.setText("계정 생성이 가능합니다.");System.out.print("계정 생성 가능");}
        else LStatus.setText("이미 등록된 학생입니다.");
    }

    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {// 회원가입 버튼 액션 설정하는 메소드
            if(e.getActionCommand().equals("SignUp")){//가입 버튼 눌렀을 때
                try {signUp();}
                catch (IOException e1) {e1.printStackTrace();}
            } else if (e.getActionCommand().equals("중복 확인")) {System.out.print("중복 확인"); checkID();
            } else if (e.getActionCommand().equals("취소")) {
                try {pLoginDialog=new PLoginDialog(main.actionHandler);}
                catch (IOException e1) {e1.printStackTrace();}
                pLoginDialog.setVisible(true);
            }
        }
    }

    public class WindowHandler implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {}
        @Override
        public void windowClosing(WindowEvent e) {
            int a= JOptionPane.showConfirmDialog(null, "계정 생성을 종료하시겠습니까?","계정 생성 종료",JOptionPane.OK_CANCEL_OPTION);
            if(a==JOptionPane.OK_OPTION) { JOptionPane.showMessageDialog(null, "로그인 화면으로 돌아갑니다.") ;dispose();}
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

