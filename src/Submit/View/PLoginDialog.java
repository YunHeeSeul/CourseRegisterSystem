package Submit.View;

import Submit.Global.Constants;
import Submit.Global.Locale;
import Submit.Model.SLogin;
import Submit.ValueObject.VAccount;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class PLoginDialog extends JDialog{//JDialog�� Ȯ���ߴٴ� ��
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

    public PLoginDialog(Main.ActionHandler actionHandler) throws IOException{//JDialog�� ��ӹ���. Ȯ���� ����. �׸��� �ʿ��� ��� �߰��� ��
//        super(parent);//���� JDialog�� constructor�� �ҷ��ִ� ��
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
        this.imageLabel.setHorizontalAlignment(JLabel.CENTER);   //�̹��� �߾� ����
        this.add(imageLabel,BorderLayout.NORTH);

        this.loginPanel = new JPanel(); //login, password, �󺧰� �Է�â�� ���� �г�
        this.innerPanel2 = new JPanel(); //Intro�󺧰� loginPanel�� ���� �г�
        this.buttonPanel = new JPanel(); //��ư�� ���� �г�

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

        //�Է� ������ ǥ�õ��� ����
        this.TPW = new JPasswordField(Constants.LABEL_COLUMNS);
        this.TPW.setSize(Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        this.loginPanel.add(this.TPW);

        //button �����
        this.loginBt = new JButton(Locale.LOGIN_BUTTON);
        this.loginBt.setSize(Constants.BUTTON_WIDTH,Constants.BUTTON_HEIGHT);
        this.getRootPane().setDefaultButton(loginBt); //ó�� ������ login ��ư��. enterġ�� ����
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


        //button�� ��� �߰�
        this.loginBt.addActionListener(actionHandler);
        this.signUpBt.addActionListener(actionHandler);

        this.sLogin =new SLogin();
        this.pSignUpDialog = new PSignUpDialog();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public VAccount login() throws IOException { //id�� �ִ��� ������ ��Ʈ�ѷ����� üũ�غ��� ��.
        String ID = TID.getText();
        String PW = new String((TPW.getPassword()));

        VAccount v = this.sLogin.read(ID,PW);//sLogin�� account ������ ���� ���� ��.

        if (this.sLogin.login(ID, PW).equals(Locale.WRONG)) {//id�� ��й�ȣ�� Ʋ�� ���
            int option = JOptionPane.showConfirmDialog(null, Locale.LLoginDialog.WRONG_LOGIN_MESSAGE, Locale.LLoginDialog.WRONG_LOGIN_TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {//Ȯ�� ��ư�� ���� ���
                this.TID.setText(Locale.BLANK);
                this.TPW.setText(Locale.BLANK);
                this.dispose();
                main.initialize();
            } else {
                option = JOptionPane.showConfirmDialog(null, Locale.EXIT_SYSTEM_MESSAGE);
                if (option == JOptionPane.NO_OPTION) {//Ȯ�� ��ư�� ���� ���
                    this.TID.setText(Locale.BLANK);
                    this.TPW.setText(Locale.BLANK);
                    this.dispose();
                    main.initialize();
                } else System.exit(0);
            }
        } else if (this.sLogin.login(ID, PW).equals(Locale.NONE)) {//������ ���� ���
            int result = JOptionPane.showConfirmDialog(null, Locale.LLoginDialog.NONE_LOGIN_MESSAGE, Locale.LLoginDialog.NONE_LOGIN_TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {//Ȯ�� ��ư�� ���� ���
                this.dispose();
                new PSignUpDialog();
                pSignUpDialog.setVisible(true);  //�ٸ� �гε�� �޸� ��� �θ� ������� �ʰ� ���������� ��
            } else {
                JOptionPane.showMessageDialog(null, Locale.LLoginDialog.BACK_TO_LOGIN);
                this.TID.setText(Locale.BLANK);
                this.TPW.setText(Locale.BLANK);
                this.dispose();
                main.initialize();
            }
        } else if (this.sLogin.login(ID, PW).equals(Locale.CORRECT)) { //�α��ο� ������ ���
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
