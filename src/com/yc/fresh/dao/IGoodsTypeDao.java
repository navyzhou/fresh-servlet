package com.yc.fresh.dao;

import java.util.List;

import com.yc.fresh.entity.GoodsType;

public interface IGoodsTypeDao {
	public List<GoodsType> findAll();
	
	public int update(GoodsType type);
	
	public int add(GoodsType type);
	
	public int delete(String tno);
}
