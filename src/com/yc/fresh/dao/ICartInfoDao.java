package com.yc.fresh.dao;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.CartInfo;

public interface ICartInfoDao {
	/**
	 * 只查购物车编号和商品编号
	 * @return
	 */
	public List<Map<String, Object>> findCart(String mno);
	
	/**
	 * 根据会员编号，查询购物详细信息
	 * @param mno
	 * @return
	 */
	public List<CartInfo> finds(String mno);
	
	/**
	 * 修改数量
	 * @param cno
	 * @param num
	 * @return
	 */
	public int updateNum(String cno, int num);
	
	/**
	 * 添加购物车
	 * @param cf
	 * @return
	 */
	public int add(CartInfo cf);
	
	/**
	 * 删除购物车
	 * @param cnos
	 * @return
	 */
	public int delete(String[] cnos);
	
	public int delete(String cno);
	
	public List<CartInfo> findByCnos(String[] cnos);
}
