package Submit.ValueObject;

import java.io.Serializable;
import java.util.StringTokenizer;

public class VAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    private String ID;
    private String PW;
    private String name;
    private String phoneNum;
    private String eMail;
    private String campus;
    private String college;
    private String department;
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
        this.campus = st.nextToken();
        this.college = st.nextToken();
        this.department = st.nextToken();
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

    public String getPhoneNum() {return phoneNum;}
    public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}

    public String getEMail() {return eMail;}
    public void setEMail(String eMail) {this.eMail = eMail;}

    public String getCampus() {return campus;}
    public void setCampus(String campus) {this.campus = campus;}

    public String getCollege() {return college;}
    public void setCollege(String college) {this.college = college;}

    public String getDepartment() {return department;}
    public void setDepartment(String department) {this.department = department;}

    public String getGrade() {return grade;}
    public void setGrade(String grade) {this.grade = grade;}

    public String getSex() { return sex;}
    public void setSex(String sex) {this.sex = sex;}

    public String printStudentRecord() {
        String returnString = "학생 ID : " + this.ID + "  |  학생 PW : " + this.PW + "  |  학생 이름 : " +this.name + "  |  번호 : " + this.phoneNum+ "  |  메일 : " + this.eMail+ "  |  캠퍼스 : " + this.campus+"  |  학부 : " + this.college+ "  |  전공 : " + this.department+ "  |  학년 : " + this.grade+ "  |  성별 : " + this.sex;
        return returnString+"\n";
    }

    public String toString() {
        String returnString = this.ID + "  " + this.PW + "  " +this.name + "  " + this.phoneNum+ "  " + this.eMail+ "  " + this.campus + "  "+this.college+ "  " + this.department+ "  " + this.grade+ "  " + this.sex;
        return returnString+"\n";
    }
}


