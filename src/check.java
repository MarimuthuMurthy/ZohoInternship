import java.util.*;
class ageRestiction extends Exception{

    public ageRestiction(){
    }
}
public class check {
    public static void age(int x){
        System.out.println(x);
        System.out.println("bye");
    }
    public static void  main(String args[]) {

    Scanner sc=new Scanner(System.in);
    try{
        int age=sc.nextInt();
        if(age<13){
            throw new ageRestiction();
        }
        }
    catch(ageRestiction e){
        System.out.println("age is greater than 13");
    }

     }
}

