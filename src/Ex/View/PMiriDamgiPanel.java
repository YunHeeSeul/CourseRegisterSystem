package Ex.View;

import Ex.Model.SLecture;
import Ex.ValueObject.VLecture;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class PMiriDamgiPanel extends PLectureTable{
    public PMiriDamgiPanel(){
        JScrollPane jScrollPane1 = new JScrollPane();
    }
//    private ListSelectionHandler listSelectionHandler;
//    private JTable pMiriDamgiTable;
//
//    private Vector<String> header;
//    PDirectoryPanel pDirectoryPanel;
//    public PMiriDamgiPanel(){
//        this.listSelectionHandler = new ListSelectionHandler();
//        this.pMiriDamgiTable = new JTable(){
//            @Override
//            public boolean isCellEditable(int row, int col){return false;}
//        };
//        this.pMiriDamgiTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
//
//        this.add(this.pMiriDamgiTable);
//        updateTable(null,null);
//    }
//
//    public class PMiriDamgiTable extends JTable{
//        private DefaultTableModel tableModel;
//        private SLecture sLecture;
//        private Vector<VLecture> vLectures;
//        public PMiriDamgiTable(){
//            header=new Vector<>();
//            String[] h = {"강좌 번호", "강좌명"};
//            int cnt=0;
//            header.add(h[cnt]);
//            cnt++;
//            this.tableModel = new DefaultTableModel();
//            this.setModel(this.tableModel); //테이블 모델 등록
//        }
//        public String setData(String fileName){
//            this.sLecture = new SLecture();
//            this.vLectures = this.sLecture.getLectures(fileName);
//            this.tableModel.setNumRows(0);
//
//            for(VLecture vLecture : this.vLectures) {
//                Vector<String> row = new Vector<String>();
//                row.add(vLecture.getId());
//                row.add(vLecture.getName());
//                this.tableModel.addRow(row);
//            }
//            return this.vLectures.get(0).getId();
//
//        }
//        private Vector<VLecture> getVLecture(){return this.vLectures;}
//
//
//}
//    public void updateTable(Vector<String> ID, Vector<String> Name) {
//
////        //데이터를 가져오는 부분
////        if(selectedRow == null){
////            this.pMiriDamgiTable.setData(null);
////        }
////        if(selectedRow != null){
////            this.pMiriDamgiTable.setData(fileName, selectedRow);
////            for(int i=0; i<selectedRow.size(); i++) {
////                System.out.println(selectedRow.get(i));
////                ID.add(this.pMiriDamgiTable.getVLecture().get(i).getId());
////                this.pMiriDamgiTable.setData(ID.get(i));
////            }
////        }
//
//    }
//
//    private class ListSelectionHandler implements ListSelectionListener {
//        ListSelectionHandler(){}
//        Vector<String> selectedID = new Vector<String>();
//        @Override
//        public void valueChanged(ListSelectionEvent e) {
//            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
//            if(!lsm.getValueIsAdjusting()){
//                updateTable(fileName, selectedID);
//            }
//        }
//    }
}
