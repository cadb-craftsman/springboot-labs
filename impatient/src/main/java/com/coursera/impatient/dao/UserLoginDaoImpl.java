package com.coursera.impatient.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.coursera.impatient.model.UserLogin;

public class UserLoginDaoImpl implements UserLoginDao {

	private JdbcTemplate jdbcTemplate = null;
	
	public UserLoginDaoImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void insertUserLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserLogin getUserLoginById(String username, String password) {
		String sql = "select * from login where username='" + username + "'" + "and password='"+ password +"'" ;
		UserLogin userLogin = null;
		userLogin = jdbcTemplate.query(sql, new ResultSetExtractor<UserLogin>() {

			@Override
			public UserLogin extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
	                UserLogin userLogin = new UserLogin();
	                userLogin.setUserId(rs.getString("iduser"));
	                userLogin.setUserRole(rs.getInt(rs.getInt("idrol")));
	                userLogin.setUsername(rs.getString("username"));
	                userLogin.setPassword(rs.getString("password"));
	                return userLogin;
	            }				
				return null;
			}
		});
		return userLogin;
	}

	@Override
	public void deleteUserLoginById(String username) {
		// TODO Auto-generated method stub

	}

}
