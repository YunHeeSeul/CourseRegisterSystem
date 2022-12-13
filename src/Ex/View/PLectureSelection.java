package Ex.View;

import Ex.ValueObject.VLecture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

//lectureTable 업데이트 해주는 부분
public class PLectureSelection extends JTable {
    private Vector<VLecture> vLectures;
    private DefaultTableModel tableModel;

    private String departmentFileName;
    private PResultPanel pMiridamgiPanel;
    private PResultPanel PSincheongPanel;
}
