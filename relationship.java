
class EducationInstitute {
    String InstituteName;
    String InstitutePlace;
    EducationInstitute(String name,String place){
        this.InstituteName=name;
        this.InstitutePlace=place;
    }

}
class Course{
    String book1;
    String book2;
    Course(String book1,String book2){
        this.book1=book1;
        this.book2=book2;
    }
    public String toString(){
        return book1+" "+book2;
    }
}
class Student1{
    String name;
    int age;
    Address address;
    Student1(String name,int age,Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String toString(){
        return name+" "+age+" "+address+" ";
    }

}
class Department {
    Student1 student;
    String departmentName;
    Course course;
    Department(Student1 student,Course course,String departmentName){
        this.student=student;
        this.course=course;
        this.departmentName=departmentName;
    }
    public String toString(){
        return student+" "+course+" "+departmentName;
    }

}
class University extends EducationInstitute{
    Department department;
    University(Student1 s1,Course c1,String departmentName,String name,String place){
        super(name,place);
        this.department =new Department(s1,c1,departmentName);
    }
}
class Address{
    String area;
    String city;
    String pincode;
    Address(String area,String city,String pincode){
        this.area=area;
        this.city=city;
        this.pincode=pincode;
    }
    public String toString(){
        return area+" "+city+" "+pincode;
    }
}
public class RelationSHip {
    public static void main(String args[]){
        Address add=new Address("tirupati","Chittoor","517501");
        Student1 student=new Student1("M.Murthy",21,add);
        Course course=new Course("java","python");
        University university=new University(student,course,"CSE","ZOHOUNIVERSITY","CHENNAI");
        System.out.println(add);
        System.out.println(student);
        System.out.println(course);
        System.out.println(university.department);
        university=null;
        System.out.println(university.department);
    }
}
//______________________________________________________________________________________

