package com.example.demo.controller;

import com.example.demo.model.ImspUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName <a href="dcein520@163.com">JDBCController</a>
 * @Description TODO
 * @Author dcein
 * @Date 2020/2/28 11:47
 **/
@RestController
public class JDBCController {

    private final DataSource dataSource;

    private final JdbcTemplate jdbcTemplate;

    public JDBCController(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    //测试jdbc数据院的连通性
    @RequestMapping(value = "/getData", produces = MediaType.APPLICATION_JSON_VALUE)//json自动格式化，忽略浏览器的Content-Type
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SHOW TABLES");
            int i = 1;
            while (rs.next()) {
                i++;
                String string = rs.getString(1); //取出每条结果第一列数据
                System.out.println(string);
                data.put("tableName" + i, string);
            }
        } catch (Exception E) {

        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return data;
    }

    //使用jdbcTemplate进性插入数据
    @PostMapping("/addData")
    public Map<String, Object> addData(@RequestBody ImspUser imspUser) {
        Map<String, Object> data = new HashMap<>();
        jdbcTemplate.execute("INSERT INTO imsp_user(ID, MOBILE_NO,LOGIN_PWD,CREATE_DATE,UPDATE_DATE) VALUES (?,?,?,?,?)", new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setLong(1, imspUser.getId());
                preparedStatement.setString(2,imspUser.getMobileNo());
                preparedStatement.setString(3,imspUser.getPassword());
                preparedStatement.setDate(4, new java.sql.Date(imspUser.getCreateTime().getTime()));
                preparedStatement.setDate(5,new java.sql.Date(imspUser.getUpdateTime().getTime()));
                return preparedStatement.executeUpdate();
            }
        });

        return data;
    }

    public static void main(String[] args) {
        Object obj = new Object();
        int s = obj.hashCode();
        System.out.println(s);
    }
}
