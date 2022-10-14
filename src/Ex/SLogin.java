package Ex;

public class SLogin {
    private EAccount eAccount;
    public SLogin(){
        //얘는 entity한테 얘기해야 함
        this.eAccount = new EAccount();
    }
    public VAccount login(String id){

        VAccount vAccount = this.eAccount.getAccount(id);   //eAccount에게 해당하는 id를 가져와 달라 요청함
        return vAccount;
    }
}
