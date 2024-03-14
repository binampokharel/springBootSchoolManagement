package com.sms.app.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="contact")
    private String contact;
    @Column(name="active")
    private boolean active;

    public School() {
    }

    public School(long id, String name, String address, String contact, boolean active) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.active = active;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School school)) return false;
        return id == school.id && active == school.active && Objects.equals(name, school.name) && Objects.equals(address, school.address) && Objects.equals(contact, school.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, contact, active);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", active=" + active +
                '}';
    }
}
