package com.lazarevic.boban.koukio.student;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {

  private int id;
  private String name;
  private double cgpa;

  public Student(int id, String name, double cgpa) {
    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getCgpa() {
    return cgpa;
  }

  public void setCgpa(double cgpa) {
    this.cgpa = cgpa;
  }

  @Override
  public int compareTo(Student student) {
    return Comparator.comparing(Student::getCgpa, Comparator.reverseOrder()).thenComparing(Student::getName).thenComparing(Student::getId).compare(this, student);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return id == student.id && Double.compare(student.cgpa, cgpa) == 0 && Objects.equals(name, student.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, cgpa);
  }

  @Override
  public String toString() {
    return "Student{" +
            "name='" + name + '\'' +
            '}';
  }
}
