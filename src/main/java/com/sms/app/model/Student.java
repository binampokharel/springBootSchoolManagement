package com.sms.app.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contact;

    @Column(name = "active")
    private boolean active;

    @Column(name ="total_marks")
    private double totalMarks;

    @OneToOne
    @JoinColumn(name = "school_id") // This column will hold the foreign key to the School entity
    private School school;

    public Student(){

    }
    public Student( String name, String address, String contact, boolean active, double totalMarks, School school) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.active = active;
        this.totalMarks = totalMarks;
        this.school = school;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id && active == student.active && Double.compare(totalMarks, student.totalMarks) == 0 && Objects.equals(name, student.name) && Objects.equals(address, student.address) && Objects.equals(contact, student.contact) && Objects.equals(school, student.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, contact, active, totalMarks, school);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", active=" + active +
                ", totalMarks=" + totalMarks +
                ", school=" + school +
                '}';
    }
}
