import java.util.*;

public class Problem {
    protected List<Student> students = new ArrayList<>();
    protected List<School> schools = new ArrayList<>();
    protected Map<String, String> match = new HashMap<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addSchool(School school) {
        schools.add(school);
    }

    public void seeStudents() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScor() < o2.getScor())
                    return 1;
                else return -1;
            }
        });
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getName());
        }
    }

    public void seeSchools() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getName());
        }
    }
}
