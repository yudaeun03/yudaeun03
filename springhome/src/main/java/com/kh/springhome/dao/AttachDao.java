package com.kh.springhome.dao;

import com.kh.springhome.dto.AttachDto;

public interface AttachDao {
	int sequence();
	void insert(AttachDto attachDto);
	boolean delete(int attachNo);
	AttachDto selectOne(int attachNo);
}