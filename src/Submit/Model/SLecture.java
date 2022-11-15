package Submit.Model;

import Submit.Entity.ELecture;
import Submit.ValueObject.VLecture;

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

