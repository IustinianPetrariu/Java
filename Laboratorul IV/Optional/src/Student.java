import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private double scor;
    private String name;
    protected List<School> preferencesOfStudent = new ArrayList<>();

    public Student(String name, double scor) {
        this.name = name;
        this.scor=scor;
    }
    public Student(Faker fake)
    {
        this.name=fake.name().firstName();
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
        for(int i = 0 ; i < preferencesOfStudent.size(); i++)
            System.out.println(preferencesOfStudent.get(i).getName());
    }

    public double getScor() {
        return scor;
    }

    public void setScor(double scor) {
        this.scor = scor;
    }
}
