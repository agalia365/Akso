package com.akso.java8.methodRef;

public class Student {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static  int compareStudentByScore(Student s1, Student s2) {
        return s1.getScore() - s2.getScore();
    }

    public static int compareStudentByName(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }

    public int compareByScore(Student student) {
        return student.getScore() - this.getScore();
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
