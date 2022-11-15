package Ex.Entity;

import Ex.ValueObject.VLecture;

import java.io.*;
import java.util.Vector;

public class ELecture {
    private static final String PATH = "directory/";
    private VLecture v;
    Vector<VLecture> vLectures;
    public Vector<VLecture> getDirectories(String fileName) {
//        //filename을 읽어서 벡터를 만들어 가져와야함
//        vLectures = new Vector<VLecture>();
//        try {
//            File file = new File(PATH+fileName);
//            Scanner scanner = new Scanner(file);
//            while(scanner.hasNext()){
//                v = new VLecture();
//                v.read(scanner);
//                vLectures.add(v);
//            }scanner.close();
//        } catch (FileNotFoundException e) {e.printStackTrace();}
//        return vLectures;
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
