package Ex.Entity;

import Ex.ValueObject.VAccount;

import java.io.*;
import java.util.ArrayList;

public class EAccount {
    VAccount vAccount;
    protected ArrayList<VAccount> accountList;

    public EAccount() throws IOException {
        BufferedReader accountFile = new BufferedReader(new FileReader("directory/account"));
        this.accountList = new ArrayList<VAccount>();
        while (accountFile.ready()){
            String accountInfo = accountFile.readLine();
            if(!accountInfo.equals("")) this.accountList.add(new VAccount(accountInfo));
        }
        accountFile.close();
    }

    public boolean isRegistered(String ID){  //이미 등록되어 있는 학생인지 확인
        for(int i=0; i<this.accountList.size();i++){
            VAccount v = this.accountList.get(i);
            if (v.checkID(ID)) return false; //이미 등록
        } return true;  //등록되지 않은 학생
    }

    public String checkLogin(String ID, String PW){//입력 받은 ID와 PW의 파일 존재 여부 & ID와 PW 일치 확인
        String retVal="";
        if(this.isRegistered(ID)) {System.out.println("계정 없음"); retVal = "null";}
        else {
            for(int i=0; i<this.accountList.size();i++) {
                VAccount v = this.accountList.get(i);
                System.out.println(v.printStudentRecord());
                if (v.matchPW(ID,PW)){
                    System.out.println("계정 일치");
                    retVal = "correct";
                    break;
                }
                else{ System.out.println("계정 틀림"); retVal = "wrong";}
            }
        }return retVal;
    }

    public boolean signUp(String info){
        if(this.accountList.add(new VAccount(info))) return true;
        return false;
    }

    public VAccount getAccount(String ID, String PW){    //value오브젝트를 리턴해줬으면 좋겠음
        if(checkLogin(ID,PW)=="correct") { //VAccount를 담아줘야함
            for (int i = 0; i < this.accountList.size(); i++) {
                VAccount v = this.accountList.get(i);
                if (v.getID().equals(ID)) return v;
            }
        }return null;
    }
}

