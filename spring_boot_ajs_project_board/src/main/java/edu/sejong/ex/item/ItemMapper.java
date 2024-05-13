package edu.sejong.ex.item;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {

	
	void addtoItem();
	

	List<ItemVO> select();
}
