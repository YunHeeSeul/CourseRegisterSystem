package Submit.Model;

import Submit.Global.Locale;
import Submit.Entity.EAccount;
import Submit.ValueObject.VAccount;

import java.io.IOException;

public class SLogin {
    private EAccount eAccount;
    private VAccount vAccount;

    public SLogin() throws IOException {eAccount=new EAccount();}

    public String login(String ID, String PW) {
        String retVal= Locale.BLANK;
        if(this.eAccount.checkLogin(ID,PW)==Locale.CORRECT) retVal = Locale.CORRECT;//eAccount에게 해당하는 id를 가져와 달라 요청
        else if (this.eAccount.checkLogin(ID,PW)==Locale.NONE) retVal=Locale.NONE;
        else if (this.eAccount.checkLogin(ID,PW)==Locale.WRONG) retVal=Locale.WRONG;
        return retVal;
    }
    public VAccount read(String ID,String PW) throws IOException {
        if(this.login(ID,PW)==Locale.CORRECT)  vAccount = this.eAccount.getAccount(ID, PW);
        return vAccount;
    }
    public boolean match(String ID){
        if(this.eAccount.isRegistered(ID)) return true;//등록되어있지 않은
        return false;
    }
    public boolean signUp(String info) throws IOException {
        if(this.eAccount.signUp(info)) return true;
        return false;
    }
}
