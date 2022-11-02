package Ex;

import java.io.IOException;

public class SLogin {
    private EAccount eAccount;
    private VAccount vAccount;

    public SLogin() throws IOException {eAccount=new EAccount();}

    public String login(String ID, String PW) throws IOException {
        String retVal="";
        if(this.eAccount.checkLogin(ID,PW)=="correct") {
            System.out.println("계정 일치");
            retVal = "correct";//eAccount에게 해당하는 id를 가져와 달라 요청
        }else if (this.eAccount.checkLogin(ID,PW)=="null"){
            System.out.println("계정 없음");
            retVal="null";
        }
        else if (this.eAccount.checkLogin(ID,PW)=="wrong"){
            System.out.println("계정 불일치");
            retVal="wrong";}
        return retVal;
    }
    public VAccount read(String ID,String PW) throws IOException {
        if(this.login(ID,PW)=="correct")  vAccount = this.eAccount.getAccount(ID, PW);
        return vAccount;
    }
    public boolean match(String ID){
        if(this.eAccount.isRegistered(ID)) return true;//등록되어있지 않은
        return false;
    }
    public boolean signUp(String info){
        if(this.eAccount.signUp(info)) return true;
        return false;
    }
}
