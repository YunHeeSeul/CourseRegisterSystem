package Ex.Entity;

import Ex.Global.Locale;
import Ex.ValueObject.VDirectory;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class EDirectory {
    private VDirectory v;
    private Vector<VDirectory> vDirectories;

    public Vector<VDirectory> getDirectories(String fileName){
        //filename�� �о ���͸� ����� �����;���
        vDirectories = new Vector<>();

        try {
            File file = new File(Locale.PATH+fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){//file�� ���� ������ �о��
                v = new VDirectory();
                v.read(scanner);
                vDirectories.add(v);
            }scanner.close();
        } catch (FileNotFoundException e) {e.printStackTrace();        }
        return vDirectories;
    }
//
//    public String match(String name) {
//        for(VDirectory v : this.vDirectories)
//            if(v.getName().equals(name)) return v.matchFile(name);
//        return Locale.BLANK;
//    }

}
