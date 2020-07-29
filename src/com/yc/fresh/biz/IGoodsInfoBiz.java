package com.yc.fresh.biz;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.GoodsInfo;


public interface IGoodsInfoBiz {
	public List<GoodsInfo> findByPage(int page, int rows);
	public Map<String, Object> finds(int page, int rows);
	public Map<String, Object> findByCondition(String tno, String gname, int page, int rows);
	
	public Map<String, Object> findIndex();
	
	public GoodsInfo findByGno(String gno);
	public List<GoodsInfo> findByTno(String tno, int page, int rows);
	public Map<String, Object> findByTnos(String tno, int page, int rows);
}
