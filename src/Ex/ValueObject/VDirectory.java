package Ex.ValueObject;

import java.io.Serializable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class VDirectory implements Serializable{
    //value object�� ������ �׻� �̷� ��
    private String id;
    private String name;
    private String fileName;
    public String getId() {return id;}
    public String getName() {return name;}
    public String getFileName() {return fileName;}
    public void setFileName(String fileName) {this.fileName = fileName;}

//    public VDirectory(String fileInfo) {
//        StringTokenizer st = new StringTokenizer(fileInfo);
//        this.id = st.nextToken();
//        this.name = st.nextToken();
//        this.fileName = st.nextToken();
//    }

    public void read(Scanner scanner) {
        this.id = scanner.next();
        this.name = scanner.next();
        this.fileName = scanner.next();
    }

    public String matchFile(String name) {
        return this.fileName;
    }
}