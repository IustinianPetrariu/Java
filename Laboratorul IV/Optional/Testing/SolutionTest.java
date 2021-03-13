import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void displaySolution() {

        Map<String, String> check = new HashMap<>();
        ///                                                    First --> prepare the problem
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
        student1.addPreferences(Stream.of(school0, school1, school2).collect(Collectors.toList()));
        student2.addPreferences(Stream.of(school0, school1).collect(Collectors.toList()));
        student3.addPreferences(Stream.of(school0, school2).collect(Collectors.toList()));

        /// We set the preferences for every school
        /// because each school ranks its applicants in some order !

        school0.addPreferences(Stream.of(student3, student0, student1, student2).collect(Collectors.toList()));
        school1.addPreferences(Stream.of(student0, student2, student1).collect(Collectors.toList()));
        school2.addPreferences(Stream.of(student0, student1, student3).collect(Collectors.toList()));


        Problem problem = new Problem();
        problem.addStudent(student0);
        problem.addStudent(student1);
        problem.addStudent(student2);
        problem.addStudent(student3);
        problem.addSchool(school0);
        problem.addSchool(school1);
        problem.addSchool(school2);

        Solution solution = new Solution();

        ///resolve the problem and check if the solution is good !
        check.put("S2", "H0");
        check.put("S1", "H1");
        check.put("S0", "H1");
        check.put("S3", "H2");
        //                                                                Second -> Run test !
        //                                  a tricky test, students go to only one school from 3 schools in total
        assertEquals(check, solution.displaySolution(problem));

        ///                                         Prepare the second test !
        Student stud0 = new Student("S0", 9.50);
        Student stud1 = new Student("S1", 8.50);
        Student stud2 = new Student("S2", 9.20);

        School schol0 = new School("H0", 3);
        School schol1 = new School("H1", 1);
        School schol2 = new School("H2", 1);

        stud0.addPreferences(Stream.of(schol0, schol1).collect(Collectors.toList()));
        stud1.addPreferences(Stream.of(schol0, schol1, schol2).collect(Collectors.toList()));
        stud2.addPreferences(Stream.of(schol0, schol1).collect(Collectors.toList()));

        /// We set the preferences for every school
        /// because each school ranks its applicants in some order !

        schol0.addPreferences(Stream.of(stud0, stud2).collect(Collectors.toList()));
        schol1.addPreferences(Stream.of(stud0, stud2, stud1).collect(Collectors.toList()));
        schol2.addPreferences(Stream.of(stud0, stud1, stud2).collect(Collectors.toList()));


        Problem problem2 = new Problem();
        problem2.addStudent(stud0);
        problem2.addStudent(stud1);
        problem2.addStudent(stud2);
        problem2.addSchool(schol0);
        problem2.addSchool(schol1);
        problem2.addSchool(schol2);

        Solution solution2 = new Solution();
        Map<String, String> check2 = new HashMap<>();
        // resolve the problem, this is the expected output!
        check2.put("S2", "H0");
        check2.put("S1", "H0");
        check2.put("S0", "H0");
        assertEquals(check2, solution2.displaySolution(problem2));

    }
}