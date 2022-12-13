package Ex.View;

import Ex.Entity.ELecture;
import Ex.Global.Constants;
import Ex.Global.Locale;
import Ex.ValueObject.VLecture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.Vector;

//미리 담기 패널과 신청 패널의 부모 패널
public class PResultPanel extends JPanel{
    private Vector<VLecture> vLectures;
    private JTable table;
    public JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public PResultPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.table = new JTable();
        this.scrollPane = new JScrollPane();
        this.scrollPane.setViewportView(this.table);
        this.add(scrollPane);

        String [] header = {Locale.LResultPanel.LECTURENO, Locale.LResultPanel.LECTURENAME};
        this.tableModel = new DefaultTableModel(header,0);
        this.table.setModel(tableModel);
    }
    public Vector<VLecture> getLectures(){return this.vLectures;}

    public void initialize(String fileName){
        ELecture eLecture = new ELecture();
        this.vLectures = eLecture.getDirectories(fileName);
        this.setData();
    }
    public void finish(String fileName) throws IOException {
        ELecture eLecture = new ELecture();
        eLecture.save(fileName, vLectures);
    }
    public void addLectures(Vector<VLecture> vSelectedLectures){
        this.vLectures.addAll(vSelectedLectures);
        this.setData();
    }
    public Vector<VLecture> removeSelectedLectures(){
        Vector<VLecture> removedLectures = new Vector<>();
        int[] indices = this.table.getSelectedRows();
        for(int i= indices.length-1; i>=0; i--){
            VLecture removedLecture = this.vLectures.remove(indices[i]);
            removedLectures.add(removedLecture);
        }
        this.setData();
        return removedLectures;
    }

    private void setData(){
        this.tableModel.setRowCount(0);
        for(VLecture vLecture : this.vLectures){
            Vector<String> row = new Vector<>();
            row.add(vLecture.getId());
            row.add(vLecture.getName());
            this.tableModel.addRow(row);
        }
        if(this.vLectures.size()>0) this.table.setRowSelectionInterval(0,0);
    }
}
