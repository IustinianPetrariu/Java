import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("all good!");

        Student student0 = new Student("S0");
        Student student1 = new Student("S1");
        Student student2 = new Student("S2");
        Student student3 = new Student("S3");
        Student student4 = new Student("S4");

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

        List<Student> list = new LinkedList<>();
        list.add(student0);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        /// sort the students using a comparator , we choose to sort by names;
        Comparator<Student> byName = (e1, e2) -> e1.getName().compareTo(e2.getName());
        List<Student> sortedList = list.stream().sorted(byName).collect(Collectors.toList());
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i).getName());
        }

        /// Use TreeSet to create a set of school and also provide a comparator
        /// to make sure that School objects are comparable

        Set<School> listOfSchool = new TreeSet<>(new Comparator<School>() {
            @Override
            public int compare(School school1, School school2) {
                return school1.getName().compareTo(school2.getName());
            }
        });
        listOfSchool.add(school0);
        listOfSchool.add(school1);
        listOfSchool.add(school2);
        for (School school : listOfSchool)
            System.out.println(school.getName());


        //// Create two maps with different implementation !\

        Map<Student, List<School>> firstMap = new HashMap<>();
        firstMap.put(student0, Arrays.asList(school0, school1, school2));
        firstMap.put(student1, Arrays.asList(school0, school1, school2));
        System.out.println("First mapping!");
        for (Student student : firstMap.keySet()) {
            System.out.print(student.getName());
            System.out.print(" ( ");
            for (int i = 0; i < firstMap.get(student).size(); i++) {

                System.out.print(firstMap.get(student).get(i).getName() + ' ');
            }
            System.out.print(" ) ");
            System.out.println(" ");
        }


        Map<School, List<Student>> secondMap = new TreeMap<>(new Comparator<School>() {
            @Override
            public int compare(School school1, School school2) {
                return school1.getName().compareTo(school2.getName());
            }
        });
        secondMap.put(school0, Arrays.asList(student3, student0, student1, student2));
        secondMap.put(school1, Arrays.asList(student0, student2, student1));

        System.out.println("Second mapping!");
        for (School school : secondMap.keySet()) {
            System.out.print(school.getName());
            System.out.print(" ( ");
            for (int i = 0; i < secondMap.get(school).size(); i++) {

                System.out.print(secondMap.get(school).get(i).getName() + ' ');
            }
            System.out.print(" ) ");
            System.out.println(" ");
        }


    }
}
