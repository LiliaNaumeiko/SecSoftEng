package com.universitysys.SSE.service;

import com.universitysys.SSE.exception.WrongPasswordOrLogin;
import com.universitysys.SSE.model.Students;
import com.universitysys.SSE.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.NamedQuery;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean validateStudent(String userid, String password) {
        String sql = "select * from students where username='" +userid + "' and password='" + password
                + "'";
        List<Students> users = jdbcTemplate.query(sql, new UserMapper());
        if (users.size() > 0 ){
            return true;
        }
        return false;
    }

    class UserMapper implements RowMapper<Students> {
        public Students  mapRow(ResultSet rs, int arg1) throws SQLException {
            Students user = new Students();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }



}