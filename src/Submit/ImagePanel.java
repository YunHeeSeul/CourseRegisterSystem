package Submit;

import javax.swing.*;
import java.awt.*;

//이미지를 백그라운드 이미지로 사용하는 패널
public class ImagePanel extends JPanel {//JPanel 상속 받기
    private Image img;  //이미지를 하나 가지고 있어야 하니까 변수 생성

    public ImagePanel(Image img){//이 이미지는 생성자에서 받아올 것임
        this.img=img;   //이미지를 받아서 객체 변수에 넣어주고
        this.setSize(img.getWidth(null),img.getHeight(null));//이 패널의 사이즈 정해주기
        this.setLayout(new BorderLayout());
    }

    public void paintComponent(Graphics g){//백그라운드 이미지를 그리기 위해서는 painComponent 메소드로 오버라이트 해주면 됨
        g.drawImage(img,200,0,null);//Graphics를 이용해서 drawImage를 하면 위치하는 곳에서 0,0 좌표부터 그려주라는 의미
    }
}
