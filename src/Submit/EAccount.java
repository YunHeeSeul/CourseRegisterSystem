package Submit;

import Ex.VAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EAccount {
    private String id;
    private String password;
    private String name;


    public EAccount(){
    }
    /*
    public EAccount(){
        try {
            File file = new File("data/account");
            BufferedReader br = new BufferedReader(new FileReader(file));
            this.accountList = new ArrayList<>();
            while(br.ready()){
                String accountInfo = br.readLine();
                if (!accountInfo.equals("")) this.accountList.add(accountInfo);
            }
            br.close();
        } catch (IOException e) {
            //   throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
     */
    private boolean read(String ID, String PW){//file read. id를 주고 account파일에 해당하는 id를 읽어올 것
        boolean found=false; //찾았냐 못찾았냐
        //값을 채워서

        try {
            File file = new File("data/account");
            Scanner scn=new Scanner(file);
            while (scn.hasNext() && !found) { //읽을게 더 있거나 찾는 id를 파일에서 찾거나 할 때까지
                this.id = scn.next();
                this.password = scn.next();
                this.name = scn.next();

                if(this.id.compareTo(ID)==0&&this.password.compareTo(PW)==0){//찾으라는 id와 파일의 id가 같고, 그 아이디와 비밀번호가 일치하면
                    found=true;
                }
            }
            scn.close();
        } catch (FileNotFoundException e) {
            //   throw new RuntimeException(e);
            e.printStackTrace();
        }
        return found;
    }

    public Ex.VAccount getAccount(String ID, String PW){    //value오브젝트를 리턴해줬으면 좋겠음
        Ex.VAccount vAccount=null;
        boolean found = this.read(ID,PW);
        //못찾으면 null 리턴하고 찾으면 값을 채워서 리턴
        if(found){ //found면 account를 만들어서 채워줘야 함
            vAccount = new VAccount(); //VAccount를 담아줘야함
            //값 채우기 시작
            vAccount.setId(this.password);
            vAccount.setPassword(this.password);
            vAccount.setName(this.name);
        }
        return vAccount;
    }

}
