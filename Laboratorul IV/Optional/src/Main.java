import com.github.javafaker.Faker;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        System.out.println("all good!");
        Student student0 = new Student("S0", 6.20);
        Student student1 = new Student("S1", 8.70);
        Student student2 = new Student("S2", 9.30);
        Student student3 = new Student("S3", 7.40);


        School school0 = new School("H0", 1);
        School school1 = new School("H1", 2);
        School school2 = new School("H2", 2);

        /// We set the preferences for every student
        /// because each student ranks some (acceptable) schools in strict order !

        student0.addPreferences(Stream.of(school0, school1, school2).collect(Collectors.toList()));
        // Student0.seePreferences();
        student1.addPreferences(Stream.of(school0, school1, school2).collect(Collectors.toList()));
        // Student1.seePreferences();
        student2.addPreferences(Stream.of(school0, school1).collect(Collectors.toList()));
        // Student2.seePreferences();
        student3.addPreferences(Stream.of(school0, school2).collect(Collectors.toList()));
        // Student3.seePreferences();

        /// We set the preferences for every school
        /// because each school ranks its applicants in some order !

        school0.addPreferences(Stream.of(student3, student0, student1, student2).collect(Collectors.toList()));
        // School0.setPreferencesOfSchool();
        school1.addPreferences(Stream.of(student0, student2, student1).collect(Collectors.toList()));
        // School1.setPreferencesOfSchool();
        school2.addPreferences(Stream.of(student0, student1, student3).collect(Collectors.toList()));
        // School1.setPreferencesOfSchool();

        Problem problem = new Problem();
        problem.addStudent(student0);
        problem.addStudent(student1);
        problem.addStudent(student2);
        problem.addStudent(student3);
        problem.addSchool(school0);
        problem.addSchool(school1);
        problem.addSchool(school2);
        problem.seeStudents();

        /////////using Java Stream API to write queries that display the students who find accetable a given list of schools.

        List<Student> studentList = new ArrayList<>();
        studentList.addAll(Arrays.asList(student0, student1));

        Map<Student, List<School>> firstMap = new HashMap<>();
        firstMap.put(student0, Arrays.asList(school0, school1));
        firstMap.put(student1, Arrays.asList(school2));

        List<School> target = Arrays.asList(school0, school1);

        List<Student> result = studentList.stream().filter(std -> firstMap.get(std).containsAll(target)).collect(Collectors.toList());
        System.out.println("for the schools which you entered, the students who are interested are: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getName());
        }


        ///// using Java Stream API to write queries that display the schools who find accetable a given list of students.
        List<School> schoolList = new ArrayList<>();
        schoolList.addAll(Arrays.asList(school0, school1));

        Map<School, List<Student>> secondMap = new HashMap<>();
        secondMap.put(school0, Arrays.asList(student3, student0, student1));
        secondMap.put(school1, Arrays.asList(student0, student2, student1));
        List<Student> target2 = Arrays.asList(student0, student1);
        List<School> result2 = schoolList.stream().filter(std -> secondMap.get(std).containsAll(target2)).collect(Collectors.toList());
        System.out.println("for the students which you entered, the schools who are interested are: ");
        for (int i = 0; i < result2.size(); i++) {
            System.out.println(result2.get(i).getName());
        }

        //// using a third-party library to generate fake names for students and schools.

        Student student5 = new Student(new Faker());
        School school5 = new School(new Faker());


        //// solve the association problem
        Solution solution = new Solution();
        System.out.println(solution.displaySolution(problem));

    }

}
