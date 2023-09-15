package com.kh.spring12file.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring12file.Dto.AttachDto;


@Component
public class AttachMapper implements RowMapper<AttachDto>{
	@Override
	public AttachDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		AttachDto attachDto = new AttachDto();
		attachDto.setAttachNo(rs.getInt("attach_no"));
		attachDto.setAttachName(rs.getString("attach_name"));
		attachDto.setAttachSize(rs.getLong("attach_size"));
		attachDto.setAttachType(rs.getString("attach_type"));
		attachDto.setAttachTime(rs.getDate("attach_time"));
		return attachDto;
	}
}