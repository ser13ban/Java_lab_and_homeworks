package com.company;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakerIDN;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Faker faker = new Faker();

        var students = IntStream.rangeClosed(0,3)
                .mapToObj(i -> new Student("S" + i + "\t" + faker.name() ))
                .toArray(Student[]::new);

        var schools = IntStream.rangeClosed(0,2)
                .mapToObj(i-> new School("H" + i + "\t" + faker.name() + "School"))
                .toArray(School[]::new);

        List<Student> studentList = new ArrayList<Student>();
        for (Student s: students
        ) {
            studentList.add(s);
        }

        TreeSet<School> schoolTreeSet = new TreeSet<School>();
        for (School s: schools
        ) {
            schoolTreeSet.add(s);
        }


        Collections.sort(studentList);

        Map<Student, List<School>> studentPreference = new HashMap<>();
        studentPreference.put(students[0],Arrays.asList(schools[0],schools[1],schools[2]));
        studentPreference.put(students[1],Arrays.asList(schools[0],schools[1],schools[2]));
        studentPreference.put(students[2],Arrays.asList(schools[0],schools[1]));
        studentPreference.put(students[3],Arrays.asList(schools[0],schools[2]));

        Map<School, List<Student>> schoolPreference = new HashMap<>();
        schoolPreference.put(schools[0],Arrays.asList(students[3],students[0],students[1],students[2]));
        schoolPreference.put(schools[1],Arrays.asList(students[0],students[2],students[1]));
        schoolPreference.put(schools[2],Arrays.asList(students[0],students[1],students[3]));

        Problem p = new Problem(studentList, schoolTreeSet,studentPreference, schoolPreference);
        Solution s = new Solution(p);

        //s.printSchoolsThatPrefereStudent(students[3]);
        p.print();


    }
}
