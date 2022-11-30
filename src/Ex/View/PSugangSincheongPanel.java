package Ex.View;

import Ex.ValueObject.VLecture;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class PSugangSincheongPanel extends JPanel {
    private PDirectoryPanel pDirectoryPanel;
    private PControlPanel pControlPanel1, pControlPanel2;
    private PMiriDamgiPanel pMiriDamgiPanel;
    private PSincheongPanel pSincheongPanel;
    public PSugangSincheongPanel() throws IOException {
        //this.setLayout(new GridLayout(1,2,10,10));
        ActionHandler actionHandler = new ActionHandler();
        ListSelectionHandler listSelectionHandler = new ListSelectionHandler();

        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        this.pDirectoryPanel=new PDirectoryPanel();
        this.add(this.pDirectoryPanel);

        this.pControlPanel1 = new PControlPanel("1",actionHandler);
        this.add(this.pControlPanel1);

        JScrollPane jScrollPane = new JScrollPane();
        this.pMiriDamgiPanel = new PMiriDamgiPanel(listSelectionHandler);
        jScrollPane.setViewportView(this.pMiriDamgiPanel);
        this.add(jScrollPane);

        this.pControlPanel2 = new PControlPanel("2",actionHandler);
        this.add(this.pControlPanel2);

        jScrollPane = new JScrollPane();
        this.pSincheongPanel = new PSincheongPanel(listSelectionHandler);
        jScrollPane.setViewportView(this.pSincheongPanel);
        this.add(jScrollPane);
    }

    //버튼으로 정보 옮기기
    private void moveFromLectureToMiridamgi() {
        Vector<VLecture> vLectures = this.pDirectoryPanel.getSelectedLectures();
        this.pMiriDamgiPanel.addLectures(vLectures);
        System.out.println("1. moveFromLectureToMiridamgi");
    }
    private void moveFromMiridamgiToLecture() {
        Vector<VLecture> vLectures = this.pMiriDamgiPanel.getSelectedLectures();
        this.pDirectoryPanel.addLectures(vLectures);
        System.out.println("2. moveFromMiridamgiToLecture");

    }
    private void moveFromMiridamgiToSincheong() {
        Vector<VLecture> vLectures = this.pMiriDamgiPanel.getSelectedLectures();
        this.pSincheongPanel.addLectures(vLectures);
        System.out.println("3. moveFromMiridamgiToSincheong");

    }
    private void moveFromSincheongToMiridamgi() {
        //multi selection이 가능해서 벡터로 받아오는 것
        Vector<VLecture> vLectures = this.pSincheongPanel.getSelectedLectures();
        this.pMiriDamgiPanel.addLectures(vLectures);
        System.out.println("4. moveFromSincheongToMiridamgi");

    }

    public class ActionHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().compareTo("1>>")==0){
                //lecturePanel에서 miriDamgiPanel로
                moveFromLectureToMiridamgi();
            }else if(e.getActionCommand().compareTo("1<<")==0){
                //lecturePanel에서 miriDamgiPanel로
                moveFromMiridamgiToLecture();
            }
            if(e.getActionCommand().compareTo("2>>")==0){
                //lecturePanel에서 miriDamgiPanel로
                moveFromMiridamgiToSincheong();
            }else if(e.getActionCommand().compareTo("2<<")==0){
                //lecturePanel에서 miriDamgiPanel로
                moveFromSincheongToMiridamgi();
            }
        }
    }

    public class ListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(!e.getValueIsAdjusting()) updateTable(e.getSource());
        }
    }

    private void updateTable(Object object) {
    }
}
