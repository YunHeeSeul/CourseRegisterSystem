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
        header.add("Test"); //column �̸�
        this.tableModel = new DefaultTableModel(header, 0);//���̺�� ����
        this.setModel(this.tableModel);//���̺�� ���

    }

    public void setFileName(String fileName) throws IOException {
        SDirectory sDirectory = new SDirectory(); //�����͸� ���������� SDirectory �ʿ�
        Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName); //n���� vdirectory�� �޾ƿ�

        for(VDirectory vDirectory : vDirectories){
            Vector<String> row = new Vector<String>();
            row.add(vDirectory.getName()); //���Ͽ��� �о�� �����͸� �־���� ��
            this.tableModel.addRow(row);
        }
    }

    public void setData(String[] fileName) throws IOException{
        SDirectory sDirectory = new SDirectory(); //�����͸� ���������� SDirectory �ʿ�

        for(int i=0; i<fileName.length;i++) {
            Vector<VDirectory> vDirectories = sDirectory.getDirectories(fileName[i]); //n���� vdirectory�� �޾ƿ�
            for(VDirectory vDirectory : vDirectories){
                Vector<String> row = new Vector<String>();
                row.add(vDirectory.getName()); //���Ͽ��� �о�� �����͸� �־���� ��
                this.tableModel.addRow(row);
            }
        }
    }
}
