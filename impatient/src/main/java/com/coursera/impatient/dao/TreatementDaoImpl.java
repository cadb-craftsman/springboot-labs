package com.coursera.impatient.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.coursera.impatient.model.Treatment;

public class TreatementDaoImpl implements TreatementDao {

	private JdbcTemplate jdbcTemplate = null;
	
	public TreatementDaoImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void insertTreatment(Treatment treatment) {
		String sql = "insert into treatment (iduser, medicine, description) values (?,?,?)";

		Object[] args = new Object[] {treatment.getUserId(), treatment.getDrugName(), treatment.getDescription()};

        int out = jdbcTemplate.update(sql, args);
         
        if(out !=0){
            System.out.println("Treatment insert with id= "+ treatment.toString());
        }else{
        	System.out.println("Treatment not insert with id= "+ treatment.toString());
        }
	}

	@Override
	public void updateTreatment(Treatment treatment) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Treatment> getTreatmentById(String userId) {
		String sql = "select * from treatment where iduser ='" + userId + "'";
		List<Treatment> tList = new ArrayList<Treatment>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> row : rows) {
			Treatment t = new Treatment();
			t.setUserId(String.valueOf(row.get("iduser")));
			t.setDrugName(String.valueOf(row.get("medicine")));
			t.setDescription(String.valueOf(row.get("description")));
			tList.add(t);
		}

		return tList;
	}

	@Override
	public void deleteTreatmentById(String userId) {
		// TODO Auto-generated method stub

	}

}
