package Submit.View;

import Submit.Global.Constants;
import Submit.Global.Locale;
import Submit.ValueObject.VAccount;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PAccountPanel extends JPanel { //JPanel 확장해서 사용할 것
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    //public PAccountPanel(String name){  //name을 받아와야 함
    public PAccountPanel(VAccount vAccount){  //name을 받아와야 함
        JLabel lName = new JLabel(vAccount.getName());
        this.add(lName); //자식 등록

        JLabel lGreeting = new JLabel(Locale.LAccountPanel.INSA_POSTFIX);
        this.add(lGreeting); //자식 등록

        JLabel lLogin = new JLabel(Locale.LAccountPanel.LOGIN_TIME_PREFIX);
        this.add(lLogin); //자식 등록

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Locale.TIME_FORMAT);
        JLabel lTime = new JLabel(simpleDateFormat.format(new Date()));
        this.add(lTime); //자식 등록

        JLabel lDescription = new JLabel(Locale.LAccountPanel.IPNIDA);
        this.add(lDescription); //자식 등록
    }
}
