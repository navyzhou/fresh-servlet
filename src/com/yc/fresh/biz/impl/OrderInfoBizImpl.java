package com.yc.fresh.biz.impl;

import com.yc.fresh.biz.IOrderInfoBiz;
import com.yc.fresh.dao.IOrderInfoDao;
import com.yc.fresh.dao.impl.OrderInfoDaoImpl;
import com.yc.fresh.util.StringUtil;

public class OrderInfoBizImpl implements IOrderInfoBiz{

	@Override
	public int add(String cnos, double totalPrice) {
		if (StringUtil.checkNull(cnos)) {
			return -1;
		}
		
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.add(cnos, totalPrice);
	}

}
