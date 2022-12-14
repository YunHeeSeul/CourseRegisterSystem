package Ex.Entity;

import Ex.Global.Locale;
import Ex.ValueObject.VDirectory;
import Ex.ValueObject.VLecture;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class EDirectory {
    private VDirectory v;
    private Vector<VDirectory> vDirectories;

    public Vector<VDirectory> getDirectories(String fileName){
        //filename을 읽어서 벡터를 만들어 가져와야함
        vDirectories = new Vector<>();

        try {
            File file = new File(Locale.PATH+fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){//file이 끝날 때까지 읽어라
                v = new VDirectory();
                v.read(scanner);
                vDirectories.add(v);
            }scanner.close();
        } catch (FileNotFoundException e) {e.printStackTrace();        }
        return vDirectories;
    }

    public void save (String fileName, Vector<VDirectory> vDirectories) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(Locale.PATH+fileName));
        for(VDirectory vDirectory : vDirectories){
            bw.write(vDirectory.getString());
            bw.newLine();
        }bw.close();
    }
//
//    public String match(String name) {
//        for(VDirectory v : this.vDirectories)
//            if(v.getName().equals(name)) return v.matchFile(name);
//        return Locale.BLANK;
//    }

}
