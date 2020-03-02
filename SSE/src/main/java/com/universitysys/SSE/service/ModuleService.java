package com.universitysys.SSE.service;

import com.universitysys.SSE.model.Account;
import com.universitysys.SSE.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ModuleService {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Module> showInfo(){
        String sql1 = "select * from module";
        List<Module> users = jdbcTemplate.query(sql1,new UserMapper());
        return users;
    }



    class UserMapper implements RowMapper<Module> {
        public Module mapRow(ResultSet rs, int arg1) throws SQLException {
            Module user = new Module();
            user.setName(rs.getString("name"));
            user.setCredit(rs.getString("credit"));
            return user;
        }
    }
}
