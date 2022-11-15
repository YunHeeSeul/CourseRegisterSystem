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
//        header.add("Test"); //column �̸�
//        this.tableModel = new DefaultTableModel(header, 0);//���̺�� ����
//        this.setModel(this.tableModel);//���̺�� ���
//
//    }
//
//    public void setFileName(String fileName) throws IOException {
//        SDirectory sDirectory = new SDirectory(); //�����͸� ���������� SDirectory �ʿ�
//        Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName); //n���� vdirectory�� �޾ƿ�
//
//        for(VDirectory vDirectory : vDirectories){
//            Vector<String> row = new Vector<String>();
//            row.add(vDirectory.getName()); //���Ͽ��� �о�� �����͸� �־���� ��
//            this.tableModel.addRow(row);
//        }
//    }
//
//    public void setData(String[] fileName) throws IOException{
//        SDirectory sDirectory = new SDirectory(); //�����͸� ���������� SDirectory �ʿ�
//
//        for(int i=0; i<fileName.length;i++) {
//            Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName[i]); //n���� vdirectory�� �޾ƿ�
//            for(VDirectory vDirectory : vDirectories){
//                Vector<String> row = new Vector<String>();
//                row.add(vDirectory.getName()); //���Ͽ��� �о�� �����͸� �־���� ��
//                this.tableModel.addRow(row);
//            }
//        }
//    }

    public PDirectory(String head) {
        Vector<String> header = new Vector<String>();
        header.add(head); //column �̸�
        this.tableModel = new DefaultTableModel(header, 0);//���̺�� ����
        this.setModel(this.tableModel);//���̺�� ���
    }

    public void initialize(){
        this.tableModel.setNumRows(0);
    }

    public String setData(String fileName) throws IOException {
        sDirectory = new SDirectory(); //�����͸� ���������� SDirectory �ʿ�
        Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName); //n���� vdirectory�� �޾ƿ�
        for(VDirectory vDirectory : vDirectories){
            Vector<String> row = new Vector<String>();
            row.add(vDirectory.getName()); //���Ͽ��� �о�� �����͸� �־���� ��
            this.tableModel.addRow(row);
        }
        this.updateUI();
        this.setRowSelectionInterval(0,0); //�� ó�� ���� �����ϵ���
        return vDirectories.get(0).getFileName(); //0���� ������ �Ϳ� �ش��ϴ� ���ϳ����� �������� ��
    }
}
