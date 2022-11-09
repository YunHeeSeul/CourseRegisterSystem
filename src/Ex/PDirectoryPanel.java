package Ex;
import java.awt.*;
import java.io.IOException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PDirectoryPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private PDirectory campusTable, collegeTable, departmentTable, lectureTable;
    private JScrollPane scrollPane1, scrollPane2, scrollPane3, scrollPane4;
    private SDirectory sDirectory;
    private JPanel upPanel, downPanel, leftPanel, downPanel2;
    VDirectory vDirectory;
    EDirectory eDirectory;

    public PDirectoryPanel() throws IOException{
//        this.setLayout(new GridLayout(2,1,5,5));
        LayoutManager layoutManager = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(layoutManager);

        //campus/college/department table을 담은 상위 패널
//        upPanel = new JPanel(new BoxLayout(upPanel,BoxLayout.X_AXIS)); //campus, college, department가 들어갈 서브패널 1
        upPanel = new JPanel();
        layoutManager = new BoxLayout(this,BoxLayout.X_AXIS);
        upPanel.setLayout(layoutManager);

        this.campusTable = new PDirectory();
        scrollPane1 = new JScrollPane(this.campusTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane1.setViewportView(this.campusTable);
        upPanel.add(scrollPane1);

        this.collegeTable = new PDirectory();
        scrollPane2 = new JScrollPane(this.collegeTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane2.setViewportView(this.collegeTable);
        upPanel.add(scrollPane2);

        this.departmentTable = new PDirectory();
        scrollPane3 = new JScrollPane(this.departmentTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane3.setViewportView(this.departmentTable);
        upPanel.add(scrollPane3);

        this.add(upPanel);

        //lecture 테이블을 담은 하위 패널
//        downPanel = new JPanel(new FlowLayout());
        downPanel = new JPanel();
        layoutManager = new BoxLayout(this,BoxLayout.X_AXIS);
        downPanel.setLayout(layoutManager);

        this.lectureTable = new PDirectory();
        scrollPane4 = new JScrollPane(this.lectureTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane4.setViewportView(this.lectureTable);
        downPanel.add(scrollPane4);

        this.add(downPanel);

        //데이터를 가져오는 부분
        String fileName = "root";
        fileName = this.campusTable.setData(fileName);
        fileName = this.collegeTable.setData(fileName);
        fileName = this.departmentTable.setData(fileName);
        this.lectureTable.setData(fileName);
    }

    private class PDirectory extends JTable{
        private static final long serialVersionUID = 1L;

        private DefaultTableModel tableModel;
        public PDirectory(){
            Vector<String> header = new Vector<String>();
            header.add("Test"); //column 이름
            this.tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
            this.setModel(this.tableModel);//테이블모델 등록
        }
        public String setData(String fileName) throws IOException {
            SDirectory sDirectory = new SDirectory(); //데이터를 가져오려면 SDirectory 필요
            Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName); //n개의 vdirectory를 받아옴

            for(VDirectory vDirectory : vDirectories){
                Vector<String> row = new Vector<String>();
                row.add(vDirectory.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
                this.tableModel.addRow(row);
            }
            this.setRowSelectionInterval(0,0); //맨 처음 것을 선택하도록
            return vDirectories.get(0).getFileName(); //0번이 선택한 것에 해당하는 파일네임을 가져오는 것
        }
    }

    private class PLectureTable extends JTable {
        private static final long serialVersionUID = 1L;
        private DefaultTableModel tableModel;

        public PLectureTable() {
            Vector<String> header = new Vector<String>();
            header.add("Test"); //column 이름
            header.add("Test"); //column 이름
            header.add("Test"); //column 이름
            header.add("Test"); //column 이름
            header.add("Test"); //column 이름

            this.tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
            this.setModel(this.tableModel);//테이블모델 등록
        }

        public void setData(String fileName) {
            SLecture sLecture = new SLecture(); //데이터를 가져오려면 SDirectory 필요
            Vector<VLecture> vLectures = sLecture.getLectures(fileName); //n개의 vdirectory를 받아옴

            for (VLecture vLecture : vLectures) {
                Vector<String> row = new Vector<String>();
                row.add(vLecture.getId()); //파일에서 읽어온 데이터를 넣어줘야 함
                row.add(vLecture.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
                row.add(vLecture.getProfessor()); //파일에서 읽어온 데이터를 넣어줘야 함
                row.add(vLecture.getCredit()); //파일에서 읽어온 데이터를 넣어줘야 함
                row.add(vLecture.getTime()); //파일에서 읽어온 데이터를 넣어줘야 함
                this.tableModel.addRow(row);
            }
            this.setRowSelectionInterval(0, 0); //맨 처음 것을 선택하도록
        }
    }
}
