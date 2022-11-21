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

        loginDialog = new PLoginDialog(actionHandler); //MainFrame을 부모로 주는 것
        pSignUpDialog = new PSignUpDialog();
        //OK,Cancel을 판단을 해야 함
        loginDialog.setVisible(true);  //다른 패널들과 달리 얘는 부모에 등록하지 않고 독립적으로 함
    }
    class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {//로그인 버튼 액션 설정하는 메소드
            if(e.getActionCommand().equals("Login")){   //로그인 버튼 눌렀을 때
                try {loginDialog.login();}
                catch (IOException ex) {throw new RuntimeException(ex);}
            }
            else if(e.getActionCommand().equals("SignUp")){// 회원가입 버튼 눌렀을 때
                try {new PSignUpDialog();}
                catch (IOException e1) {e1.printStackTrace();}
                pSignUpDialog.setVisible(true);  //다른 패널들과 달리 얘는 부모에 등록하지 않고 독립적으로 함
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