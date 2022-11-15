package Submit.View;

import Submit.Entity.EDirectory;
import Submit.Model.SDirectory;
import Submit.Model.SLecture;
import Submit.ValueObject.VDirectory;
import Submit.ValueObject.VLecture;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.Vector;

public class PDirectoryPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private ListSelectionHandler listSelectionHandler;
    private PDirectory campusTable, collegeTable, departmentTable;
    private PLectureTable lectureTable;
    private JScrollPane scrollPane1, scrollPane2, scrollPane3, scrollPane4;
    private SDirectory sDirectory;
    private JPanel upPanel, downPanel, leftPanel, downPanel2;
    private String selectName; //선택값
    VDirectory vDirectory;
    EDirectory eDirectory;
    Submit.View.PDirectory pDirectory;

    public PDirectoryPanel() throws IOException{
        LayoutManager layoutManager = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(layoutManager);

        //campus/college/department table을 담은 상위 패널
        upPanel = new JPanel();
        layoutManager = new BoxLayout(upPanel,BoxLayout.X_AXIS);
        upPanel.setLayout(layoutManager);

        this.campusTable = new PDirectory();
        this.campusTable.getSelectionModel().addListSelectionListener(listSelectionHandler);
        scrollPane1 = new JScrollPane(this.campusTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane1.setViewportView(this.campusTable);
        upPanel.add(scrollPane1);

        this.collegeTable = new PDirectory();
        this.collegeTable.getSelectionModel().addListSelectionListener(listSelectionHandler);
        scrollPane2 = new JScrollPane(this.collegeTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane2.setViewportView(this.collegeTable);
        upPanel.add(scrollPane2);

        this.departmentTable = new PDirectory();
        this.departmentTable.getSelectionModel().addListSelectionListener(listSelectionHandler);
        scrollPane3 = new JScrollPane(this.departmentTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane3.setViewportView(this.departmentTable);
        upPanel.add(scrollPane3);

        this.add(upPanel);

        //lecture 테이블을 담은 하위 패널
        downPanel = new JPanel();
        layoutManager = new BoxLayout(downPanel,BoxLayout.X_AXIS);
        downPanel.setLayout(layoutManager);

        this.lectureTable = new PLectureTable();
        this.lectureTable.getSelectionModel().addListSelectionListener(listSelectionHandler);
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

    public void initialize(){
        this.campusTable.initialize();
        this.collegeTable.initialize();
        this.departmentTable.initialize();
        this.lectureTable.initialize();
    }

    private class ListSelectionHandler implements ListSelectionListener {
        private Object previous;
        private int firstIndex, lastIndex;
        public ListSelectionHandler(){
            this.previous=null;
            this.firstIndex=-1;
            this.lastIndex=-1;
        }
        @Override
        public void valueChanged(ListSelectionEvent e) { //마우스 클릭이 일어나면 valueChanged 발생.
            if(this.previous != e.getSource()||this.firstIndex != e.getFirstIndex()) { //다음에 들어온 이벤트가 이전에 발생했던 곳에서 발생했다면 하지 않음.
                System.out.println(e.getSource().toString()); //이벤트 발생한 애가 누군지 가져오는. tostring하면 클래스 이름이 나옴
            }
            this.previous=e.getSource(); // 지금 들어온 이벤트 저장하고
            this.firstIndex=e.getFirstIndex();
            this.lastIndex=e.getLastIndex();
        }
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
        public void initialize(){
            this.tableModel.setNumRows(0);
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
        public void initialize(){
            this.tableModel.setNumRows(0);
        }
    }
}
