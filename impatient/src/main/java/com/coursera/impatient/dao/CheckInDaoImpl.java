package com.coursera.impatient.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.coursera.impatient.model.CheckIn;

public class CheckInDaoImpl implements CheckInDao {

	private JdbcTemplate jdbcTemplate = null;
	
	public CheckInDaoImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertCheckIn(CheckIn checkIn) {
		String sql = "insert into checkin (iduser, date_checkin, hour) VALUES(?,?,?)";

		Object[] args = new Object[] {checkIn.getUserId(), checkIn.getDate(), checkIn.getHour()};

        int out = jdbcTemplate.update(sql, args);
         
        if(out !=0){
            System.out.println("CheckIn insert with id= "+ checkIn.toString());
        }else{
        	System.out.println("CheckIn not insert with id= "+ checkIn.toString());
        }
	}

	@Override
	public void updateCheckIn(CheckIn checkIn) {
		String sql = "update checkin set date_checkin = ?, hour = ? where idcheckin = ? and iduser = ?";

		Object[] args = new Object[] {checkIn.getDate(), checkIn.getHour(), checkIn.getCheckInId(), checkIn.getUserId()};

        int out = jdbcTemplate.update(sql, args);
         
        if(out !=0){
            System.out.println("CheckIn insert with id= "+ checkIn.toString());
        }else{
        	System.out.println("CheckIn not insert with id= "+ checkIn.toString());
        }

	}

	@Override
	public CheckIn getCheckInById(String userId) {
		String sql = "select checkin.idcheckin, checkin.iduser, concat(user.first_name,' ', user.last_name) as fullName, checkin.date_checkin, checkin.hour from checkin, user where checkin.iduser = user.iduser and checkin.iduser ='" + userId + "'";
		CheckIn checkIn = null;
		checkIn = jdbcTemplate.query(sql, new ResultSetExtractor<CheckIn>() {

			@Override
			public CheckIn extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					CheckIn checkIn = new CheckIn();
					checkIn.setCheckInId(rs.getInt("idcheckin"));
					checkIn.setUserId(rs.getString("iduser"));
					checkIn.setFullName(rs.getString("fullName"));
	                checkIn.setDate(rs.getDate("date_checkin").toString());
	                checkIn.setHour(rs.getString("hour"));
	                return checkIn;
	            }				
				return null;
			}
		});
		return checkIn;
	}

	@Override
	public void deleteCheckInById(String userId) {
		// TODO Auto-generated method stub

	}

}
