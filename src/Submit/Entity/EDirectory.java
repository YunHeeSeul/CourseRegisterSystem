package Submit.Entity;

import Submit.ValueObject.VDirectory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class EDirectory {
    private static final String PATH = "directory/";
    VDirectory v;
    Vector<VDirectory> vDirectories;

    public Vector<VDirectory> getDirectories(String fileName){
        //filename�� �о ���͸� ����� �����;���
        vDirectories = new Vector<VDirectory>();

        try {
            File file = new File(PATH+fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){//file�� ���� ������ �о��
                v = new VDirectory();
                v.read(scanner);
                vDirectories.add(v);
            }scanner.close();
        } catch (FileNotFoundException e) {e.printStackTrace();        }
        return vDirectories;
    }

    public boolean match(String fileName) {
        for(VDirectory v : this.vDirectories)
            if(v.matchFile(fileName)) return true;
        return false;
    }

}
