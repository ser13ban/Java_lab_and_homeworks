package com.company;

import java.util.*;

public class Problem {
    private List<Student> studentList;
    private TreeSet<School> schoolTreeSet;

    private Map<Student, List<School>> studentPreference;
    private Map<School, List<Student>> schoolPreference;

    public Problem(){
        studentList = new ArrayList<Student>();
        schoolTreeSet = new TreeSet<School>();
        studentPreference = new HashMap<>();
        schoolPreference = new HashMap<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public TreeSet<School> getSchoolTreeSet() {
        return schoolTreeSet;
    }

    public void setSchoolTreeSet(TreeSet<School> schoolTreeSet) {
        this.schoolTreeSet = schoolTreeSet;
    }

    public Problem(List<Student> studentList, TreeSet<School> schoolTreeSet, Map<Student, List<School>> studentPreference, Map<School, List<Student>> schoolPreference) {
        this.studentList = studentList;
        this.schoolTreeSet = schoolTreeSet;
        this.studentPreference = studentPreference;
        this.schoolPreference = schoolPreference;
    }

    public Map<Student, List<School>> getStudentPreference() {
        return studentPreference;
    }



    public void setStudentPreference(Map<Student, List<School>> studentPreference) {
        this.studentPreference = studentPreference;
    }

    public Map<School, List<Student>> getSchoolPreference() {
        return schoolPreference;
    }

    public void setSchoolPreference(Map<School, List<Student>> schoolPreference) {
        this.schoolPreference = schoolPreference;
    }

    public void print(){
        System.out.println("\nStudents preferences");
        for (Student s: studentPreference.keySet()
        ) {
            System.out.println("\n" + s.getName()) ;
            studentPreference.get(s).forEach(listItem -> System.out.print(listItem.getName() + "\t" ));
        }
        System.out.println("\n\nSchools preferences");
        for (School s: schoolPreference.keySet()
        ) {
            System.out.println("\n" + s.getName());
            schoolPreference.get(s).forEach(listItem -> System.out.print(listItem.getName() +  "\t" ));
        }
    }
}
