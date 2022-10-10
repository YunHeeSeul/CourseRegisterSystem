package View;

public class VMainFrame {
    private VLogin vLogin;
    //constructor
    public VMainFrame(){
        this.vLogin=new VLogin();
    }
    public void run(){
        //처음에 런이 실행되는 초기화면이 실행되야 함
        this.vLogin.login();
    }
}
