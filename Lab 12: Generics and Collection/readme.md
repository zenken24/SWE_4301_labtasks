# Lab 12: Generics and Collection

## Overview
This lab demonstrates how to use Java generics and common collection classes to manage student records.

The project builds a reusable generic data store and performs three operations on a student list:
- Sort students by GPA
- Search for a student by ID
- Group students by gender

## Learning Goals
- Understand why generics (`<T>`) make code reusable and type-safe
- Practice using `List`, `Map`, `ArrayList`, and `HashMap`
- Use `Comparator` for sorting
- Implement basic search and grouping logic

## Project Files
- `DataStore.java`: Generic class for storing and retrieving items (`DataStore<T>`)
- `Student.java`: Student model plus helper methods for sorting, searching, and grouping
- `Main.java`: Driver class that creates sample students and prints results
- `tempCodeRunnerFile.java`: Temporary editor-generated file (not required for the lab)

## How It Works
1. `Main` creates `DataStore<Student>`.
2. Four student objects are added.
3. Students are sorted by GPA in ascending order.
4. A student is searched by ID (`3`).
5. Students are grouped into a map by gender.

## Run Instructions
From this folder, run:

```bash
javac Main.java
java Main
```

## Sample Output
```text
Sorting by GPA:
Meow, 3.4
Nyaa, 3.5
Ting, 3.6
Pong, 3.7

Search result: 3 Ting 3.6 Male

Grouped by Gender: {Male=[1 Meow 3.4 Male, 3 Ting 3.6 Male], Female=[2 Nyaa 3.5 Female, 4 Pong 3.7 Female]}
```

## Notes
- Sorting uses `Comparator.comparingDouble(Student::getGPA)`.
- Search is linear (`O(n)`) because it checks each student one by one.
- Grouping uses a `HashMap<String, List<Student>>`.

## Optional Improvements
- Return `Optional<Student>` instead of `null` in search
- Use Streams API (`Collectors.groupingBy`) for grouping
- Add input handling so users can add/search students interactively
