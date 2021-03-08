package com.company;

import java.util.ArrayList;
import java.util.List;

public class Student implements  Comparable<Student>{
    private String name;
    private List<School> _schoolPreferences;

    public Student(String name) {
        this.name = name;

        _schoolPreferences = new ArrayList<School>();
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<School> get_schoolPreferences() {
        return _schoolPreferences;
    }

    public void set_schoolPreferences(List<School> _schoolPreferences) {
        this._schoolPreferences = _schoolPreferences;
    }
}
