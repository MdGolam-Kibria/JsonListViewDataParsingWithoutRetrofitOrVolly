package com.example.jsonlistviewdataparsingtry;

public class DemoStudent {
    String name;
    String dept;
    String year;
    String university;

    public DemoStudent() {
    }

    public DemoStudent(String name, String dept, String year, String university) {
        this.name = name;
        this.dept = dept;
        this.year = year;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
