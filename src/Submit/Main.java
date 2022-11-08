package Submit;

import java.io.IOException;

public class Main {

    public static void main(String [] args) throws IOException {
        //ImagePanel 하나 생성하여 PMainFrame에 붙여주기
        //C:\Users\윤희슬\Desktop\명지대\3-2\객체지향프로그래밍\CourseRegisterSystem\image\title.jpg
        PMainFrame mainFrame = new PMainFrame();
        //ImagePanel imagePanel = new ImagePanel(new ImageIcon("image/title.jpg").getImage());
        mainFrame.setVisible(true);
        //PMainFrame pMainFrame = new PMainFrame();
        //pMainFrame.setVisible(true);
        //pMainFrame.run();
        //PMainframe에 패널 붙이기
        //mainFrame.add(imagePanel);
    }
}