
import java.util.*;


public class Student {
    private int studentID; 
    private String name; 
    private double gpa; 
    private String gender; 

    public Student(int studentID, String name, double gpa, String gender){
        this.studentID = studentID; 
        this.name = name; 
        this.gpa = gpa; 
        this.gender = gender; 
    }

    public int getID(){
        return studentID;
    }

    public String getName(){
        return name; 
    }

    public double getGPA(){
        return gpa;
    }

    public String getGender(){
        return gender; 
    }

    //overriding og object class 
    @Override
    public String toString(){
        return studentID + " " + name + " " + gpa + " " + gender; 
    }

    //sort students by GPA
    public static void sortByGPA(List<Student> students){
    //collections sort the list in that very list 
    //Student::getGPA acts like a func that takes Student obj and returns double value of GPA
    students.sort(Comparator.comparingDouble(Student::getGPA));
    }

    //search Student 
    public static Student searchStudent(List<Student> students, int studentID){
        for(Student s : students){
            if(s.getID() == studentID){
                return s; 
            }
        }
        return null; 
    }

    //mapping student w gender
    public static Map<String, List<Student>> groupByGender(List<Student> students){
        Map<String, List<Student>> map = new HashMap<>();

        //iterating through each student
        for(Student s: students){
            //if no mentioned gender, make a new list
            if(!map.containsKey(s.getGender())){
                map.put(s.getGender(), new ArrayList<>());
            }

            //if gender exists then add it to existing list 
            //map.get("Male").add(Charlie)
            map.get(s.getGender()).add(s);
        }
        return map;
    }    

}
