package Submit;

import Ex.ImagePanel;
import Ex.PMainFrame;

import javax.swing.*;

public class Main {

    public static void main(String [] args){
        //ImagePanel 하나 생성하여 PMainFrame에 붙여주기
        //C:\Users\윤희슬\Desktop\명지대\3-2\객체지향프로그래밍\CourseRegisterSystem\image\title.jpg
        ImagePanel loginPanel = new ImagePanel(new ImageIcon("image/title.jpg").getImage());
        PMainFrame pMainFrame = new PMainFrame();
        pMainFrame.setVisible(true);
        //pMainFrame.run();
        //PMainframe에 패널 붙이기
        pMainFrame.add(loginPanel);

        loginPanel.setBounds(0,0,1200,240);
    }

}