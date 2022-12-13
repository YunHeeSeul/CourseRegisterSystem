package Ex.View;

import Ex.Global.Locale;
import Ex.ValueObject.VLecture;

import javax.swing.*;
import java.util.Vector;

public class PMiriDamgiPanel extends PLectureTable{
    public PMiriDamgiPanel(PSugangSincheongPanel.ListSelectionHandler listSelectionHandler){
        super(Locale.DIRECTORY_DEPARTMENT);
        this.getSelectionModel().addListSelectionListener(listSelectionHandler);
        JScrollPane jScrollPane1 = new JScrollPane();
    }

    public void addLectures(Vector<VLecture> vLectures) {
    }

    public Vector<VLecture> getSelectedLectures() {
        return null;
    }

}
