package Ex.View;

import Ex.View.PMainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {
    public PLoginDialog loginDialog;
    public PSignUpDialog pSignUpDialog;
    public ActionHandler actionHandler;

    public Main(){}
    public void initialize() throws IOException {
        actionHandler = new ActionHandler();

        loginDialog = new PLoginDialog(actionHandler); //MainFrame�� �θ�� �ִ� ��
        pSignUpDialog = new PSignUpDialog();
        //OK,Cancel�� �Ǵ��� �ؾ� ��
        loginDialog.setVisible(true);  //�ٸ� �гε�� �޸� ��� �θ� ������� �ʰ� ���������� ��
    }
    class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {//�α��� ��ư �׼� �����ϴ� �޼ҵ�
            if(e.getActionCommand().equals("Login")){   //�α��� ��ư ������ ��
                try {loginDialog.login();}
                catch (IOException ex) {throw new RuntimeException(ex);}
            }
            else if(e.getActionCommand().equals("SignUp")){// ȸ������ ��ư ������ ��
                try {new PSignUpDialog();}
                catch (IOException e1) {e1.printStackTrace();}
                pSignUpDialog.setVisible(true);  //�ٸ� �гε�� �޸� ��� �θ� ������� �ʰ� ���������� ��
            }
        }
    }

    public void run() throws IOException {
        String name = this.loginDialog.login();
        if(name!=null){
            System.out.println("connect");
            PMainFrame pMainFrame = new PMainFrame(name);
            pMainFrame.initialize();
        }
    }
    public void finish(){}

    public static void main(String [] args) throws IOException {
        Main main = new Main();
        main.initialize();
        main.run();
        main.finish();

//        PMainFrame mainFrame = new PMainFrame();
//        mainFrame.initialize();
//        mainFrame.setVisible(true);
    }
}