package Ex;

import java.io.Serial;
import java.io.Serializable;
import java.util.StringTokenizer;

public class VDirectory implements Serializable {
    private static final long serialVersionUID = 1L;

    public VDirectory(){}
    public VDirectory(String rootInfo){
        StringTokenizer st = new StringTokenizer(rootInfo);
        this.cNum = st.nextToken();
        this.cName = st.nextToken();
    }
    private String cName;
    private String cNum;
    public String getCName() {return cName;}
    public void setCNameID(String cName) {this.cName = cName;}
    public String getcNum() {return cNum;}
    public void setPW(String cNum) {this.cNum = cNum;}

    public String toString() {
        String returnString = this.cName + " " + this.cNum;
        return returnString+"\n";
    }
}
