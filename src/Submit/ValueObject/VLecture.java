package Submit.ValueObject;

import java.util.StringTokenizer;

public class VLecture {
    //value object의 형식은 항상 이런 식
    private String id;
    private String name;
    private String professor;
    private String credit;
    private String time;
    public String getId() {return id;}
    public String getName() {return name;}
    public String getProfessor() {return professor;}
    public String getCredit() {return credit;}
    public String getTime() {return time;}

//    public void read(Scanner scanner) {
//        if(scanner.hasNext()) {
//            this.id = scanner.next();
//            this.name = scanner.next();
//            this.professor = scanner.next();
//            this.credit = scanner.next();
//            this.time = scanner.next();
//        }
//    }

    public VLecture(String fileInfo){
        StringTokenizer st = new StringTokenizer(fileInfo);
        this.id = st.nextToken();
        this.name = st.nextToken();
        this.professor = st.nextToken();
        if(st.hasMoreTokens()) {
            this.credit = st.nextToken();
            this.time = st.nextToken();
        }
    }
}
