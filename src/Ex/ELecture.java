package Ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ELecture {
    public Vector<VLecture> getDirectories(String fileName) {
        //filename을 읽어서 벡터를 만들어 가져와야함
        Vector<VLecture> vLectures = new Vector<VLecture>();
        try {
            Scanner scanner = new Scanner(new File("directory/"+fileName)); //directory를 Lecture로 바꿔야 하나?
            while(scanner.hasNext()){//file이 끝날 때까지 읽어라
                VLecture vLecture = new VLecture();
                vLecture.read(scanner);
                vLectures.add(vLecture);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
