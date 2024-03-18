package com.sms.app.dto;

public class SchoolNameAndStudentNameResponseDTO {
    private String schoolName;
    private String studentName;

    private String address;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SchoolNameAndStudentNameResponseDTO() {
    }
}
