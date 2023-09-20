package com.kh.springhome.mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springhome.dto.CertDto;

@Component
public class CertMapper implements RowMapper <CertDto> {

	@Override
	public CertDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CertDto certDto = new CertDto();
		certDto.setCertEmail(rs.getString("cert_email"));
		certDto.setCertNumber(rs.getString("cert_number"));
		certDto.setCertTime(rs.getDate("cert_time"));
		return null;
	}
	
}
