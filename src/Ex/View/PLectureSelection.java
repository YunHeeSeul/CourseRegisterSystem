package Ex.View;

import Ex.ValueObject.VLecture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

//lectureTable ������Ʈ ���ִ� �κ�
public class PLectureSelection extends JTable {
    private Vector<VLecture> vLectures;
    private DefaultTableModel tableModel;

    private String departmentFileName;
    private PResultPanel pMiridamgiPanel;
    private PResultPanel PSincheongPanel;
}
