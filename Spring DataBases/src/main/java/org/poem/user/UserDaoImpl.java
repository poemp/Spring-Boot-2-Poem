package org.poem.user;

import org.poem.api.UserDao;
import org.poem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int count() {
        int count = this.jdbcTemplate.queryForObject("select count(1) from user ", Integer.class);
        return count;
    }

    @Override
    public int countById(String departmentId) {
        int rowCount = this.jdbcTemplate.queryForObject("select count(1) from user where department_id = ?", Integer.class, departmentId);
        return rowCount;
    }

    @Override
    public User getUserById(int userId) {
        String sql = "select * from user  where id = ?";
        User user = this.jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                u.setDepartmentId(resultSet.getInt("department_id"));
                return u;
            }
        }, userId);
        return user;
    }

    @Override
    public void update(User user) {
        String  sql = "update user set name  = ? and department_id = ? where id = ?";
        this.jdbcTemplate.update(sql,user.getName(), user.getDepartmentId(), user.getId());
    }

    public int insertUser(final  User user){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into user (name, department_id) values (? , ? )";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"id"});
                preparedStatement.setString(1, user.getName());
                preparedStatement.setInt(2, user.getDepartmentId());
                return preparedStatement;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();
    }

}
