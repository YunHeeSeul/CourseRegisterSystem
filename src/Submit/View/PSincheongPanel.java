package Submit.View;

import Ex.Global.Locale;
import Submit.ValueObject.VLecture;

import javax.swing.*;
import java.util.Vector;

public class PSincheongPanel extends PLectureTable{
    public PSincheongPanel(PSugangSincheongPanel.ListSelectionHandler listSelectionHandler){
        super(Locale.DIRECTORY_DEPARTMENT);
        this.getSelectionModel().addListSelectionListener(listSelectionHandler);
        JScrollPane jScrollPane2 = new JScrollPane();
    }

    public void addLectures(Vector<VLecture> vLectures) {
    }

    public Vector<VLecture> getSelectedLectures() {
        return null;
    }}
