package com.coursera.impatient.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.coursera.impatient.model.User;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate = null;
	
	public UserDaoImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertUser(User user) {
		String sql = "insert into user (iduser, first_name, last_name, birth_date, email, phone) values (?,?,?,?,?,?)";

		Object[] args = new Object[] { user.getUserId(), user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getEmail(), user.getPhone()};

        int out = jdbcTemplate.update(sql, args);
         
        if(out !=0){
            System.out.println("User insert with id= "+ user.toString());
        }else{
        	System.out.println("User not insert with id= "+ user.toString());
        }

	}

	@Override
	public void updateUser(User user) {
		String sql = "update user set first_name = ?, last_name = ?, birth_date = ?, email = ?, phone = ? where iduser = ?";

		Object[] args = new Object[] {user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getEmail(), user.getPhone(), user.getUserId()};

        int out = jdbcTemplate.update(sql, args);
         
        if(out !=0){
            System.out.println("User updated with id= "+ user.toString());
        }else{
        	System.out.println("User not updated with id= "+ user.toString());
        }

	}

	@Override
	public User getUserById(String userId) {
		String sql = "select * from user where iduser='" + userId + "'";
		User user = null;
		user = jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
	                User user = new User();
	                user.setUserId(rs.getString("iduser"));
	                user.setFirstName(rs.getString("first_name"));
	                user.setLastName(rs.getString("last_name"));
	                user.setDateOfBirth(rs.getDate("birth_date").toString());
	                user.setEmail(rs.getString("email"));
	                user.setPhone(rs.getString("phone"));
	                return user;
	            }				
				return null;
			}
		});
		return user;
	}

	@Override
	public void deleteUserById(String userId) {
		// TODO Auto-generated method stub

	}

}
