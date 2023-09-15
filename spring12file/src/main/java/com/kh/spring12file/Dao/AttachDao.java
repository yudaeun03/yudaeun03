package com.kh.spring12file.Dao;

import com.kh.spring12file.Dto.AttachDto;

public interface AttachDao {
	int sequence();
	void insert(AttachDto attachDto);
	AttachDto selectOne(int attachNo);

}
