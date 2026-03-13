import java.util.*; 
public class Main {
    public static void main(String[] args){
        DataStore<Student> store = new DataStore<>();

        store.add(new Student(1, "Meow", 3.4, "Male"));
        store.add(new Student(2, "Nyaa", 3.5, "Female"));
        store.add(new Student(3, "Ting", 3.6, "Male"));
        store.add(new Student(4, "Pong", 3.7, "Female"));

        List<Student> students = store.getAll();

        //sort by GPA
        Student.sortByGPA(students);
        System.out.println("Sorting by GPA: ");
        for(Student s : students){
            System.out.println(s.getName() + ", " + s.getGPA());
        }

            //search Student
        Student query = Student.searchStudent(students, 3);
        System.out.println("\nSearch result: " + query);

        //group by gender
        Map<String, List<Student>> grouped = Student.groupByGender(students);
        System.out.println("\nGrouped by Gender: " + grouped);
    }

}
