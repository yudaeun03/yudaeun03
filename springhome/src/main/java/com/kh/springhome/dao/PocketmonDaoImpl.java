package com.kh.springhome.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.dto.AttachDto;
import com.kh.springhome.dto.PocketmonDto;
import com.kh.springhome.mapper.AttachMapper;
import com.kh.springhome.mapper.PocketmonMapper;

@Repository
public class PocketmonDaoImpl implements PocketmonDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PocketmonMapper pocketmonMapper;
	
	@Autowired
	private AttachMapper attachMapper;
	
	@Override
	public int sequence() {
		String sql = "select pocketmon_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	@Override
	public void insert(PocketmonDto pocketmonDto) {
		String sql = "insert into pocketmon(no,name,type) values(?, ?, ?)";
		Object[] data = {
				pocketmonDto.getNo(), pocketmonDto.getName(),
				pocketmonDto.getType()
		};
		jdbcTemplate.update(sql, data);
	}
	
	@Override
	public void connect(int pocketmonNo, int attachNo) {
		String sql = "insert into pocketmon_image values(?, ?)";
		Object[] data = {pocketmonNo, attachNo};
		jdbcTemplate.update(sql, data);
	}
	
	@Override
	public AttachDto findImage(int pocketmonNo) {
		String sql = "select * from attach where attach_no = ("
							+ "select attach_no from pocketmon_image "
							+ "where pocketmon_no = ?"
						+ ")";
		Object[] data = {pocketmonNo};
		List<AttachDto> list = jdbcTemplate.query(sql, attachMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public List<PocketmonDto> selectList() {
		String sql = "select p.*, pm.attach_no from pocketmon p "
						+ "left outer join pocketmon_image pm "
						+ "on p.no = pm.pocketmon_no "
						+ "order by p.no asc";
		return jdbcTemplate.query(sql, pocketmonMapper);
	}
	
	@Override
	public PocketmonDto selectOne(int no) {
		String sql = "select p.*, pm.attach_no from "
						+ "pocketmon p "
							+ "left outer join pocketmon_image pm "
							+ "on p.no = pm.pocketmon_no "
						+ "where no = ?";
		Object[] data = {no};
		List<PocketmonDto> list = 
					jdbcTemplate.query(sql, pocketmonMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public boolean delete(int no) {
		String sql = "delete pocketmon where no = ?";
		Object[] data = {no};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	@Override
	public boolean update(PocketmonDto pocketmonDto) {
		String sql = "update pocketmon set name=?, type=? where no=?";
		Object[] data = {
				pocketmonDto.getName(), pocketmonDto.getType(),
				pocketmonDto.getNo()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
}






