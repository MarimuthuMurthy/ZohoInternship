import java.util.ArrayList;
import java.util.Scanner;

class Subjects{
    String subject1;
    String subject2;
    String subject3;
    String subject4;
    String subject5;
    Subjects(String subject1,String subject2,String subject3,String subject4,String subject5) {
        this.subject1=subject1;
        this.subject2=subject2;
        this.subject3=subject3;
        this.subject4=subject4;
        this.subject5=subject5;
    }
}
class Faculty{
    String faculty1;
    String faculty2;
    String faculty3;
    String faculty4;
    String faculty5;
    Faculty(String faculty1,String faculty2,String faculty3,String faculty4,String faculty5){
        this.faculty1=faculty1;
        this.faculty2=faculty2;
        this.faculty3=faculty3;
        this.faculty4=faculty4;
        this.faculty5=faculty5;
    }
}
class Marks{
     Subjects subjects;
    static Scanner sc=new Scanner(System.in);
     int mark1;
     int mark2;
     int mark3;
     int mark4;
     int mark5;
     boolean addOrNot=false;
    Marks(Subjects s){
        subjects=s;
    }
    public  void getMarks(){
        addOrNot=true;
        System.out.print("enter "+subjects.subject1+" marks: ");
        mark1=sc.nextInt();
        System.out.print("enter "+subjects.subject2+" marks: ");
        mark2=sc.nextInt();
        System.out.print("enter "+subjects.subject3+" marks: ");
        mark3=sc.nextInt();
        System.out.print("enter "+subjects.subject4+" marks: ");
        mark4=sc.nextInt();
        System.out.print("enter "+subjects.subject5+" marks: ");
        mark5=sc.nextInt();
    }
    public String toString(){
        return subjects.subject1+" "+mark1+"\n"+subjects.subject2+" "+mark2+"\n"+subjects.subject3+" "+mark3+"\n"+subjects.subject4+" "+mark4+"\n"+ subjects.subject5+" "+mark5;
    }
}
class CseDepartment{
    private static CseDepartment cseDepartment;
    Subjects s = new Subjects("java", "python", "c","c++","html");
    Faculty f = new Faculty("a", "b", "c", "d", "e");
    private CseDepartment(){}
    public static CseDepartment getInstance(){
        if(cseDepartment ==null){cseDepartment=new CseDepartment();}
        return cseDepartment;
    }
}
class EceDepartment{
    private static EceDepartment eceDepartment;
    Subjects s1=new Subjects("analog","signals","wirelss","communication","system");
    Faculty f1=new Faculty("f","g","h","i","j");
    private EceDepartment(){}
    public static EceDepartment getInstance(){
        if(eceDepartment ==null){eceDepartment=new EceDepartment();}
        return eceDepartment;
    }
}

class MechanicalDepartment{
    private static MechanicalDepartment mechanicalDepartment;
     Subjects s3 = new Subjects("welding", "sheilding", "mech","mech4","mech5");
     Faculty f2 = new Faculty("k", "l", "m", "n", "o");
    private MechanicalDepartment(){}
    public static MechanicalDepartment getInstance(){
        if(mechanicalDepartment ==null){mechanicalDepartment=new MechanicalDepartment();}
        return mechanicalDepartment;
    }
}
class ItDepartment{
    private static ItDepartment itDepartment;
    Subjects s4 = new Subjects("software", "information", "technology", "computer", "networks");
    Faculty f4 = new Faculty( "p", "q", "r", "s", "t");
    private ItDepartment(){}
    public static ItDepartment getInstance(){
        if(itDepartment ==null){itDepartment=new ItDepartment();}
        return itDepartment;
    }
}
class Student
{
    public int studentId;
    public String studentName;
    public String phoneNo;
    public int roomNo;
    public String hostelName;
    public String department;
    public Marks mark;
    Student(int studentId,String studentName,String phoneNo,int roomNo,String hostelName,String department,Marks mark){
        this.studentId=studentId;
        this.studentName=studentName;
        this.phoneNo=phoneNo;
        this.hostelName=hostelName;
        this.roomNo=roomNo;
        this.department=department;
        this.mark=mark;
    }
    public String toString(){return studentId+" "+studentName+" "+phoneNo+" "+roomNo+" "+hostelName+" "+department;}
}