package com.sms.app.service;

import com.sms.app.dto.SchoolNameAndStudentNameResponseDTO;

import java.util.List;

public interface SchoolAndStudentDetailService {
    List<SchoolNameAndStudentNameResponseDTO> findSchoolNameAndStudent();

}
