package com.yc.fresh.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.yc.fresh.dao.DBHelper;
import com.yc.fresh.dao.IOrderInfoDao;

public class OrderInfoDaoImpl implements IOrderInfoDao{

	@Override
	public int add(String cnos, double totalPrice) {
		// 添加一条数据到订单表中 （订单编号、总价
		String ono = UUID.randomUUID().toString().replace("-", "");
		String sql1 = "insert into orderinfo values(?, now(), null, null, null, 1, ?, 0)";
		List<Object> param1 = new ArrayList<Object>();
		param1.add(ono);
		param1.add(totalPrice);
		
		// 添加多条记录到订单详细表 non  gno nums price
		String sql2 = "insert into orderiteminfo select 0, ?, c.gno, c.num, price, 1 from cartinfo c, goodsinfo g where c.gno=g.gno and cno in(";
		List<Object> param2 = new ArrayList<Object>();
		param2.add(ono);
		String[] temp = cnos.split(",");
		for (String cno : temp) {
			sql2 += "?,";
			param2.add(cno);
		}
		sql2 = sql2.substring(0, sql2.lastIndexOf(",")) + ")";
		
		List<String> sqls = new ArrayList<String>();
		List<List<Object>> params = new ArrayList<List<Object>>();
		sqls.add(sql1);
		params.add(param1);
		
		sqls.add(sql2);
		params.add(param2);
		
		
		// 修改商品的库存 gno  nums
		String sql3 = null;
		List<Object> param = null;
		for (String cno : temp) {
			param = new ArrayList<Object>();
			sql3 = "update goodsinfo set balance = balance - (select num from cartinfo where cno=?) where gno = (select gno from cartinfo where cno=?)";
			param.add(cno);
			param.add(cno);
			
			sqls.add(sql3);
			params.add(param);
		}
		
		// 删除购物车表 cno
		String sql4 = "delete from cartinfo where cno in(";
		List<Object> param4 = new ArrayList<Object>();
		for (String cno : temp) {
			sql4 += "?,";
			param4.add(cno);
		}
		sql4 = sql4.substring(0, sql4.lastIndexOf(",")) + ")";
		sqls.add(sql4);
		params.add(param4);
		
		DBHelper db = new DBHelper();
		return db.updates(sqls, params);
	}
}
