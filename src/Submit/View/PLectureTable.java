package Submit.View;

import Submit.Global.Locale;
import Submit.Model.SLecture;
import Submit.ValueObject.VLecture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class PLectureTable extends JTable {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel tableModel;
    private SLecture sLecture;
    private String directoryName;
    private Vector<VLecture> vLectures;
    public PLectureTable(String directoryName) {
        this.directoryName=directoryName;
        this.sLecture=new SLecture();
        this.vLectures=this.sLecture.getLectures(Locale.DIRECTORY_DEPARTMENT+ Locale.HEADER_FILE);
        Vector<String> header = new Vector<String>();
        header.add(this.vLectures.get(0).getId());
        header.add(this.vLectures.get(0).getName());
        header.add(this.vLectures.get(0).getProfessor());
        header.add(this.vLectures.get(0).getCredit());
        header.add(this.vLectures.get(0).getTime());

        this.tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
        this.setModel(this.tableModel);//테이블모델 등록
    }

    //미리 담기와 신청 패널에서 사용하기 위해 setData와 queryData를 나눈 것.
    //미리 담기와 신청에서 그대로 쓸려면 setData 할 때 그냥 setData만 해야지
    //가서 읽어오면 안됨. 주는 걸 그대로 읽어야 함.
    //디렉토리에 있는 lecturetable은 엔티티에서 읽어오는 것이고
    //미리 담기는 렉쳐에 있는 걸 꺼내서 읽어야 함. 따라서 queryData가 필요없음
    public Vector<VLecture> queryData(String fileName){ //파일에서 데이터를 읽어오는 부분
        this.sLecture = new SLecture(); //데이터를 가져오려면 SDirectory 필요
        return this.sLecture.getLectures(this.directoryName+fileName); //n개의 vdirectory를 받아옴
    }

    public void setData(Vector<VLecture> vLectures) {//테이블에 데이터를 세팅하는 부분
        this.tableModel.setNumRows(0);
        for (VLecture vLecture : vLectures) {
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

    public Vector<VLecture> getSelectedLectures() {
        int[] selectedRows = this.getSelectedRows(); //선택된 행 다 집어넣기
        return null;
    }
}
