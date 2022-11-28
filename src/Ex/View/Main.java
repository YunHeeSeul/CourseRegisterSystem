package Ex.View;

import Ex.Global.Locale;
import Ex.ValueObject.VAccount;
import Ex.View.PMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {
    public PLoginDialog loginDialog;
    public ActionHandler actionHandler;

    //1�ܰ� �ʱ�ȭ
    public Main(){}
    //2�ܰ� �ʱ�ȭ
    public void initialize() throws IOException {
        ActionHandler actionHandler = new ActionHandler();

        this.loginDialog = new PLoginDialog(actionHandler); //MainFrame�� �θ�� �ִ� ��

        //OK,Cancel�� �Ǵ��� �ؾ� ��
        this.loginDialog.setVisible(true);  //�ٸ� �гε�� �޸� ��� �θ� ������� �ʰ� ���������� ��
    }
    class ActionHandler implements ActionListener {
        private PSignUpDialog pSignUpDialog;
        @Override
        public void actionPerformed(ActionEvent e) {//�α��� ��ư �׼� �����ϴ� �޼ҵ�
            if(e.getActionCommand().equals(Locale.LOGIN_BUTTON)){   //�α��� ��ư ������ ��
                try {runLogin();}
                catch (IOException ex) {throw new RuntimeException(ex);}
            }
            else if(e.getActionCommand().equals(Locale.SIGNUP_BUTTON)){// ȸ������ ��ư ������ ��
                try {pSignUpDialog = new PSignUpDialog(); }
                catch (IOException e1) {e1.printStackTrace();}
                loginDialog.dispose();
                pSignUpDialog.initialize();  //�ٸ� �гε�� �޸� ��� �θ� ������� �ʰ� ���������� ��
            }
        }
    }

    ///pf
    public void runLogin() throws IOException {
        VAccount vAccount = this.loginDialog.login();
       // this.loginDialog.dispose();

        PMainFrame mainFrame = new PMainFrame(vAccount); //���������ӿ� �ٷ� account ��
        mainFrame.initialize();;
    }

    public void finish(){}

    public static void main(String [] args) throws IOException {
        Main main = new Main();
        //lifeCycle
        main.initialize();
        //main.runLogin();
        main.finish();
    }
}