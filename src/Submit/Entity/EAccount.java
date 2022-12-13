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

    public boolean isRegistered(String ID){  //�̹� ��ϵǾ� �ִ� �л����� Ȯ��
        for(int i=0; i<this.accountList.size();i++){
            VAccount v = this.accountList.get(i);
            if(ID!= Locale.BLANK)  if (v.checkID(ID)) return false; //�̹� ���
        } return true;  //��ϵ��� ���� �л�
    }

    public String checkLogin(String ID, String PW){//�Է� ���� ID�� PW�� ���� ���� ���� & ID�� PW ��ġ Ȯ��
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

    public VAccount getAccount(String ID, String PW){    //value������Ʈ�� ������������ ������
        if(checkLogin(ID,PW)== Locale.CORRECT) { //VAccount�� ��������
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

