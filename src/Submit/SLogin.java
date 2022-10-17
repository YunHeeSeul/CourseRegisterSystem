package Submit;

import Ex.EAccount;
import Ex.VAccount;

public class SLogin {
    private Ex.EAccount eAccount;
    public SLogin(){
        //얘는 entity한테 얘기해야 함
        this.eAccount = new EAccount();
    }
    public Ex.VAccount login(String ID, String PW){

        VAccount vAccount = this.eAccount.getAccount(ID,PW);   //eAccount에게 해당하는 id를 가져와 달라 요청함
        return vAccount;
    }
}
