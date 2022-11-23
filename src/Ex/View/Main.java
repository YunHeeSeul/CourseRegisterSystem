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

    //1단계 초기화
    public Main(){}
    //2단계 초기화
    public void initialize() throws IOException {
        ActionHandler actionHandler = new ActionHandler();

        this.loginDialog = new PLoginDialog(actionHandler); //MainFrame을 부모로 주는 것
        this.pSignUpDialog = new PSignUpDialog();
        //OK,Cancel을 판단을 해야 함
        this.loginDialog.setVisible(true);  //다른 패널들과 달리 얘는 부모에 등록하지 않고 독립적으로 함
    }
    class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {//로그인 버튼 액션 설정하는 메소드
            try {
                run();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            //            if(e.getActionCommand().equals("Login")){   //로그인 버튼 눌렀을 때
//                try {loginDialog.login();}
//                catch (IOException ex) {throw new RuntimeException(ex);}
//            }
//            else if(e.getActionCommand().equals("SignUp")){// 회원가입 버튼 눌렀을 때
//                try {new PSignUpDialog(); }
//                catch (IOException e1) {e1.printStackTrace();}
//                loginDialog.dispose();
//                pSignUpDialog.setVisible(true);  //다른 패널들과 달리 얘는 부모에 등록하지 않고 독립적으로 함
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

        if(vAccount!=null) { //정상적으로 값을 받아오면
            PMainFrame mainFrame = new PMainFrame(vAccount); //메인프레임에 바로 account 줌
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