package com.yc.fresh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.fresh.biz.IOrderInfoBiz;
import com.yc.fresh.biz.impl.OrderInfoBizImpl;

@WebServlet("/order")
public class OrderInfoController extends BasicServlet{
	private static final long serialVersionUID = -1614905698871207884L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		if ("add".equals(op)) { // 添加订单
			add(request, response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cnos = request.getParameter("cnos");
		double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
		
		IOrderInfoBiz orderInfoBiz = new OrderInfoBizImpl();
		int result = orderInfoBiz.add(cnos, totalPrice);
		if (result > 0) {
			this.send(response, 200, null, null);
			return;
		}
		this.send(response, 500, null, null);
	}
}
