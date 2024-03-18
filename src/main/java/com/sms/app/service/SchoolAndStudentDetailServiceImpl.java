package com.sms.app.service;

import com.sms.app.dto.SchoolNameAndStudentNameResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolAndStudentDetailServiceImpl implements SchoolAndStudentDetailService {

    @Autowired
    private NamedParameterJdbcTemplate resultProvider;
    @Override
    public List<SchoolNameAndStudentNameResponseDTO> findSchoolNameAndStudent() {
        String sql = "SELECT sc.name AS schoolName, sc.address AS address," +
                "st.name AS studentName " +
                "FROM students st " +
                "JOIN school sc ON st.school_id = sc.id";

        return this.resultProvider.query(sql,
                new BeanPropertyRowMapper<>(SchoolNameAndStudentNameResponseDTO.class));


//        return resultProvider.queryForList(sql,new MapSqlParameterSource()).stream()
//                .map(row->{
//                    SchoolNameAndStudentNameResponseDTO dto = new SchoolNameAndStudentNameResponseDTO();
//                    dto.setSchoolName((String) row.get("school"));
//                    dto.setStudentName((String) row.get("student"));
//                    return dto;
//                }).collect(Collectors.toList());

//        return resultProvider.query(sql,new MapSqlParameterSource(),(resultset,i)->{
//            SchoolNameAndStudentNameResponseDTO dto = new SchoolNameAndStudentNameResponseDTO();
//            dto.setSchoolName(resultset.getString("school"));
//            dto.setSchoolName(resultset.getString("student"));
//            return dto;
//        });

    }


}
