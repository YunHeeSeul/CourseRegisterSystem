package Submit.View;

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
    private JPanel upPanel, downPanel, leftPanel, downPanel2;
    private String selectName; //선택값

    public PDirectoryPanel() throws IOException {
        LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layoutManager);

        this.listSelectionHandler = new ListSelectionHandler();

        //campus/college/department table을 담은 상위 패널
        upPanel = new JPanel();
        layoutManager = new BoxLayout(upPanel, BoxLayout.X_AXIS);
        upPanel.setLayout(layoutManager);

        this.campusTable = new PDirectory();
        this.campusTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
        scrollPane1 = new JScrollPane(this.campusTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane1.setViewportView(this.campusTable);
        upPanel.add(scrollPane1);

        this.collegeTable = new PDirectory();
        this.collegeTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
        scrollPane2 = new JScrollPane(this.collegeTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane2.setViewportView(this.collegeTable);
        upPanel.add(scrollPane2);

        this.departmentTable = new PDirectory();
        this.departmentTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
        scrollPane3 = new JScrollPane(this.departmentTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane3.setViewportView(this.departmentTable);
        upPanel.add(scrollPane3);

        this.add(upPanel);

        //lecture 테이블을 담은 하위 패널
        downPanel = new JPanel();
        layoutManager = new BoxLayout(downPanel, BoxLayout.X_AXIS);
        downPanel.setLayout(layoutManager);

        this.lectureTable = new PLectureTable();
        this.lectureTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
        scrollPane4 = new JScrollPane(this.lectureTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //scrollpane 안에 campustable을 붙인 것
        scrollPane4.setViewportView(this.lectureTable);
        downPanel.add(scrollPane4);

        this.add(downPanel);

        this.updateTable(null, 0);
    }

    private class ListSelectionHandler implements ListSelectionListener {

        public ListSelectionHandler(){}

        @Override
        public void valueChanged(ListSelectionEvent e) { //마우스 클릭이 일어나면 valueChanged 발생.
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            if(!e.getValueIsAdjusting()){
                System.out.println(lsm.toString());
                int selectedRow = lsm.getLeadSelectionIndex();
                try {updateTable(lsm, selectedRow);}
                catch (IOException ex) {ex.printStackTrace();}
            }
        }
    }

    private void updateTable(Object source, int selectedRow) throws IOException {
        //데이터를 가져오는 부분
        String fileName = null;
        if(source == null){
            fileName = "root";
            fileName=this.campusTable.setData(fileName);
            fileName = this.collegeTable.setData(fileName);
            fileName = this.departmentTable.setData(fileName);
            this.lectureTable.setData(fileName);
        }
        else if(source == this.campusTable.getSelectionModel()){
            fileName=this.campusTable.getVDirectory().get(selectedRow).getFileName();
            fileName = this.collegeTable.setData(fileName);
            fileName = this.departmentTable.setData(fileName);
            this.lectureTable.setData(fileName);
        }
        else if(source == this.collegeTable.getSelectionModel()){
            fileName=this.collegeTable.getVDirectory().get(selectedRow).getFileName();
            fileName = this.departmentTable.setData(fileName);
            this.lectureTable.setData(fileName);
        }
        else if(source == this.departmentTable.getSelectionModel()){
            fileName=this.departmentTable.getVDirectory().get(selectedRow).getFileName();
            this.lectureTable.setData(fileName);
        }
        else if(source == this.lectureTable.getSelectionModel()){
            fileName=this.lectureTable.getVLecture().get(selectedRow).toString();
            //this.miridamgiTable.setData(fileName);
        }
    }

    public class PDirectory extends JTable {
        private static final long serialVersionUID = 1L;
        private DefaultTableModel tableModel;
        private SDirectory sDirectory;
        private Vector<VDirectory> vDirectories;

        public PDirectory() {
            Vector<String> header = new Vector<String>();
            String[] s = {"캠퍼스", "대학", "과목"};
            int cnt = 0;
            header.add(s[cnt]); //column 이름
            cnt++;
            tableModel = new DefaultTableModel(header, 10);//테이블모델 생성
            this.setModel(tableModel);//테이블모델 등록
        }
        @Override
        public boolean isCellEditable(int row, int col){return false;}

        public String setData(String fileName) throws IOException {
            this.sDirectory = new SDirectory(); //데이터를 가져오려면 SDirectory 필요
            this.vDirectories = this.sDirectory.getDirectories(fileName); //n개의 vdirectory를 받아옴
            this.tableModel.setNumRows(0);

            for (VDirectory vDirectory : this.vDirectories) {
                Vector<String> row = new Vector<String>();
                row.add(vDirectory.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
                this.tableModel.addRow(row);
            }
            //this.setRowSelectionInterval(0, 0); //맨 처음 것을 선택하도록
//            this.updateUI();
            return this.vDirectories.get(0).getFileName(); //0번이 선택한 것에 해당하는 파일네임을 가져오는 것
        }
        public Vector<VDirectory> getVDirectory() { return this.vDirectories;}
    }


    public class PLectureTable extends JTable {
        private static final long serialVersionUID = 1L;
        private DefaultTableModel tableModel;
        private SLecture sLecture;
        private Vector<VLecture> vLectures;

        public PLectureTable() {
            Vector<String> header = new Vector<String>();
            header.add("과목코드"); //column 이름
            header.add("과목명"); //column 이름
            header.add("담당교수"); //column 이름
            header.add("학점"); //column 이름
            header.add("시간"); //column 이름

            tableModel = new DefaultTableModel(header, 10);//테이블모델 생성
            this.setModel(tableModel);//테이블모델 등록
        }

        public void setData(String fileName) {
            this.sLecture = new SLecture(); //데이터를 가져오려면 SDirectory 필요
            this.vLectures = sLecture.getLectures(fileName); //n개의 vdirectory를 받아옴
            this.tableModel.setNumRows(0);

            for (VLecture vLecture : vLectures) {
                Vector<String> row = new Vector<String>();
                row.add(vLecture.getId()); //파일에서 읽어온 데이터를 넣어줘야 함
                row.add(vLecture.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
                row.add(vLecture.getProfessor()); //파일에서 읽어온 데이터를 넣어줘야 함
                row.add(vLecture.getCredit()); //파일에서 읽어온 데이터를 넣어줘야 함
                row.add(vLecture.getTime()); //파일에서 읽어온 데이터를 넣어줘야 함
                this.tableModel.addRow(row);
            }
            //this.setRowSelectionInterval(0, 0); //맨 처음 것을 선택하도록
//            this.updateUI();
        }
         private Vector<VLecture> getVLecture(){return this.vLectures;}
    }
}
