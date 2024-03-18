package com.sms.app.controller;

import com.sms.app.dto.SchoolNameAndStudentNameResponseDTO;
import com.sms.app.model.School;
import com.sms.app.repository.SchoolRepository;
import com.sms.app.service.SchoolAndStudentDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schoolAPI")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    SchoolAndStudentDetailServiceImpl schoolAndStudentDetailService;

    @PostMapping("/saveSchoolInfo")
    public ResponseEntity<?> createStudent(@RequestBody School schoolRequestBody) {
        try {
            School saveSchoolInfo = new School();
            saveSchoolInfo.setName(schoolRequestBody.getName());
            saveSchoolInfo.setAddress(schoolRequestBody.getAddress());
            saveSchoolInfo.setActive(schoolRequestBody.isActive());
            saveSchoolInfo.setContact(schoolRequestBody.getContact());

            School schoolToSaveInDb = schoolRepository.save(saveSchoolInfo);
            return new ResponseEntity<>("School Info is Saved", HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("schoolInfo")
    public ResponseEntity<?> getSchoolInformations() {
        try {
            List<School> schools = schoolRepository.findAll();
            if (schools.isEmpty()) {
                return new ResponseEntity<>("No School Found", HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(schools, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @PutMapping("updateSchool/{id}")
    public ResponseEntity<?> updateSchool(@PathVariable("id") long id,
                                          @RequestParam String name) {
        try {
            Optional<School> school = schoolRepository.findById(id);

            if (school.isPresent()) {
                School st = school.get();
                st.setName(name);
                schoolRepository.save(st);
                return new ResponseEntity<>("Update Successful", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Unable to find id", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

        }
    }

    @DeleteMapping("deleteSchool/{id}")
    public ResponseEntity<?> updateSchool(@PathVariable("id") long id) {
        try {
            Optional<School> schoolObjById = schoolRepository.findById(id);
            if (schoolObjById.isPresent()) {
                schoolRepository.deleteById(id);
                return new ResponseEntity<>("Delete Success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Unable to find id", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("getSchoolAndStudent")
    public ResponseEntity<List<SchoolNameAndStudentNameResponseDTO>> retrieveSchoolNameAndStudent(){
        List<SchoolNameAndStudentNameResponseDTO> returningList = schoolAndStudentDetailService.findSchoolNameAndStudent();
        return new ResponseEntity<>(returningList,HttpStatus.OK);
    }

    @GetMapping("/schoolByName/{name}")
    public ResponseEntity<?>getSchoolNameContains(@PathVariable("name") String name) {
        try {
            System.out.println("name"+name);
            List<School> _school = schoolRepository.findByName(name);
            if(_school.size()>0){
                return new ResponseEntity<>(_school, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(_school, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
