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

    public String match(String name) {
        return eDirectory.match(name);
    }

    public String getFileName(){
        return this.vDirectory.getFileName();
    }
}
