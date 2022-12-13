package Submit.Entity;

import Submit.Global.Locale;
import Submit.ValueObject.VAccount;

import java.io.*;
import java.util.ArrayList;

public class EAccount {
    public ArrayList<VAccount> accountList;

    public EAccount() throws IOException {
        BufferedReader accountFile = new BufferedReader(new FileReader(Locale.FILENAME));
        this.accountList = new ArrayList<>();
        while (accountFile.ready()){
            String accountInfo = accountFile.readLine();
            if(!accountInfo.equals("")) this.accountList.add(new VAccount(accountInfo));
        }
        accountFile.close();
    }

    public boolean isRegistered(String ID){  //이미 등록되어 있는 학생인지 확인
        for(int i=0; i<this.accountList.size();i++){
            VAccount v = this.accountList.get(i);
            if(ID!= Locale.BLANK)  if (v.checkID(ID)) return false; //이미 등록
        } return true;  //등록되지 않은 학생
    }

    public String checkLogin(String ID, String PW){//입력 받은 ID와 PW의 파일 존재 여부 & ID와 PW 일치 확인
        String retVal= Locale.BLANK;
        if(this.isRegistered(ID)) retVal = Locale.NONE;
        else {
            for(VAccount v : this.accountList) {
                if (v.matchPW(ID,PW)){ retVal = Locale.CORRECT; break; }
                else retVal = Locale.WRONG;
            }
        }return retVal;
    }

    public boolean signUp(String info) throws IOException {
        if(this.accountList.add(new VAccount(info)) && this.saveSignUp(this.accountList)) return true;
        return false;
    }

    public VAccount getAccount(String ID, String PW){    //value오브젝트를 리턴해줬으면 좋겠음
        if(checkLogin(ID,PW)== Locale.CORRECT) { //VAccount를 담아줘야함
            for (int i = 0; i < this.accountList.size(); i++) {
                VAccount v = this.accountList.get(i);
                if (v.getID().equals(ID)) return v;
            }
        }return null;
    }

    public boolean saveSignUp(ArrayList<VAccount> accountList) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(Locale.FILENAME));
        for(VAccount v : this.accountList){
            bw.write(v.toString());
            bw.newLine();
        }
        bw.close();
        return true;
    }
}

