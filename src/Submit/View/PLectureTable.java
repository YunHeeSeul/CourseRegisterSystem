package Submit.View;

import Submit.Model.SLecture;
import Submit.ValueObject.VLecture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class PLectureTable extends JTable {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel tableModel;
    private SLecture sLecture;

    public PLectureTable() {
        Vector<String> header = new Vector<String>();
        String[] hValue = {"강좌번호", "강좌명", "담당교수", "학점", "시간"};
        for(int i=0; i<hValue.length; i++) header.add(hValue[i]);

        this.tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
        this.setModel(this.tableModel);//테이블모델 등록
    }

    public void setLData(String fileName) {
        sLecture = new SLecture(); //데이터를 가져오려면 SDirectory 필요
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
        this.updateUI();
        this.setRowSelectionInterval(0, 0); //맨 처음 것을 선택하도록
    }
    public void initialize(){
        this.tableModel.setNumRows(0);
    }
}
