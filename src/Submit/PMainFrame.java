package Submit;

import java.io.IOException;

public class PMainFrame {
    private PLogin pLogin;
    //constructor
    public PMainFrame() throws IOException {
        this.pLogin =new PLogin();
    }
    public void run() throws IOException {
        //처음에 런이 실행되는 초기화면이 실행되야 함
        this.pLogin.login();
    }
}
