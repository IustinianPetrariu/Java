import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Map<String, String> displaySolution(Problem problem) {
        ///to store the solution, we set up a Map in order to test ( with jUnit) the solution
        Map<String, String> sollution = new HashMap<>();


        ///prepare for the greedy approach, sort based on their exam score
        Collections.sort(problem.students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScor() < o2.getScor())
                    return 1;
                else return -1;
            }
        });

        ///reminder: we have already sorted the students based on their examn points!
        int matched = 0;
        for (int i = 0; i < problem.students.size(); i++) {
            matched = 0;
            ///search for a school, first school from student's preferences
            for (int j = 0; j < problem.students.get(i).preferencesOfStudent.size(); j++) {
                School school = problem.students.get(i).preferencesOfStudent.get(j);

                if (school.getCapacity() > 0) {
                    //save the solution in a MAP!
                    sollution.put(problem.students.get(i).getName(), school.getName());
                    school.setCapacity(school.getCapacity() - 1);
                    matched = 1;
                }
                if (matched == 1) break;
            }

        }
        return sollution;
        ///for every school, search the best students
        /// this mean -> best score - first served


    }

}
