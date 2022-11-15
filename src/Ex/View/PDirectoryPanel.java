package Ex.View;
import Ex.Entity.EDirectory;
import Ex.Model.SDirectory;
import Ex.Model.SLecture;
import Ex.ValueObject.VDirectory;
import Ex.ValueObject.VLecture;

import java.awt.*;
import java.io.IOException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class PDirectoryPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private ListSelectionHandler listSelectionHandler;
    private DefaultTableModel tableModel;
    private PDirectoryPanel pDirectoryPanel;
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

        //데이터를 가져오는 부분
        String fileName = "root";
        this.campusTable.setData(fileName);
//        fileName = this.collegeTable.setData(fileName);
//        fileName = this.departmentTable.setData(fileName);
//        this.lectureTable.setData(fileName);
    }

    public void initialize() {
        this.campusTable.initialize();
        this.collegeTable.initialize();
        this.departmentTable.initialize();
        this.lectureTable.initialize();
    }

    private class ListSelectionHandler implements ListSelectionListener {
        private Object previous;
        private int firstIndex, lastIndex;
        private PDirectory pDirectory;
        private PLectureTable pLectureTable;
        private SDirectory sDirectory;
        private VDirectory vDirectory;
        private String name, fileName;
        Vector<VDirectory> vDirectories;

        public ListSelectionHandler() throws IOException {
            this.previous = null;
            this.firstIndex = -1;
            this.lastIndex = -1;
            this.pDirectory = new PDirectory();
            this.pLectureTable = new PLectureTable();
            this.sDirectory = new SDirectory();
            this.fileName = "root";
            this.vDirectories = sDirectory.getDirectories(fileName);

//            this.name = vDirectories.get(0).getName();

        }

        @Override
        public void valueChanged(ListSelectionEvent e) { //마우스 클릭이 일어나면 valueChanged 발생.
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            if (this.previous != e.getSource() || this.firstIndex != e.getFirstIndex()) { //다음에 들어온 이벤트가 이전에 발생했던 곳에서 발생했다면 하지 않음.
                System.out.println(e.getSource().toString()); //이벤트 발생한 애가 누군지 가져오는. tostring하면 클래스 이름이 나옴
            }
            this.previous = e.getSource(); // 지금 들어온 이벤트 저장하고
            this.firstIndex = e.getFirstIndex();
            this.lastIndex = e.getLastIndex();
//
//            try {
//                this.vDirectories = sDirectory.getDirectories(fileName);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//            name = vDirectories.get(this.firstIndex).getName();
//            fileName = sDirectory.match(name);

                try {

                    fileName = pDirectory.setData(this.vDirectories.get(this.firstIndex).getFileName());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
    }

    public class PDirectory extends JTable {
        private static final long serialVersionUID = 1L;

        private DefaultTableModel tableModel;

        public PDirectory() {
            Vector<String> header = new Vector<String>();
            String[] s = {"캠퍼스", "대학", "과목"};
            int cnt = 0;
            header.add(s[cnt]); //column 이름
            cnt++;
            tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
            this.setModel(tableModel);//테이블모델 등록
        }
        public DefaultTableModel getModel(){return this.tableModel;}

        public String setData(String fileName) throws IOException {
            SDirectory sDirectory = new SDirectory(); //데이터를 가져오려면 SDirectory 필요
            Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName); //n개의 vdirectory를 받아옴

            for (VDirectory vDirectory : vDirectories) {
                Vector<String> row = new Vector<String>();
                row.add(vDirectory.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
                tableModel.addRow(row);
            }
            this.setRowSelectionInterval(0, 0); //맨 처음 것을 선택하도록
            this.updateUI();

            return vDirectories.get(0).getFileName(); //0번이 선택한 것에 해당하는 파일네임을 가져오는 것
        }

        public void initialize() {
            tableModel.setNumRows(0);
        }

    }


    public class PLectureTable extends JTable {
        private static final long serialVersionUID = 1L;
        private DefaultTableModel tableModel;

        public PLectureTable() {
            Vector<String> header = new Vector<String>();
            header.add("과목코드"); //column 이름
            header.add("과목명"); //column 이름
            header.add("담당교수"); //column 이름
            header.add("학점"); //column 이름
            header.add("시간"); //column 이름

            tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
            this.setModel(tableModel);//테이블모델 등록
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
                tableModel.addRow(row);
            }
            this.setRowSelectionInterval(0, 0); //맨 처음 것을 선택하도록
            this.updateUI();

        }

        public void initialize() {
            tableModel.setNumRows(0);
        }
    }
}
