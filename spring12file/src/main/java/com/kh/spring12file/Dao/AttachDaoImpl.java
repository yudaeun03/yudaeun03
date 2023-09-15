package com.kh.spring12file.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring12file.Dto.AttachDto;
import com.kh.spring12file.Mapper.AttachMapper;

@Repository
public class AttachDaoImpl implements AttachDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private AttachMapper attachMapper;
	
	@Override
	public int sequence() {
		String sql = "select attach_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	@Override
	public void insert(AttachDto attachDto) {
		String sql = "insert into attach("
							+ "attach_no, attach_name, "
							+ "attach_size, attach_type"
						+ ") "
						+ "values(?, ?, ?, ?)";
		Object[] data = {
			attachDto.getAttachNo(), attachDto.getAttachName(),
			attachDto.getAttachSize(), attachDto.getAttachType()
		};
		jdbcTemplate.update(sql, data);
	}

	@Override
	public AttachDto selectOne(int attachNo) {
		String sql = "select * from attach where attach_no = ?";
		Object[] data = {attachNo};
		List<AttachDto> list = jdbcTemplate.query(sql, attachMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
}




