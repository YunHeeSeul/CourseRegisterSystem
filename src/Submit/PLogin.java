package Submit;

import java.io.IOException;
import java.util.Scanner;

public class PLogin {
    SLogin sLogin;
    VAccount vAccount;

    public PLogin() throws IOException {
        this.vAccount=new VAccount();
        this.sLogin=new SLogin();
    }
    public void login() throws IOException {    //로그인 초기화면
        Scanner scn = new Scanner(System.in);
        while(true){
            System.out.print(this.vAccount.printAllVAccount());
            System.out.print("ID : ");
            String id = scn.next();
            System.out.print("Password : ");
            String password = scn.next();
            //id가 있는지 없는지 컨트롤러한테 체크해봐야 함.
            //지금은 같은 컴퓨터에 존재, 데이터베이스 또한 내 컴퓨터에 존재한다 여기고 프로그램 짤 것

            //account service
            //sLogin(controller)은 화면에 나타내는 데이터를 중간에 가공해서 주는 것.
            if (this.vAccount.match(id)) {
                System.out.println("Success Login !!!");
                System.out.println("User's Account");
            //    this.sLogin.login(id, password);//sLogin는 얘의 account 정보를 리턴 시켜 줌.
            }
            else if(id=="X"|id=="x")
                return;
            else
                System.out.println("입력하신 정보와 일치하는 사용자가 존재하지 않습니다.\n다시 입력해주세요.");
        }
    }
}
