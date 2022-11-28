package Ex.View;

import Ex.Global.Locale;
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
    private String directoryName;
    public PLectureTable(String directoryName) {
        this.directoryName=directoryName;
        this.sLecture=new SLecture();
        this.vLectures=this.sLecture.getLectures(directoryName+ Locale.HEADER_FILE);
        Vector<String> header = new Vector<String>();
        header.add(this.vLectures.get(0).getId());
        header.add(this.vLectures.get(0).getName());
        header.add(this.vLectures.get(0).getProfessor());
        header.add(this.vLectures.get(0).getCredit());
        header.add(this.vLectures.get(0).getTime());

        this.tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
        this.setModel(this.tableModel);//테이블모델 등록
    }

    public void setData(String fileName) {
        this.sLecture = new SLecture(); //데이터를 가져오려면 SDirectory 필요
        this.vLectures = this.sLecture.getLectures(this.directoryName+fileName); //n개의 vdirectory를 받아옴

        this.tableModel.setNumRows(0);
        for (VLecture vLecture : this.vLectures) {
            Vector<String> row = new Vector<String>();
            //파일에서 읽어온 데이터를 넣어줘야 함
            row.add(vLecture.getId());
            row.add(vLecture.getName());
            row.add(vLecture.getProfessor());
            row.add(vLecture.getCredit());
            row.add(vLecture.getTime());
            this.tableModel.addRow(row);
        }
        this.setRowSelectionInterval(0, 0); //맨 처음 것을 선택하도록
    }
}
