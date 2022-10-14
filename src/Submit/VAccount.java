package Submit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class VAccount implements Serializable {
    protected String id;
    protected String password;
    protected String name;

    public VAccount(){}
    public VAccount(String inputString) {	//String으로 해서 받음
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
        this.id = stringTokenizer.nextToken();
        this.password = stringTokenizer.nextToken();
        this.name = stringTokenizer.nextToken();
    }

    public boolean match(String id) {   //id와 password가 일치하는지 확인하는 부분
        if(this.id.equals(id))
            if(this.password.equals(password))
                return true;
        return false;
        /*
        if(this.id.equals(id) && this.password.equals(password))
            return true;
        return false;

         */
    }
    public String getName() {
        return this.name;
    }
    public String printAllVAccount() {
        String stringReturn = "ID : " + this.id + "  |  Password : " + this.password + "  |  이름 : " + this.name;
        return stringReturn+"\n";
    }
}
