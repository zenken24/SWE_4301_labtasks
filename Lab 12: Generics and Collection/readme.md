# Lab Report
## Course
Object Oriented Programming

## Experiment Title
Lab 12: Generics and Collection

## Date
March 14, 2026

## 1. Introduction
This experiment focuses on using Java Generics and Collection Framework classes to build a simple and reusable student record management system. The implementation demonstrates how generic classes improve flexibility and type safety, and how collection structures support common operations such as sorting, searching, and grouping.

## 2. Objectives
1. To implement a generic data storage class in Java.
2. To apply collection data structures such as List and Map.
3. To sort objects using Comparator.
4. To search objects by key attributes.
5. To group objects based on a common property.

## 3. Tools and Environment
1. Language: Java
2. IDE/Editor: Visual Studio Code
3. Compiler: javac
4. Runtime: java

## 4. Problem Statement
Design and implement a Java program that stores Student objects in a generic container and performs the following tasks:
1. Sort students by GPA.
2. Search a student by student ID.
3. Group students by gender.

## 5. Methodology and Implementation
### 5.1 Generic Storage
DataStore<T> is a generic class that stores elements in an ArrayList. It includes:
1. add(T item): Adds an item to the store.
2. getAll(): Returns all stored items.

### 5.2 Student Model and Operations
The Student class defines the data fields:
1. studentID
2. name
3. gpa
4. gender

It also provides the following static operations:
1. sortByGPA(List<Student> students)
2. searchStudent(List<Student> students, int studentID)
3. groupByGender(List<Student> students)

### 5.3 Program Flow
1. Create DataStore<Student>.
2. Insert four student objects.
3. Retrieve students as a list.
4. Sort by GPA and display results.
5. Search for student ID 3 and display result.
6. Group by gender and display grouped data.

## 6. Execution Procedure
Run the following commands from this folder:

```bash
javac Main.java
java Main
```

## 7. Observed Output
```text
Sorting by GPA:
Meow, 3.4
Nyaa, 3.5
Ting, 3.6
Pong, 3.7

Search result: 3 Ting 3.6 Male

Grouped by Gender: {Male=[1 Meow 3.4 Male, 3 Ting 3.6 Male], Female=[2 Nyaa 3.5 Female, 4 Pong 3.7 Female]}
```

## 8. Analysis
1. Generic class DataStore<T> allows reusable storage logic for any object type.
2. Sorting by GPA is implemented in ascending order using Comparator.comparingDouble.
3. Search operation uses linear traversal and has O(n) time complexity.
4. Grouping operation uses a HashMap where each gender maps to a list of students.

## 9. Conclusion
The experiment successfully demonstrates the practical use of Generics and Collections in Java. The program is modular, readable, and reusable. It confirms that generics reduce duplication, while collection classes simplify real-world data operations like sorting, searching, and grouping.

## 10. Possible Improvements
1. Replace null return in search with Optional<Student>.
2. Use Java Streams for more concise grouping and sorting.
3. Add user input for dynamic student entry.
