package Ex.View;

import Ex.ValueObject.VAccount;
import Ex.View.PMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {
    public PLoginDialog loginDialog;
    public PSignUpDialog pSignUpDialog;
    public ActionHandler actionHandler;

    //1�ܰ� �ʱ�ȭ
    public Main(){}
    //2�ܰ� �ʱ�ȭ
    public void initialize() throws IOException {
        ActionHandler actionHandler = new ActionHandler();

        this.loginDialog = new PLoginDialog(actionHandler); //MainFrame�� �θ�� �ִ� ��
        this.pSignUpDialog = new PSignUpDialog();
        //OK,Cancel�� �Ǵ��� �ؾ� ��
        this.loginDialog.setVisible(true);  //�ٸ� �гε�� �޸� ��� �θ� ������� �ʰ� ���������� ��
    }
    class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {//�α��� ��ư �׼� �����ϴ� �޼ҵ�
            try {
                run();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            //            if(e.getActionCommand().equals("Login")){   //�α��� ��ư ������ ��
//                try {loginDialog.login();}
//                catch (IOException ex) {throw new RuntimeException(ex);}
//            }
//            else if(e.getActionCommand().equals("SignUp")){// ȸ������ ��ư ������ ��
//                try {new PSignUpDialog(); }
//                catch (IOException e1) {e1.printStackTrace();}
//                loginDialog.dispose();
//                pSignUpDialog.setVisible(true);  //�ٸ� �гε�� �޸� ��� �θ� ������� �ʰ� ���������� ��
//            }
        }
    }
//mine
//    public void run() throws IOException {
//        String name = this.loginDialog.login();
//        if(name!=null){
//            System.out.println("connect");
//            PMainFrame pMainFrame = new PMainFrame(name);
//            pMainFrame.initialize();
//        }
//    }
    ///pf
    public void run() throws IOException {
        VAccount vAccount = loginDialog.login();
        loginDialog.dispose();

        if(vAccount!=null) { //���������� ���� �޾ƿ���
            PMainFrame mainFrame = new PMainFrame(vAccount); //���������ӿ� �ٷ� account ��
            mainFrame.initialize();;
        }
    }
    public void finish(){}

    public static void main(String [] args) throws IOException {
        Main main = new Main();
        //lifeCycle
        main.initialize();
        main.run();
        main.finish();
    }
}