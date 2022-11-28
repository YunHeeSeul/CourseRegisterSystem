package Ex.ValueObject;

import Ex.Global.Constants;

import java.io.Serializable;
import java.util.StringTokenizer;

public class VAccount implements Serializable {

    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
    private String ID;
    private String PW;
    private String name;
    private String phoneNum;
    private String eMail;
    private String faculty;
    private String major;
    private String grade;
    private String sex;

    public VAccount(){}

    public VAccount(String input){
        StringTokenizer st = new StringTokenizer(input);
        this.ID = st.nextToken();
        this.PW = st.nextToken();
        this.name = st.nextToken();
        this.phoneNum = st.nextToken();
        this.eMail = st.nextToken();
        this.faculty = st.nextToken();
        this.major = st.nextToken();
        this.grade = st.nextToken();
        this.sex = st.nextToken();
    }
    public boolean checkID(String ID){return this.ID.equals(ID);}

    public boolean matchPW(String ID, String PW){
        if(checkID(ID))
            if(this.PW.equals(PW)) return true;
        return false;
    }

    public String getID() {return ID;}
    public void setID(String ID) {this.ID = ID;}

    public String getPW() {return PW;}
    public void setPW(String PW) {this.PW = PW;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


    public String printStudentRecord() {
        String returnString = "학생 ID : " + this.ID + "  |  학생 PW : " + this.PW + "  |  학생 이름 : " +this.name + "  |  번호 : " + this.phoneNum+ "  |  메일 : " + this.eMail+ "  |  학부 : " + this.faculty+ "  |  전공 : " + this.major+ "  |  학년 : " + this.grade+ "  |  성별 : " + this.sex;
        return returnString+"\n";
    }
    public String toString() {
        String returnString = this.ID + "  " + this.PW + "  " +this.name + "  " + this.phoneNum+ "  " + this.eMail+ "  " + this.faculty+ "  " + this.major+ "  " + this.grade+ "  " + this.sex;
        return returnString+"\n";
    }
}


