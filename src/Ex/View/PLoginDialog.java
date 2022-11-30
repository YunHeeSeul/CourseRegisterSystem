package Ex.View;

import Ex.Global.Constants;
import Ex.Global.Locale;
import Ex.Model.SLogin;
import Ex.ValueObject.VAccount;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.setLayout(new BorderLayout(Constants.LAYOUT_HGAP,Constants.LAYOUT_WGAP));
        this.setSize(Constants.WIDTH,Constants.HEIGHT);
        this.setLocation(Constants.LOCATION_X,Constants.LOCATION_Y);
        this.windowHandler = new WindowHandler();
        this.addWindowListener(windowHandler);

        this.imageLabel = new JLabel();
        this.imageLabel.setBackground(Constants.LAVENDAR);
        this.imageIcon = new ImageIcon(Locale.LLoginDialog.IMAGEICON);
        this.imageLabel.setIcon(this.imageIcon);
        this.imageLabel.setOpaque(true);
        this.imageLabel.setHorizontalAlignment(JLabel.CENTER);   //이미지 중앙 정렬
        this.add(imageLabel,BorderLayout.NORTH);

        this.loginPanel = new JPanel(); //login, password, 라벨과 입력창을 담은 패널
        this.innerPanel2 = new JPanel(); //Intro라벨과 loginPanel을 담은 패널
        this.buttonPanel = new JPanel(); //버튼을 담은 패널

        this.loginPanel.setLayout(new GridLayout(Constants.CLoginDialog.LOGIN_ROW,Constants.CLoginDialog.LOGIN_COLUMN,Constants.CLoginDialog.LOGIN_HGAP,Constants.CLoginDialog.LOGIN_VGAP));
        this.loginPanel.setBackground(Constants.NAVY);

        this.innerPanel2.setLayout(new FlowLayout(FlowLayout.CENTER,Constants.CLoginDialog.INNER_HGAP,Constants.CLoginDialog.INNER_VGAP));
        this.innerPanel2.setBackground(Constants.NAVY);
        this.buttonPanel.setLayout(new GridLayout(Constants.CLoginDialog.BUTTON_ROW,Constants.CLoginDialog.BUTTON_COLUMN,Constants.CLoginDialog.BUTTON_HGAP,Constants.CLoginDialog.BUTTON_VGAP));
        this.buttonPanel.setBackground(Constants.NAVY);

        Font f1 = new Font(Constants.FONT1_NAME,Font.BOLD,Constants.FONT1_SIZE);
        Font f2 = new Font(Constants.FONT2_NAME,Font.BOLD,Constants.FONT2_SIZE);

        this.LIntro = new JLabel(Constants.CLoginDialog.INTRO_LABEL,JLabel.CENTER);
        this.LIntro.setHorizontalAlignment(SwingConstants.CENTER);
        this.LIntro.setForeground(Color.WHITE);
        this.LIntro.setFont(f1);
        this.innerPanel2.add(this.LIntro);

        this.LID = new JLabel(Locale.LLoginDialog.ID_LABEL,JLabel.CENTER);
        this.LID.setFont(f2);
        this.LID.setForeground(Color.WHITE);
        this.LID.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        this.loginPanel.add(this.LID);

        this.TID = new JTextField(Constants.LABEL_COLUMNS);
        this.TID.setFont(f2);
        this.TID.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        this.loginPanel.add(this.TID);

        this.LPW = new JLabel(Locale.LLoginDialog.PW_LABEL,JLabel.CENTER);
        this.LPW.setFont(f2);
        this.LPW.setForeground(Color.WHITE);
        this.LPW.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        this.loginPanel.add(this.LPW);

        //입력 내용이 표시되지 않음
        this.TPW = new JPasswordField(Constants.LABEL_COLUMNS);
        this.TPW.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        this.loginPanel.add(this.TPW);

        //button 만들기
        this.loginBt = new JButton(Locale.LOGIN_BUTTON);
        this.loginBt.setSize(Constants.BUTTON_WIDTH,Constants.BUTTON_HEIGHT);
        this.getRootPane().setDefaultButton(loginBt); //처음 세팅을 login 버튼에. enter치면 실행
        this.loginBt.setFont(f2);
        this.loginBt.setBackground(Constants.LAVENDAR);
        this.buttonPanel.add(this.loginBt);

        this.signUpBt = new JButton(Locale.SIGNUP_BUTTON);
        this.signUpBt.setSize(Constants.BUTTON_WIDTH,Constants.BUTTON_HEIGHT);
        this.signUpBt.setFont(f2);
        this.signUpBt.setBackground(Constants.LAVENDAR);
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

        if (this.sLogin.login(ID, PW).equals(Locale.WRONG)) {//id나 비밀번호가 틀린 경우
            int option = JOptionPane.showConfirmDialog(null, Locale.LLoginDialog.WRONG_LOGIN_MESSAGE, Locale.LLoginDialog.WRONG_LOGIN_TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {//확인 버튼을 누른 경우
                this.TID.setText(Locale.BLANK);
                this.TPW.setText(Locale.BLANK);
                this.dispose();
                main.initialize();
            } else {
                option = JOptionPane.showConfirmDialog(null, Locale.EXIT_SYSTEM_MESSAGE);
                if (option == JOptionPane.NO_OPTION) {//확인 버튼을 누른 경우
                    this.TID.setText(Locale.BLANK);
                    this.TPW.setText(Locale.BLANK);
                    this.dispose();
                    main.initialize();
                } else System.exit(0);
            }
        } else if (this.sLogin.login(ID, PW).equals(Locale.NONE)) {//계정이 없는 경우
            int result = JOptionPane.showConfirmDialog(null, Locale.LLoginDialog.NONE_LOGIN_MESSAGE, Locale.LLoginDialog.NONE_LOGIN_TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {//확인 버튼을 누른 경우
                this.dispose();
                new PSignUpDialog();
                pSignUpDialog.setVisible(true);  //다른 패널들과 달리 얘는 부모에 등록하지 않고 독립적으로 함
            } else {
                JOptionPane.showMessageDialog(null, Locale.LLoginDialog.BACK_TO_LOGIN);
                this.TID.setText(Locale.BLANK);
                this.TPW.setText(Locale.BLANK);
                this.dispose();
                main.initialize();
            }
        } else if (this.sLogin.login(ID, PW).equals(Locale.CORRECT)) { //로그인에 성공한 경우
            JOptionPane.showMessageDialog(null, v.getName() + Locale.LLoginDialog.CORRECT_LOGIN_MESSAGE, Locale.LLoginDialog.CORRECT_LOGIN_TITLE, JOptionPane.PLAIN_MESSAGE);
            this.dispose();
        }return v;
    }

    public class WindowHandler implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {}
        @Override
        public void windowClosing(WindowEvent e) {
            int a= JOptionPane.showConfirmDialog(null, Locale.EXIT_SYSTEM_MESSAGE,Locale.EXIT_TITLE,JOptionPane.OK_CANCEL_OPTION);
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
