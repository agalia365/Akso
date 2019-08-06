package com.akso.java8;

public class Student {

    private String name;

    private int score;

    private int age;

    private Status status;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (score != student.score) return false;
        if (age != student.age) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return status == student.status;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + score;
        result = 31 * result + age;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Student() {

    }

    public Student(String name, int score, int age, Status status) {
        this.name = name;
        this.score = score;
        this.age = age;
        this.status = status;
    }

    public Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public static int compareStudentByScore(Student s1, Student s2) {
        return s1.getScore() - s2.getScore();
    }

    public static int compareStudentByName(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }

    public int compareByScore(Student student) {
        return student.getScore() - this.getScore();
    }

    public enum Status {
        BUSY,
        FREE,
        VACATION;
    }
}
