package Submit.View;

import Submit.Model.SDirectory;
import Submit.ValueObject.VDirectory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.Vector;

public class PDirectory extends JTable{
    private static final long serialVersionUID = 1L;
    private SDirectory sDirectory;
    private DefaultTableModel tableModel;
//    public PDirectory(){
//        Vector<String> header = new Vector<String>();
//        header.add("Test"); //column 이름
//        this.tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
//        this.setModel(this.tableModel);//테이블모델 등록
//
//    }
//
//    public void setFileName(String fileName) throws IOException {
//        SDirectory sDirectory = new SDirectory(); //데이터를 가져오려면 SDirectory 필요
//        Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName); //n개의 vdirectory를 받아옴
//
//        for(VDirectory vDirectory : vDirectories){
//            Vector<String> row = new Vector<String>();
//            row.add(vDirectory.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
//            this.tableModel.addRow(row);
//        }
//    }
//
//    public void setData(String[] fileName) throws IOException{
//        SDirectory sDirectory = new SDirectory(); //데이터를 가져오려면 SDirectory 필요
//
//        for(int i=0; i<fileName.length;i++) {
//            Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName[i]); //n개의 vdirectory를 받아옴
//            for(VDirectory vDirectory : vDirectories){
//                Vector<String> row = new Vector<String>();
//                row.add(vDirectory.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
//                this.tableModel.addRow(row);
//            }
//        }
//    }

    public PDirectory(String head) {
        Vector<String> header = new Vector<String>();
        header.add(head); //column 이름
        this.tableModel = new DefaultTableModel(header, 0);//테이블모델 생성
        this.setModel(this.tableModel);//테이블모델 등록
    }

    public void initialize(){
        this.tableModel.setNumRows(0);
    }

    public String setData(String fileName) throws IOException {
        sDirectory = new SDirectory(); //데이터를 가져오려면 SDirectory 필요
        Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName); //n개의 vdirectory를 받아옴
        for(VDirectory vDirectory : vDirectories){
            Vector<String> row = new Vector<String>();
            row.add(vDirectory.getName()); //파일에서 읽어온 데이터를 넣어줘야 함
            this.tableModel.addRow(row);
        }
        this.updateUI();
        this.setRowSelectionInterval(0,0); //맨 처음 것을 선택하도록
        return vDirectories.get(0).getFileName(); //0번이 선택한 것에 해당하는 파일네임을 가져오는 것
    }
}
