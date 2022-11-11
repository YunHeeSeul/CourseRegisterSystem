package Ex;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class ELecture {
    Vector<VLecture> vLectures;
    public Vector<VLecture> getDirectories(String fileName) {
        //filename을 읽어서 벡터를 만들어 가져와야함
        try {
            BufferedReader bf = new BufferedReader(new FileReader("directory/"+fileName));
            vLectures = new Vector<VLecture>();

            while(bf.ready()){//file이 끝날 때까지 읽어라
                String fileInfo = bf.readLine();
                if(!fileInfo.equals("")) this.vLectures.add(new VLecture(fileInfo));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vLectures;
    }
}
