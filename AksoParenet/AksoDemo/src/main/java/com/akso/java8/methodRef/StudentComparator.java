package com.akso.java8.methodRef;

public class StudentComparator {

    public  int compareStudentByScore(Student s1, Student s2) {
        return s1.getScore() - s2.getScore();
    }

    public int compareStudentByName(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
