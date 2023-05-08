package com.craftsman.catalogsvc.repository.handlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(String.class)
public class StringTrimTypeHandler extends BaseTypeHandler<String> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, trim(parameter));
	}

	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return trim(rs.getString(columnName));
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return trim(rs.getString(columnIndex));
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return trim(cs.getString(columnIndex));
	}

	private String trim(String str) {
		return str != null ? str.trim() : str;
	}

}