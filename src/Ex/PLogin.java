package Ex;

import java.util.Scanner;

public class PLogin {
    private SLogin sLogin;//sLogin(controller)은 화면에 나타내는 데이터를 중간에 가공해서 주는 것.
    public PLogin(){
        sLogin = new SLogin();
    }
    public VAccount login(){
        System.out.print("아이디를 입력하세요 : ");
        Scanner scn = new Scanner(System.in);   //인풋값을 내가 원하는 형태로 변형해주는 것. System.in은 키보드를 뜻함. 즉, 키보드를 연결해놓고 데이터를 우리가 원하는 형태로 변형시킬 수 있는 객체
        String id = scn.next();//next()는 띄어쓰기 한 곳까지 읽음. space, enter까지 읽어버림. space를 아무리 쳐도 id엔 들어가지 않음.

        //id가 있는지 없는지 컨트롤러한테 체크해봐야 함.
        //지금은 같은 컴퓨터에 존재, 데이터베이스 또한 내 컴퓨터에 존재한다 여기고 프로그램 짤 것
        //account service
        VAccount vAccount = sLogin.login(id); //sLogin는 얘의 account 정보를 리턴 시켜 줌.


        scn.close();
        return vAccount;    //mainframe
    }
}
