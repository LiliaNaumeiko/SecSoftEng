package com.universitysys.SSE.service;

import com.universitysys.SSE.model.Account;
import com.universitysys.SSE.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class RegisterService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void registerStudent(Students students){
        String sql = "insert into students values(?,?, ?,?,?,?)";
        jdbcTemplate.update(sql, new Object[] {students.getId(),students.getName(), students.getSurname(), students.getDate_of_birth(),students.getNationality(),students.getSex()});
    }


    class UserMapper implements RowMapper<Students> {
        public Students  mapRow(ResultSet rs, int arg1) throws SQLException {
            Students user = new Students();
            user.setNationality(rs.getString("nationality"));
            user.setSex(rs.getString("sex"));
            user.setDate_of_birth(rs.getDate("date_of_birthday"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setId(rs.getInt("id"));
            return user;
        }
    }




}