package Service;

import Entity.EAccount;
import View.VAccount;

public class SLogin {
    public SLogin(){}
    public VAccount login(String id){
        //얘는 entity한테 얘기해야 함
        EAccount eAccount = new EAccount();
        VAccount vAccount = eAccount.getLogin(id);   //eAccount에게 해당하는 id를 가져와 달라 요청함
        return vAccount;
    }
}
