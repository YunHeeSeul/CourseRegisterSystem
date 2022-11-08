package Ex;

import java.io.IOException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PDirectory extends JTable{
    private static final long serialVersionUID = 1L;

    private DefaultTableModel tableModel;
    public PDirectory(){
        Vector<String> header = new Vector<String>();
        header.add("Test"); //column 이름
        this.tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
        this.setModel(this.tableModel);//테이블모델 등록

    }

    public void setFileName(String fileName) throws IOException {
        SDirectory sDirectory = new SDirectory(); //데이터를 가져오려면 SDirectory 필요
        Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName); //n개의 vdirectory를 받아옴

        for(VDirectory vDirectory : vDirectories){
            Vector<String> row = new Vector<String>();
            row.add(vDirectory.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
            this.tableModel.addRow(row);
        }
    }

    public void setData(String[] fileName) throws IOException{
        SDirectory sDirectory = new SDirectory(); //데이터를 가져오려면 SDirectory 필요

        for(int i=0; i<fileName.length;i++) {
            Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName[i]); //n개의 vdirectory를 받아옴
            for(VDirectory vDirectory : vDirectories){
                Vector<String> row = new Vector<String>();
                row.add(vDirectory.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
                this.tableModel.addRow(row);
            }
        }
    }
}
