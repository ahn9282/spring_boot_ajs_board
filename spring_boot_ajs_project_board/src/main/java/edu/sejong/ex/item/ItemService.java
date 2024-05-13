package edu.sejong.ex.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	
	@Autowired
	ItemMapper itemMapper;
	
	public void addItem() {
		
		itemMapper.addtoItem();
	}
	
	public List<ItemVO> select(){
		return itemMapper.select();
	}

}
