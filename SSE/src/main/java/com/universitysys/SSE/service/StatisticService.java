package com.universitysys.SSE.service;

import com.universitysys.SSE.model.Account;
import com.universitysys.SSE.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.universitysys.SSE.repository.StatisticRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class StatisticService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Account getOne(int id){
        String sql ="select * from account where id=?;";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Account>(Account.class));
    }
    public List<Account> showInfo(){
        String sql1 = "select * from account";
        List<Account> users = jdbcTemplate.query(sql1,new UserMapper());
        return users;
        }



    class UserMapper implements RowMapper<Account> {
        public Account  mapRow(ResultSet rs, int arg1) throws SQLException {
            Account user = new Account();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }





}
