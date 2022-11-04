package com.coursera.impatient.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.coursera.impatient.model.Waiting;

public class WaitingDaoImpl implements WaitingDao {

	private JdbcTemplate jdbcTemplate = null;
	
	public WaitingDaoImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void insertWaiting(Waiting waiting) {
		String sql = "insert into waitinglist (idcheckin, idstate) VALUES(?,?)";

		Object[] args = new Object[] {waiting.getIdList(), waiting.getState()};

        int out = jdbcTemplate.update(sql, args);
         
        if(out !=0){
            System.out.println("Waiting insert with id= "+ waiting.toString());
        }else{
        	System.out.println("Waiting not insert with id= "+ waiting.toString());
        }

	}

	@Override
	public void updateWaiting(Waiting waiting) {
		String sql = "update waitinglist set idstate = ? where idwaitinglist = ?";
		int state = 0;
		
		if (waiting.getState().equals("Wait")) {
			state = 0;
		}else if (waiting.getState().equals("Process")) {
			state = 1;
		}else if (waiting.getState().equals("Delay")) {
			state = 2;
		}else if (waiting.getState().equals("Finish")) {
			state = 3;
		}
		
		Object[] args = new Object[] {state, waiting.getIdList()};

        int out = jdbcTemplate.update(sql, args);
         
        if(out !=0){
            System.out.println("Waiting insert with id= "+ waiting.toString());
        }else{
        	System.out.println("Waiting not insert with id= "+ waiting.toString());
        }

	}

	@Override
	public List<Waiting> getWaitingById(String dWaiting) {
		String sql = "select waitinglist.idwaitinglist, checkin.hour, concat(user.first_name, ' ', user.last_name) as fullName, state.name from waitinglist, user, checkin, state where waitinglist.idcheckin = checkin.idcheckin and waitinglist.idstate = state.idstate and checkin.iduser = user.iduser and checkin.date_checkin='"+ dWaiting +"'" ;
		List<Waiting> wList = new ArrayList<Waiting>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> row : rows) {
			Waiting w = new Waiting();
			w.setDate(dWaiting);
			w.setIdList(Integer.parseInt(String.valueOf(row.get("idwaitinglist"))));
			w.setHour(String.valueOf(row.get("hour")));
			w.setFullName(String.valueOf(row.get("fullName")));
			w.setState(String.valueOf(row.get("name")));
			wList.add(w);
		}

		return wList;
	}

	@Override
	public void deleteWaitingById(String userId) {
		// TODO Auto-generated method stub

	}

}
