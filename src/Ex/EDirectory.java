package Ex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class EDirectory {
    VDirectory v;
    Vector<VDirectory> vDirectoryList;

    public Vector<VDirectory> getDirectories(String fileName) throws IOException {
        //filename�� �о ���͸� ����� �����;���
        vDirectoryList = new Vector<VDirectory>();
        BufferedReader bf = new BufferedReader(new FileReader("directory/"+fileName));

        //Scanner scanner = new Scanner(new File("directory/"+fileName));
        //while(scanner.hasNext()){//file�� ���� ������ �о��
        while(bf.ready()) {
//            	VDirectory vDirectory = new VDirectory();
//                vDirectory.read(scanner);
//                vDirectoryList.add(vDirectory);
            String fileInfo = bf.readLine();
            if(!fileInfo.equals("")) this.vDirectoryList.add(new VDirectory(fileInfo));
        }
        return vDirectoryList;
    }

    public boolean match(String fileName) {
        for(VDirectory v : this.vDirectoryList)
            if(v.matchFile(fileName)) return true;
        return false;
    }
}
