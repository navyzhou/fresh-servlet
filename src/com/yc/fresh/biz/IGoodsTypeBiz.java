package com.yc.fresh.biz;

import java.util.List;

import com.yc.fresh.entity.GoodsType;

public interface IGoodsTypeBiz {
	public List<GoodsType> findAll();
	
	public int update(GoodsType type);
	
	public int add(GoodsType type);
	
	public int delete(String tno);
}
