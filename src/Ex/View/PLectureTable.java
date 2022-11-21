package Ex.View;

import Ex.Model.SLecture;
import Ex.ValueObject.VLecture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

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

        this.tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
        this.setModel(this.tableModel);//테이블모델 등록
    }

    public Vector<VLecture> getVLecture(){return this.vLectures;}

    public void setData(String fileName) {
        this.sLecture = new SLecture(); //데이터를 가져오려면 SDirectory 필요
        this.vLectures = this.sLecture.getLectures(fileName); //n개의 vdirectory를 받아옴

        this.tableModel.setNumRows(0);
        for (VLecture vLecture : this.vLectures) {
            Vector<String> row = new Vector<String>();
            row.add(vLecture.getId()); //파일에서 읽어온 데이터를 넣어줘야 함
            row.add(vLecture.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
            row.add(vLecture.getProfessor()); //파일에서 읽어온 데이터를 넣어줘야 함
            row.add(vLecture.getCredit()); //파일에서 읽어온 데이터를 넣어줘야 함
            row.add(vLecture.getTime()); //파일에서 읽어온 데이터를 넣어줘야 함
            this.tableModel.addRow(row);
        }
        //this.setRowSelectionInterval(0, 0); //맨 처음 것을 선택하도록
    }
}
