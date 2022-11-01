package Ex;

import java.io.*;
import java.util.ArrayList;

public class EAccount {
//    private String id;
//    private String password;
//    private String name;
    VAccount vAccount;
    protected ArrayList<VAccount> accountList;
    public EAccount() throws IOException {
        BufferedReader accountFile = new BufferedReader(new FileReader("data/account"));
        this.accountList = new ArrayList<VAccount>();
        while (accountFile.ready()){
            String accountInfo = accountFile.readLine();
            if(!accountInfo.equals("")) this.accountList.add(new VAccount(accountInfo));
        }
        accountFile.close();
    }
    public ArrayList<VAccount> getAllStudentRecords(){
        if(this.accountList.size()==0) System.out.println("-------Student Data is NULL !!!-------");  //nulldataexception을 생성해서 던짐
        return this.accountList;//모든 학생정보를 반환해줌
    }
//    public String printAllStudentList(){
//        String returnSList = "";
//        if(this.getAllStudentRecords().size()==0) System.out.println("-------Student Data is NULL !!!-------");
//        for(VAccount v : this.getAllStudentRecords()) { returnSList = returnSList + printAllStudentRecords(v)+"\n";}
//        return returnSList;
//    }
//
//    public String printAllStudentRecords(VAccount v) {
//        String returnSRecord = "학생 ID : " + v.getID() + "  |  학생 PW : " + v.getPW() + "  |  학생 이름 : " + v.getName() + "  |  번호 : " + v.getPhoneNum()+ "  |  메일 : " + v.getEMail()+ "  |  학부 : " + v.getFaculty()+ "  |  전공 : " + v.getMajor()+ "  |  학년 : " + v.getGrade()+ "  |  성별 : " + v.getSex();
//        return returnSRecord+"\n";
//    }
    public boolean isRegistered(String ID){  //이미 등록되어 있는 학생인지 확인
        for(int i=0; i<this.accountList.size();i++){
            VAccount v = this.accountList.get(i);
            if (v.checkID(ID)) return false; //이미 등록
        } return true;  //등록되지 않은 학생
    }
    public String checkLogin(String ID, String PW){//입력 받은 ID와 PW의 파일 존재 여부 & ID와 PW 일치 확인
        String retVal="";
        if(this.isRegistered(ID)) {
            System.out.println("계정 없음");
            retVal = "null";
        }
        else {
            for(int i=0; i<this.accountList.size();i++) {
                VAccount v = this.accountList.get(i);
                if (v.matchPW(ID,PW)){
                    System.out.println("계정 일치");
                    retVal = "correct";
                    break;
                }
                else{
                    System.out.println("계정 틀림");
                    retVal = "wrong";
                }
            }
        }
        return retVal;
    }
    public VAccount getAccount(String ID, String PW){    //value오브젝트를 리턴해줬으면 좋겠음
        VAccount v = null;
        if(checkLogin(ID,PW)=="correct") { //VAccount를 담아줘야함
            for (int i = 0; i < this.accountList.size(); i++) {
                v = this.accountList.get(i);
                if (v.getID().equals(ID)) return v;
            }
        }return v;
    }
    public boolean signUp(String info){
        if(this.accountList.add(new VAccount(info))) return true;
        return false;
    }
//    public VAccount getAccountByID(String ID) {
//        VAccount v = null;
//        for (int i = 0; i < this.accountList.size(); i++) {
//            v = this.accountList.get(i);
//            if (v.getID().equals(ID)) return v;
//        } return v;
//    }



    //    private boolean read(String ID, String PW){//file read. id를 주고 account파일에 해당하는 id를 읽어올 것
//        boolean found=false; //찾았냐 못찾았냐
//        //값을 채워서
//        try {
//            File file = new File("data/account");
//            Scanner scn=new Scanner(file);
//            accountList = new ArrayList<VAccount>();
//            while (scn.hasNext() && !found) { //읽을게 더 있거나 찾는 id를 파일에서 찾거나 할 때까지
//                this.id = scn.next();
//                this.password = scn.next();
//                this.name = scn.next();
//
//                if(this.id.compareTo(ID)==0&&this.password.compareTo(PW)==0){//찾으라는 id와 파일의 id가 같고, 그 아이디와 비밀번호가 일치하면
//                    found=true;
//                }
//            }
//            scn.close();
//        } catch (FileNotFoundException e) {
//            //   throw new RuntimeException(e);
//            e.printStackTrace();
//        }
//        return found;
//    }


}
