package Submit.View;

import Submit.Global.Constants;
import Submit.Global.Locale;
import Submit.Model.SDirectory;
import Submit.Model.SLogin;
import Submit.ValueObject.VAccount;
import Submit.ValueObject.VDirectory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Vector;

public class PSignUpDialog extends JDialog{//JDialog를 확장했다는 것
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
    //components
    private SLogin sLogin;
    private VAccount vAccount;
    private JLabel LIntro,LID,LPW,LName, LEmail,LFaculty,LMajor, LStatus, LPhoneNum, LSex, LGrade, LCampus;
    private JTextField TID, TName, TEmail, TPhoneNum, TDepartment;
    private JPasswordField TPW;
    private JButton signUpBt, cancelBt, checkBt;
    private JPanel signUpPanel, innerPanel2, buttonPanel;
    private JComboBox gradeBox, sexBox, campusBox, collegeBox;
    private WindowHandler windowHandler;
    private Main main;

    public PSignUpDialog() throws IOException{//JDialog를 상속받음. 확장한 것임. 그리고 필요한 기능 추가한 것
//        super(parent);//원래 JDialog의 constructor를 불러주는 것
        this.setModal(true);//부모를 블라킹
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout(Constants.LAYOUT_HGAP,Constants.LAYOUT_WGAP));
        this.setSize(Constants.WIDTH,Constants.HEIGHT);
        this.setLocation(Constants.LOCATION_X,Constants.LOCATION_Y);
        this.windowHandler=new WindowHandler();
        this.addWindowListener(windowHandler);

        Font f1 = new Font(Constants.FONT1_NAME,Font.BOLD,Constants.FONT1_SIZE);
        Font f2 = new Font(Constants.FONT2_NAME,Font.BOLD,Constants.FONT2_SIZE);

        signUpPanel = new JPanel();
        innerPanel2 = new JPanel(); //Intro라벨과 loginPanel을 담은 패널
        buttonPanel = new JPanel(); //버튼을 담은 패널

        signUpPanel.setLayout(new GridLayout(Constants.CSignUPPanel.SIGNUP_ROW,Constants.CSignUPPanel.SIGNUP_COLUMN,Constants.CSignUPPanel.SIGNUP_HGAP,Constants.CSignUPPanel.SIGNUP_VGAP));
        signUpPanel.setBackground(Constants.LAVENDAR);
        innerPanel2.setLayout(new FlowLayout(FlowLayout.CENTER,Constants.CSignUPPanel.INNER_HGAP,Constants.CSignUPPanel.INNER_VGAP));
        innerPanel2.setBackground(Constants.LAVENDAR);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,Constants.BUTTON_HGAP,Constants.BUTTON_VGAP));
        buttonPanel.setBackground(Constants.LAVENDAR);

        LIntro = new JLabel(Constants.CSignUPPanel.INTRO_LABEL,JLabel.CENTER);
        LIntro.setHorizontalAlignment(SwingConstants.CENTER);
        LIntro.setFont(f1);
        innerPanel2.add(LIntro);

        LID = new JLabel("ID",JLabel.CENTER);
        LID.setFont(f2);
        LID.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(LID);
        TID = new JTextField(10);
        TID.setFont(f2);
        TID.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(TID);

        LStatus = new JLabel(Locale.BLANK);
        LStatus.setFont(f2);
        LStatus.setSize(Constants.CSignUPPanel.STATUS_WIDTH,Constants.CSignUPPanel.STATUS_HEIGHT);
        LStatus.setForeground(Color.BLUE);
        signUpPanel.add(LStatus);
        checkBt = new JButton(Constants.CSignUPPanel.CHECKBT);
        checkBt.setFont(f2);
        checkBt.setSize(Constants.CSignUPPanel.CHECKBT_WIDTH, Constants.CSignUPPanel.CHECKBT_HEIGHT);
        signUpPanel.add(checkBt);

        LPW = new JLabel("PW",JLabel.CENTER);
        LPW.setFont(f2);
        LPW.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(LPW);
        TPW = new JPasswordField(Constants.LABEL_COLUMNS);
        TPW.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(TPW);

        LName = new JLabel("이름",JLabel.CENTER);
        LName.setFont(f2);
        LName.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(LName);
        TName = new JTextField(Constants.LABEL_COLUMNS);
        TName.setFont(f2);
        TName.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(TName);

        LPhoneNum = new JLabel("전화번호",JLabel.CENTER);
        LPhoneNum.setFont(f2);
        LPhoneNum.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(LPhoneNum);
        TPhoneNum = new JTextField(Constants.LABEL_COLUMNS);
        TPhoneNum.setFont(f2);
        TPhoneNum.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(TPhoneNum);

        LEmail = new JLabel("E-Mail",JLabel.CENTER);
        LEmail.setFont(f2);
        LEmail.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(LEmail);
        TEmail = new JTextField(Constants.LABEL_COLUMNS);
        TEmail.setFont(f2);
        TEmail.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(TEmail);

        LCampus = new JLabel("캠퍼스",JLabel.CENTER);
        LCampus.setFont(f2);
        LCampus.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(LCampus);
        campusBox = new JComboBox();
        campusBox.setModel(new DefaultComboBoxModel(new String[]{"인문", "용인"}));  //model=>항목 입력
        campusBox.setSelectedIndex(0); //selectedIndex=>처음 선택될 항목 번호
        campusBox.setFont(f2);
        campusBox.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(campusBox);

        LFaculty = new JLabel("대학",JLabel.CENTER);
        LFaculty.setFont(f2);
        LFaculty.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(LFaculty);
        collegeBox = new JComboBox();
        collegeBox.setModel(new DefaultComboBoxModel(new String[]{"인문대학", "사회과학대학", "경영대학", "법과대학","ICT융합대학","미래융합대학","자연과학대학","공과대학","예술체육대학","건축대학","방목기초교육대학","국제학부"}));  //model=>항목 입력
        collegeBox.setSelectedIndex(0); //selectedIndex=>처음 선택될 항목 번호
        collegeBox.setFont(f2);
        collegeBox.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(collegeBox);

        LMajor = new JLabel("전공",JLabel.CENTER);
        LMajor.setFont(f2);
        LMajor.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(LMajor);
        TDepartment = new JTextField(Constants.LABEL_COLUMNS);
        TDepartment.setFont(f2);
        TDepartment.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(TDepartment);

        LGrade = new JLabel("학년",JLabel.CENTER);
        LGrade.setFont(f2);
        LGrade.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(LGrade);
        gradeBox = new JComboBox();
        gradeBox.setModel(new DefaultComboBoxModel(new String[]{"1학년", "2학년", "3학년", "4학년"}));  //model=>항목 입력
        gradeBox.setSelectedIndex(0); //selectedIndex=>처음 선택될 항목 번호
        gradeBox.setFont(f2);
        gradeBox.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(gradeBox);

        LSex = new JLabel("성별",JLabel.CENTER);
        LSex.setFont(f2);
        LSex.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(LSex);
        sexBox = new JComboBox();
        sexBox.setModel(new DefaultComboBoxModel(new String[] {"여자", "남자"}));
        sexBox.setSelectedIndex(0);
        sexBox.setFont(f2);
        sexBox.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        signUpPanel.add(sexBox);

        //button 만들기
        signUpBt = new JButton(Constants.CSignUPPanel.SIGNUPBT);
        signUpBt.setSize(Constants.BUTTON_WIDTH,Constants.BUTTON_HEIGHT);
        buttonPanel.add(signUpBt);

        cancelBt = new JButton(Constants.CSignUPPanel.CANCELBT);
        cancelBt.setSize(Constants.BUTTON_WIDTH,Constants.BUTTON_HEIGHT);
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
        this.main = new Main();
//        this.updateComboBox(null,null);
    }

    public void signUp() throws IOException {
        String ID = TID.getText();
        String PW = new String((TPW.getPassword()));
        String name = TName.getText();
        String phoneNum = TPhoneNum.getText();
        String eMail = TEmail.getText();
        String campus = (String) campusBox.getSelectedItem();
        String college = (String) collegeBox.getSelectedItem();
        String department = TDepartment.getText();
        String grade = (String) gradeBox.getSelectedItem();
        String sex = (String) sexBox.getSelectedItem();

        String info = ID + " " + PW + " " + name + " " + phoneNum + " " + eMail + " " + campus + " " + college + " " + department + " " + grade + " " + sex;

        if (LStatus.getText().equals(Locale.LSignUpPanel.CAN)) {
            if (this.sLogin.signUp(info)) {
                JOptionPane.showMessageDialog(null, Locale.LSignUpPanel.SUCCESS);
                disposeSignup();
                main.initialize();
            } else {
                JOptionPane.showMessageDialog(null, Locale.LSignUpPanel.FAIL);
                disposeSignup();
                new PSignUpDialog();
                this.initialize();
            }
        } else {
            JOptionPane.showMessageDialog(null, Locale.LSignUpPanel.CANNOT+"\n"+Locale.LSignUpPanel.BACK_TO_LOGIN);
            disposeSignup();
            main.initialize();
        }
    }

    public void checkID() {
        String ID = TID.getText();
        if(this.sLogin.match(ID)) LStatus.setText(Locale.LSignUpPanel.CAN);
        else LStatus.setText(Locale.LSignUpPanel.CANNOT);
    }

    public class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {// 회원가입 버튼 액션 설정하는 메소드
            if(e.getActionCommand().equals(Constants.CSignUPPanel.SIGNUPBT)){//가입 버튼 눌렀을 때
                try {signUp();}
                catch (IOException e1) {e1.printStackTrace();}
            } else if (e.getActionCommand().equals(Constants.CSignUPPanel.CHECKBT)) checkID();
            else if (e.getActionCommand().equals(Constants.CSignUPPanel.CANCELBT)) {
                try {disposeSignup(); main.initialize();}
                catch (IOException e1) {e1.printStackTrace();}
            }
        }
    }
    public void disposeSignup(){
        this.dispose();
    }
    public void initialize() {
        this.setVisible(true);
    }

    public class WindowHandler implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {}
        @Override
        public void windowClosing(WindowEvent e) {
            int a= JOptionPane.showConfirmDialog(null, Locale.LSignUpPanel.EXIT_MESSAGE,Locale.LSignUpPanel.EXIT_TITLE,JOptionPane.OK_CANCEL_OPTION);
            if(a==JOptionPane.OK_OPTION) { JOptionPane.showMessageDialog(null, Locale.LSignUpPanel.BACK_TO_LOGIN) ;dispose();
                try {disposeSignup(); main.initialize();
                } catch (IOException ex) {ex.printStackTrace();}
            }
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

