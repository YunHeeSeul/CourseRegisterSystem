package Ex.Model;

import Ex.Entity.ELecture;
import Ex.ValueObject.VLecture;

import java.util.Vector;

public class SLecture {
    private ELecture eLecture;
    public SLecture(){
        this.eLecture = new ELecture();
    }

    public Vector<VLecture> getLectures(String fileName){
        return this.eLecture.getDirectories(fileName);
    }
}

