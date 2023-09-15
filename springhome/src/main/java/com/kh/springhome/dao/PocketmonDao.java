package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.AttachDto;
import com.kh.springhome.dto.PocketmonDto;

public interface PocketmonDao {
	int sequence();
	void insert(PocketmonDto pocketmonDto);
	PocketmonDto selectOne(int no);
	List<PocketmonDto> selectList();
	boolean delete(int no);
	boolean update(PocketmonDto pocketmonDto);
	
	void connect(int pocketmonNo, int attachNo);
	AttachDto findImage(int pocketmonNo);
}