package Ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class EDirectory {
    Vector<VDirectory> vDirectories;

    public Vector<VDirectory> getDirectories(String fileName) throws IOException {
        //filename�� �о ���͸� ����� �����;���
        vDirectories = new Vector<VDirectory>();
        BufferedReader bf = new BufferedReader(new FileReader("directory/"+fileName));

        //Scanner scanner = new Scanner(new File("directory/"+fileName));
        //while(scanner.hasNext()){//file�� ���� ������ �о��
        while(bf.ready()) {
//            	VDirectory vDirectory = new VDirectory();
//                vDirectory.read(scanner);
//                vDirectoryList.add(vDirectory);
            String fileInfo = bf.readLine();
            if(!fileInfo.equals("")) this.vDirectories.add(new VDirectory(fileInfo));
        }
        return vDirectories;
    }

    public boolean match(String fileName) {
        for(VDirectory v : this.vDirectories)
            if(v.matchFile(fileName)) return true;
        return false;
    }
}
