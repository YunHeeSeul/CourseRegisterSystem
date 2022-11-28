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

    //1단계 초기화
    public Main(){}
    //2단계 초기화
    public void initialize() throws IOException {
        ActionHandler actionHandler = new ActionHandler();

        this.loginDialog = new PLoginDialog(actionHandler); //MainFrame을 부모로 주는 것

        //OK,Cancel을 판단을 해야 함
        this.loginDialog.setVisible(true);  //다른 패널들과 달리 얘는 부모에 등록하지 않고 독립적으로 함
    }
    class ActionHandler implements ActionListener {
        private PSignUpDialog pSignUpDialog;
        @Override
        public void actionPerformed(ActionEvent e) {//로그인 버튼 액션 설정하는 메소드
            if(e.getActionCommand().equals(Locale.LOGIN_BUTTON)){   //로그인 버튼 눌렀을 때
                try {runLogin();}
                catch (IOException ex) {throw new RuntimeException(ex);}
            }
            else if(e.getActionCommand().equals(Locale.SIGNUP_BUTTON)){// 회원가입 버튼 눌렀을 때
                try {pSignUpDialog = new PSignUpDialog(); }
                catch (IOException e1) {e1.printStackTrace();}
                loginDialog.dispose();
                pSignUpDialog.initialize();  //다른 패널들과 달리 얘는 부모에 등록하지 않고 독립적으로 함
            }
        }
    }

    ///pf
    public void runLogin() throws IOException {
        VAccount vAccount = this.loginDialog.login();
       // this.loginDialog.dispose();

        PMainFrame mainFrame = new PMainFrame(vAccount); //메인프레임에 바로 account 줌
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