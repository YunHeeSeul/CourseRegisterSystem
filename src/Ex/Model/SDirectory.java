package Ex.Model;
import Ex.Entity.EDirectory;
import Ex.ValueObject.VDirectory;

import java.io.IOException;
import java.util.Vector;

public class SDirectory {
    private EDirectory eDirectory;
    private VDirectory vDirectory;

    public SDirectory() {
        this.eDirectory = new EDirectory();
        this.vDirectory = new VDirectory();
    }

    public Vector<VDirectory> getDirectories(String fileName) throws IOException {
        return this.eDirectory.getDirectories(fileName);
    }

    public String getFileName() {
        return this.vDirectory.getFileName();
    }
}