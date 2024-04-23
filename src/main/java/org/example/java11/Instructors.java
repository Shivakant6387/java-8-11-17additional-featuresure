package org.example.java11;

import java.util.Arrays;
import java.util.List;

public class Instructors {
    private String name;
    private int yearsOfExperience;
    private String developer;
    private String gender;
    private boolean test;
    private List<String> list;

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public <T> Instructors(String name, int yearsOfExperience, String softwareDeveloper, String m, boolean test, List<T> list) {
        this.name=name;
        this.yearsOfExperience=yearsOfExperience;
        this.developer=softwareDeveloper;
        this.gender=m;
        this.test=test;
        this.list= (List<String>) list;
    }


    public static List<Instructors> getAll() {
        Instructors instructors = new Instructors("Mike", 10, "Software developer", "M", true, Arrays.asList("Java Programmimg", "C++ Programming", "Python Programming"));
        Instructors instructors2 = new Instructors("Mike", 11, "Software developer", "M", true, Arrays.asList("Java Programmimg", "C++ Programming", "Python Programming"));
        Instructors instructors3 = new Instructors("Mike", 12, "Software developer", "M", true, Arrays.asList("Java Programmimg", "C++ Programming", "Python Programming"));
        Instructors instructors4 = new Instructors("Mike", 13, "Software developer", "M", true, Arrays.asList("Java Programmimg", "C++ Programming", "Python Programming"));
        Instructors instructors5 = new Instructors("Mike", 14, "Software developer", "M", true, Arrays.asList("Java Programmimg", "C++ Programming", "Python Programming"));
        List<Instructors> list = Arrays.asList(instructors,instructors2,instructors3,instructors4,instructors5);
        return list;
    }
}
