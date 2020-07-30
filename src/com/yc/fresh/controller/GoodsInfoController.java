package com.yc.fresh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.fresh.biz.IGoodsInfoBiz;
import com.yc.fresh.biz.impl.GoodsInfoBizImpl;

@WebServlet("/goods")
public class GoodsInfoController extends BasicServlet{
	private static final long serialVersionUID = -7105682880846685912L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
	
		if ("finds".equals(op)) {
			finds(request, response);
		} else if ("findByPage".equals(op)) {
			findByPage(request, response);
		} else if ("findByCondition".equals(op)) {
			findByCondition(request, response);
		} else if ("findIndex".equals(op)) {
			findIndex(request, response);
		} else if ("findByGno".equals(op)) {
			findByGno(request, response);
		} else if ("findByTnos".equals(op)) {
			findByTnos(request, response);
		} else if ("findByTno".equals(op)) {
			findByTno(request, response);
		}
	}

	private void findByTno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tno = request.getParameter("tno");
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, 200, "", goodsInfoBiz.findByTno(tno, page, rows));
	}

	private void findByTnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tno = request.getParameter("tno");
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, 200, "", goodsInfoBiz.findByTnos(tno, page, rows));
	}

	private void findByGno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String gno = request.getParameter("gno");
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, 200, "", goodsInfoBiz.findByGno(gno));
	}

	private void findIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, 200, "", goodsInfoBiz.findIndex());
	}

	private void findByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		String tno = request.getParameter("tno");
		String gname = request.getParameter("gname");
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.findByCondition(tno, gname, page, rows));
	}

	private void finds(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.finds(page, rows));
	}

	private void findByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.findByPage(page, rows));
	}
}
