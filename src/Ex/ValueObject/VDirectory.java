package Ex.ValueObject;

import java.io.Serializable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class VDirectory implements Serializable{
    //value object의 형식은 항상 이런 식
    private String id;
    private String name;
    private String fileName;
    public String getId() {return id;}
    public String getName() {return name;}
    public String getFileName() {return fileName;}
    public void setFileName(String fileName) {this.fileName = fileName;}

    public void read(Scanner scanner) {
        this.id = scanner.next();
        this.name = scanner.next();
        this.fileName = scanner.next();
    }
    public String getString(){
        String retVal = this.id + " " + this.name + " " + this.fileName;
        return retVal + "\n";
    }
}
