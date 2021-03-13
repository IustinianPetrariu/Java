import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private int capacity;

    private List<Student> preferencesOfSchool = new ArrayList<>() ;
    public School(String name)
    {
        this.name=name;
    }
    public School(Faker fake)
    {
        this.name=fake.name().firstName();
    }
    public School(String name, int capacity)
    {
        this.name=name;
        this.capacity=capacity;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void addPreferences(List<Student> names)
    {
        this.preferencesOfSchool=names;
    }
    public void setPreferencesOfSchool()
    {
        for(int i = 0 ; i < preferencesOfSchool.size(); i++)
            System.out.println(preferencesOfSchool.get(i).getName());
    }





}
