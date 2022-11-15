package Submit.View;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PAccountPanel extends JPanel { //JPanel 확장해서 사용할 것
    PLoginDialog pLoginDialog;
    public PAccountPanel(String name){  //name을 받아와야 함
        //이 안에 자식으로 레이블들 쭉 넣을 건데 그 레이블들은 로그인 다이얼로그에서 올 것
        JLabel lName = new JLabel(name);
        this.add(lName); //자식 등록

        JLabel lGreeting = new JLabel("님 안녕하세요! ");
        this.add(lGreeting); //자식 등록

        JLabel lLogin = new JLabel("로그인 시간은");
        this.add(lLogin); //자식 등록

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        JLabel lTime = new JLabel(simpleDateFormat.format(new Date()));
        this.add(lTime); //자식 등록

        JLabel lDescription = new JLabel("입니다!");
        this.add(lDescription); //자식 등록
    }
}
