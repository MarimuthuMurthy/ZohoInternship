
import java.util.*;
class HostelNameException extends RuntimeException{
    HostelNameException(String hostel){
        super(hostel);
    }
}
final class Validation{
    final private String email1="vtu15892@veltech.edu.in";
    final private String password1="abc@1";
    final private String email2="vtu15893veltech.edu.in";
    final private String password2="abc@12";
    final private String email3="vtu15894@veltech.edu.in";
    final private String password3="abc@123";
    final private String email4="vtu15895@veltech.edu.in";
    final private String password4="abc@1234";
    final private String email5="vtu15896@veltech.edu.in";
    final private String password5="abc@12345";
    final private LinkedHashMap<String ,String> lhs=new LinkedHashMap<>();
    final private int authorization=5656;
    Validation(){
        lhs.put(email1,password1);
        lhs.put(email2,password2);
        lhs.put(email3,password3);
        lhs.put(email4,password4);
        lhs.put(email5,password5);
    }
    Set<String> keys=lhs.keySet();
    public int checkCredentials(String email,String password){
        for(String key:keys){
            if(key.equals(email) && lhs.get(key).equals(password)){
                return 1;
            }
        }
        return 0;
    }
    public int checkAuthorization(int updateAuthorization){
        if(updateAuthorization==authorization){return 1;}else{return 0;}
    }
}
public class JavaApplication12 {
    public static Student s1;
    public static MarksOfStudent marksOfstudent;
    public static Validation v1;
    public static Scanner sc;
    public static int studentId=0;
    static int count=0;
    static boolean end=true;
    public static MarksOfStudent marksOfStudent1(){
        marksOfstudent =new MarksOfStudent();
        marksOfstudent.subject1=sc.nextInt();
        marksOfstudent.subject2=sc.nextInt();
        marksOfstudent.subject3=sc.nextInt();
        marksOfstudent.subject4=sc.nextInt();
        marksOfstudent.subject5=sc.nextInt();
        return marksOfstudent;
    }
    public static Student getDetails()
    {
        Scanner sc=new Scanner(System.in);
            studentId += 1;
            System.out.print("Enter student name:");
            String studentName = sc.nextLine();
            while (!(studentName.matches("^[A-Za-z'.'\\s]*"))) {
                System.out.println("Invalid name! please enter again");
                studentName = sc.nextLine();
            }
            System.out.print("Enter student phone number:");
            String studentPhone = sc.next();
            while (!(studentPhone.matches("[0-9]{10}"))) {
                System.out.println("Invalid Phone Number! please enter again");
                studentPhone = sc.next();
            }
            System.out.print("Enter student room no:");
            int studentRoom = sc.nextInt();
            while (!(Integer.toString(studentRoom).matches("[0-9]+"))) {
                System.out.println("Invalid Room Number! please enter again");
                studentRoom = sc.nextInt();
            }
            System.out.print("Enter student HostelName:");
            String studentHostel = sc.next();
            if(!(studentHostel.equalsIgnoreCase("prince")||studentHostel.equalsIgnoreCase("leaders"))){

                throw new HostelNameException("Sorry! you are not allowed in the hostel");
            }
            System.out.print("Enter Department Name: ");
            String departmentName=sc.next();
            System.out.println("Enter the Marks: ");
            marksOfstudent=marksOfStudent1();
            s1 = new Student(studentId, studentName, studentPhone, studentRoom, studentHostel,departmentName,marksOfstudent);
        return s1;
    }
    public static void process()
    {
        Scanner sc=new Scanner(System.in);
        List<Student> studentDetails=new ArrayList<>();
        System.out.println("\n 1.ADD STUDENT DETAILS: \n 2.SEE STUDENT DETAILS: \n 3.REMOVE STUDENT DETAILS: \n 4.SEARCH RECORD: \n 5.UPDATE DETAILS: \n END THE PROCESS: ");
        while(end)
        {
            System.out.println("type......(add/want/remove/search/update/end)");
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            String user=sc.next().toLowerCase();
            if(!(user.equals("add") || user.equals("want")||user.equals("end")||user.equals("remove")||user.equals("search")||user.equals("update")||user.equals("score")||user.equals("show")))
            {
                System.out.println("Input is invalid!please Try again");
            }
            if(user.equals("add"))
            {
                Student s2;
                try {
                    s2 = getDetails();
                    int bount = 0;
                    if (count == 0)//for first record purpose only
                    {
                        //departmentDetails.add(d1);
                        studentDetails.add(s2);
                        System.out.println("_ _ _ _ _ __ _ _ _ _ __ _ _ _ _ __");
                        System.out.println("STUDENT RECORD ADDED SUCCESFULLY");
                        System.out.println("_ _ _ _ _ __ _ _ _ _ __ _ _ _ _ __");
                        count++;
                    } else if (count >= 1) {
                        for (Student detail:studentDetails) {
                            if (s2.phoneNo.equals(detail.phoneNo)) {
                                bount++;
                                studentId -= 1;
                                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                                System.out.println("Student id already existed");
                                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                                break;
                            }
                        }
                        if (bount == 0) {
                            studentDetails.add(s2);
                            System.out.println("_ _ _ _ _ __ _ _ _ _ __ _ _ _ _ __");
                            System.out.println("STUDENT RECORD ADDED SUCCESFULLY");
                            System.out.println("_ _ _ _ _ __ _ _ _ _ __ _ _ _ _ __");
                        }
                    }
                }catch(HostelNameException e){
                    System.out.println(e.getMessage());
                }

            }
            else if(user.equals("want")) {
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                System.out.println("press 1:for all student details");
                System.out.println("press 2:for departmentwise students");
                int selection = sc.nextInt();
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                switch (selection) {
                    case 2:
                    System.out.println("Enter the department: ");
                    String dept = sc.next();
                    for (Student detail : studentDetails) {
                        if (detail.department.equals(dept)) {
                            System.out.println(detail);
                        }
                    }
                    break;
                    case 1:for (Student detail : studentDetails) {
                                System.out.println(detail);
                         }
                         break;
                    default:
                        System.out.println("Mispelled occur");
                }
            }
            else if(user.equals("remove"))
            {
                System.out.println("Enter student id for removal:");
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
                int remove=sc.nextInt();
                for(Student detail:studentDetails){
                    if(detail.studentId==remove){
                        studentDetails.remove(detail);
                        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                        System.out.println(remove +" Id record removed succesfully");
                        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
                        break;
                    }
                }
                for(Student detail:studentDetails){
                    if(detail.studentId>=remove+1){
                        int d=detail.studentId;
                        studentId=studentId-1;
                    }
                }
                studentId-=1;
            }
            else if (user.equals("update")) {
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
                System.out.println("******PLEASE ENTER YOUR PIN*******");
                int pin=sc.nextInt();
                if(v1.checkAuthorization(pin)==1) {
                    if (studentDetails.isEmpty()) {
                        System.out.println("NO RECORDS FOUND");
                    } else {
                        System.out.print("Enter StudentId:");
                        int id = sc.nextInt();
                        for (Student detail:studentDetails) {
                            if (detail.studentId == id) {
                                System.out.print("Do you like to change Name:(Y/N)");
                                String wantChangeName = sc.next().toLowerCase();
                                if (wantChangeName.equals("y") || wantChangeName.equals("yes")) {
                                    System.out.print("Enter new Name:");
                                    detail.studentName=sc.next();
                                }
                                System.out.print("Do you like to change Phone Number:(Y/N)");
                                String wantChangePhone = sc.next().toLowerCase();
                                if (wantChangePhone.equals("y")||wantChangePhone.equals("yes")) {
                                    System.out.print("Enter new Phone Number:");
                                    detail.phoneNo=sc.next();
                                }
                                System.out.print("Do you like to change roomNo:(Y/N)");
                                String wantChangeRoomNo = sc.next();
                                if(wantChangeRoomNo.equals("y")||wantChangeRoomNo.equals("yes")) {
                                    System.out.print("Enter new roomNumber:");
                                    detail.roomNo=sc.nextInt();
                                }
                                System.out.print("Do you like to change Hostel:(Y/N)");
                                String wantChangeHostel = sc.next().toLowerCase();
                                if (wantChangeHostel.equals("y")||wantChangeHostel.equals("yes")) {
                                    detail.hostelName=sc.next();
                                }
                            }
                        }
                        System.out.println("*******SUCESSFULLY UPDATED********");
                    }
                }
                else{System.out.println("INCORRECT PIN");}
            }
            else if(user.equals("search"))
            {
                System.out.println("Please enter student Id:");
                int search=sc.nextInt();
                for(Student detail:studentDetails){
                    if(search==detail.studentId){
                        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                        System.out.println("Record Found");
                        System.out.println(detail);
                        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                    }
                }
            }
            else if(user.equals("score")){
                System.out.println("Enter the studentId: ");
                int academics=sc.nextInt();
                for(Student detail:studentDetails){
                    if(academics==detail.studentId && detail.department.equals("cse")){
                        System.out.println(detail.dept.cse);
                    }else if(academics==detail.studentId && detail.department.equals("ece")){
                        System.out.println(detail.dept.ece);
                    }
                    else if(academics==detail.studentId && detail.department.equals("mech")){
                        System.out.println(detail.dept.mech);
                    }
                    else if(academics==detail.studentId && detail.department.equals("it")){
                        System.out.println(detail.dept.it);
                    }
                }
            }
            else if(user.equals("end"))
            {
                end=false;
                System.out.println("*****************************");
                System.out.println("successfully end the process");
                System.out.println("*****************************");

            }
        }
    }
    public static int check()
    {
        sc=new Scanner(System.in);
        System.out.println("Hello! Admin please Enter your Email:");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ __ _ ");
        String adminEmail=sc.next();
        System.out.println("Enter your password:");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ __ _ ");
        String adminPassword =sc.next();
        v1=new Validation();
        if(v1.checkCredentials(adminEmail,adminPassword)==1){
            return 1;
        }
        else{return 0;}
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("******Admin Access******");
            if(check()==1){
                while(end) {
                    process();
                }
            }
        }
    }


