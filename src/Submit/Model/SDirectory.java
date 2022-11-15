package Submit.Model;
import Submit.Entity.EDirectory;
import Submit.ValueObject.VDirectory;

import java.io.IOException;
import java.util.Vector;

public class SDirectory {
    private EDirectory eDirectory;
    private VDirectory vDirectory;

    public SDirectory(){
        this.eDirectory = new EDirectory();
    }

    public Vector<VDirectory> getDirectories(String fileName) throws IOException{
        return this.eDirectory.getDirectories(fileName);
    }

    public boolean match(String fileName) {
        if(this.eDirectory.match(fileName)) return true;
        return false;
    }

    public String getFileName(){
        return this.vDirectory.getFileName();
    }
}
