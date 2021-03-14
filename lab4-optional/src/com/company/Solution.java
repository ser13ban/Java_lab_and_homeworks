package com.company;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {
    private List<Student> studentList;
    private TreeSet<School> schoolTreeSet;
    private Map<Student, List<School>> studentPreference;
    private Map<School, List<Student>> schoolPreference;

    public Solution(Problem p){
        this.studentList = p.getStudentList();
        this.schoolTreeSet = p.getSchoolTreeSet();
        this.schoolPreference = p.getSchoolPreference();
        this.studentPreference = p.getStudentPreference();
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

    public void printStudentsForListOfSchools(List<School> schoolList){
        List<Student> results = studentList.stream()
                .filter(std -> studentPreference.get(std).contains(schoolList))
                .collect(Collectors.toList());

        for (Student s: results
             ) {
            System.out.println(s.getName() + "\t");
        }
    }

    public void printSchoolsThatPrefereStudent(Student s){
        List<School> result = schoolTreeSet.stream()
                .filter(sch -> schoolPreference.get(sch).indexOf(s) == 0)
                .collect(Collectors.toList());
        for (School school: result
             ) {
            System.out.println(school.getName());
        }
    }

}
