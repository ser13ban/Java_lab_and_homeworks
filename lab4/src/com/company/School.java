package com.company;

import java.util.ArrayList;
import java.util.List;

public class School implements Comparable<School> {
    private String name;
    private List<Student> studentPreferences;

    public School(String name) {
        this.name = name;

        studentPreferences = new ArrayList<Student>();
    }

    @Override
    public int compareTo(School o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentPreferences() {
        return studentPreferences;
    }

    public void setStudentPreferences(List<Student> studentPreferences) {
        this.studentPreferences = studentPreferences;
    }
}
