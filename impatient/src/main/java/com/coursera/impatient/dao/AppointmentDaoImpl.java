package com.coursera.impatient.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.coursera.impatient.model.UserDate;

public class AppointmentDaoImpl implements AppointmentDao {

	private JdbcTemplate jdbcTemplate = null;
	
	public AppointmentDaoImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void insertAppointment(UserDate userDate) {
		String sql = "insert into appointment (iduser, date_appointment, hour, remember) VALUES(?,?,?,?)";
		
		int remember = 0;
		if(userDate.isRemember()){
			remember = 1;
		}
		
		Object[] args = new Object[] {userDate.getUserId(), userDate.getDate(), userDate.getHour(), remember};

        int out = jdbcTemplate.update(sql, args);
         
        if(out !=0){
            System.out.println("UserDate insert with id= "+ userDate.getUserId());
        }else{
        	System.out.println("UserDate not insert with id= "+ userDate.getUserId());
        }

	}

	@Override
	public void updateAppointment(UserDate userDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDate getAppointmentById(String userId) {
		String sql = "select appointment.remember, appointment.date_appointment, appointment.hour, concat(user.first_name, ' ', user.last_name) as fullName from appointment, user where appointment.iduser = user.iduser and appointment.iduser ='" + userId + "'";
		UserDate userDate = null;
		userDate = jdbcTemplate.query(sql, new ResultSetExtractor<UserDate>() {

			@Override
			public UserDate extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					UserDate userDate = new UserDate();
					boolean remember = false;
					if(rs.getInt("remember") == 1){
						remember = true;
					}
					userDate.setRemember(remember);
					userDate.setDate(rs.getDate("date_appointment").toString());
					userDate.setHour(rs.getString("hour"));
					userDate.setDoctorName(rs.getString("fullName"));
	                return userDate;
	            }				
				return null;
			}
		});
		return userDate;
	}

	@Override
	public void deleteAppointmentById(String userId) {
		// TODO Auto-generated method stub

	}

}
