package Ex;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PDirectoryPanel extends JPanel {
    private JList campusList;
    private JList collegeList;
    private JList dptList;
    private JScrollPane jsp1, jsp2;
    private JPanel upPanel, leftPanel;
    private JTable courseT;
    VDirectory vDirectory;
    EDirectory eDirectory;
    public PDirectoryPanel(){
        this.setLayout(new GridLayout(2,1,5,5));
        this.vDirectory=new VDirectory();

        upPanel = new JPanel(); //campus, college, department
        upPanel.setLayout(new GridLayout(1,3,5,5));
        String [] campus={"용인","서울"};
        this.campusList = new JList(campus);
        upPanel.add(this.campusList);

        String [] college ={"용인","서울"};
        this.collegeList = new JList(college);
        upPanel.add(this.collegeList);

        String [] dpt ={"용인","서울"};
        this.dptList = new JList(dpt);
        jsp1 = new JScrollPane(this.dptList);
        upPanel.add(this.dptList);
        this.add(upPanel);

        String [] column ={"강좌번호","강좌명","담당교수","학점","시간"};
        Object[][] data = {{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}};
        this.courseT = new JTable(data, column);
        jsp2 = new JScrollPane(this.courseT,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(jsp2);

    }
}
