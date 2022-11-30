package Submit.Entity;

import Submit.Global.Locale;
import Submit.ValueObject.VLecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class ELecture {
    private Vector<VLecture> vLectures;
    public Vector<VLecture> getDirectories(String fileName) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(Locale.PATH+fileName));
            vLectures = new Vector<>();

            while(bf.ready()){//file이 끝날 때까지 읽어라
                String fileInfo = bf.readLine();
                if(!fileInfo.equals(Locale.BLANK)) this.vLectures.add(new VLecture(fileInfo));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vLectures;
    }
}
