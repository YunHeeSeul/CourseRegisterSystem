/*
package Submit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VAccountList {
    protected ArrayList<VAccount> vAccountList;
    VAccount vAccount;
    public VAccountList(){}

    public VAccountList(File vAccountFileName) throws IOException { //파일을 집어넣으면
           vAccountFileName=new File("/src/VAccount.txt");
      //  vAccountFileName="C:/Users/윤희슬/Desktop/명지대/3-2/객체지향프로그래밍/CourseRegisterSystem/src/VAccount.txt";
        BufferedReader vAccountFile = new BufferedReader(new FileReader(vAccountFileName)); //그 파일을 읽음
        this.vAccountList = new ArrayList<VAccount>();  //리스트에 넣고
        while(vAccountFile.ready()){    //다 읽을 때까지 한 줄씩 읽어서 리스트에 add
            String accountInfo =  vAccountFile.readLine();
            if(!accountInfo.equals(""))
                this.vAccountList.add(new VAccount(accountInfo));
        }
        vAccountFile.close();
    }

    public String printVAccount(VAccount vAccount) {
        String stringReturn = "ID : " + vAccount.id + "  |  Password : " + vAccount.password + "  |  이름 : " + vAccount.name;
        return stringReturn;
    }

    public boolean isRegisteredAccount(String id) {	//등록되어 있는 id인지 확인하는 부분
        for (int i = 0; i < this.vAccountList.size(); i++) {
            VAccount objAccount = (VAccount) this.vAccountList.get(i);
            if (objAccount.match(id)) {return true;}
        }
        return false;
    }
}

 */
