import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<School> preferencesOfStudent = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPreferences(List<School> names) {
        this.preferencesOfStudent = names;
    }

    public void seePreferences() {
        for (int i = 0; i < preferencesOfStudent.size(); i++) {
            System.out.println(preferencesOfStudent.get(i).getName());
        }
    }


}
