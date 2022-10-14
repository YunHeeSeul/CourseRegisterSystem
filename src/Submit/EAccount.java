package Submit;

import Submit.VAccount;
//import Submit.VAccountList;

public class EAccount {
    private String id;
    private String password;
    private String name;

        //vAccount 내용이 담긴 리스트
    public EAccount() {}
   /*
    public VAccountList read(){//file read. 이 account에 해당하는 파일을 읽어올 것
        //값을 채워서
    }
    */
/*
    public String getLogin(String id, String password){    //value오브젝트를 리턴해줬으면 좋겠음
        //file read
        String retVal ="";
        if(this.vAccountList.isRegisteredAccount(id,password))
            retVal = this.vAccountList.printVAccount(vAccount);
        return retVal;
    }

 */
    /*
    public VAccount getLogin(String id, String password){
        VAccountList vAccountList=new VAccountList();
        return vAccountList.isRegisteredAccount(id);
    }

     */
}
