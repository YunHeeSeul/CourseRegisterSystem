package Ex;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PDirectoryPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private PDirectory campusTable, collegeTable, departmentTable, lectureTable;
    private JScrollPane scrollPane1, scrollPane2, scrollPane3, scrollPane4;
    private SDirectory sDirectory;
    private JPanel upPanel, downPanel1, leftPanel, downPanel2;
    VDirectory vDirectory;
    EDirectory eDirectory;

    public PDirectoryPanel() throws IOException{
        this.setLayout(new GridLayout(2,1,5,5));
        //this.vDirectory=new VDirectory();

        upPanel = new JPanel(new FlowLayout()); //campus, college, department
        upPanel.setSize(900, 300);

        downPanel1 = new JPanel(new FlowLayout());

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(1,3,5,5));
        //leftPanel.setSize(this.getWidth(), 300);

        this.campusTable = new PDirectory();
        this.campusTable.setSize(100,250);

        String campus[]= {"root"};
        this.campusTable.setData(campus);
        scrollPane1 = new JScrollPane(this.campusTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane1.setViewportView(this.campusTable);
        scrollPane1.setSize(100, 250);
//        leftPanel.add(scrollPane1);
        upPanel.add(scrollPane1);

        this.collegeTable = new PDirectory();
        this.collegeTable.setSize(100,250);
        String college[]= {"yongin","seoul"};
        this.collegeTable.setData(college);
        scrollPane2 = new JScrollPane(this.collegeTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane2.setViewportView(this.collegeTable);
        scrollPane2.setSize(100,250);
//        leftPanel.add(scrollPane2);
        upPanel.add(scrollPane2);

        this.departmentTable = new PDirectory();
        this.departmentTable.setSize(100,250);
        String department[]= {"generalY","engineering","science","art","architecture"};
        this.departmentTable.setData(department);
        scrollPane3 = new JScrollPane(this.departmentTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane3.setViewportView(this.departmentTable);
        scrollPane3.setSize(100,250);
//        leftPanel.add(scrollPane3);
        upPanel.add(scrollPane3);

        this.add(upPanel);

        this.lectureTable = new PDirectory();
        this.lectureTable.setSize(100,250);
        String lecture[]= {"englishYG","basic","selective"};
        this.lectureTable.setData(lecture);
        scrollPane4 = new JScrollPane(this.lectureTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane4.setViewportView(this.lectureTable);
        scrollPane4.setSize(100,250);
        downPanel1.add(scrollPane4);

        this.add(downPanel1);

    }
}
