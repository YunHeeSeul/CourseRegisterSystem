package Submit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EDirectory {
    ArrayList<VDirectory> rootList;
    VDirectory vDirectory;
    public EDirectory() throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("root.txt"));
        rootList = new ArrayList<VDirectory>();
        while (br1.ready()){
            String rootInfo = br1.readLine();
            if(!rootInfo.equals("")) this.rootList.add(new VDirectory(rootInfo));
        }
        br1.close();
    }
}
