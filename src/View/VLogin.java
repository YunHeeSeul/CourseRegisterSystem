package View;

import Service.SLogin;

import java.util.Scanner;

public class VLogin {
    public VLogin(){}
    public void login(){
        System.out.print("아이디를 입력하세요 : ");
        Scanner scn = new Scanner(System.in);
        String id = scn.next();

        //id가 있는지 없는지 컨트롤러한테 체크해봐야 함.
        //지금은 같은 컴퓨터에 존재, 데이터베이스 또한 내 컴퓨터에 존재한다 여기고 프로그램 짤 것

        //account service
        SLogin sLogin = new SLogin();
        VAccount vAccount = sLogin.login(id); //sLogin는 얘의 account 정보를 리턴 시켜 줌.
        //sLogin(controller)은 화면에 나타내는 데이터를 중간에 가공해서 주는 것.
        scn.close();
    }
}
