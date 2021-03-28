package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Diary;
import utils.DBUtil;

/**
 * Servlet implementation class TopPageIndexServlet
 */
@WebServlet("/month")
public class MonthViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MonthViewServlet() {
		super();
	}

	/*
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();

		int page;
		try{
			page = Integer.parseInt(request.getParameter("page"));
		} catch(Exception e) {
			page = 1;
		}

		Integer mon =Integer.parseInt(request.getParameter("mon"));

		//月毎のリスト
		List<Diary> diarys_month = em.createNamedQuery("getDiarysMonth", Diary.class)
				.setParameter("MonthFind",mon)
				.setFirstResult(10 * (page - 1))
				.setMaxResults(10)
				.getResultList();

		long diarys_count = (long)em.createNamedQuery("getDiarysCount", Long.class)
				.getSingleResult();

		//月ページへのリンク作成用
		List<Diary> month = em.createNamedQuery("getMonth", Diary.class)
				.getResultList();

		em.close();

		request.setAttribute("diarys_month", diarys_month);
		request.setAttribute("diarys_count", diarys_count);
		request.setAttribute("page", page);
		request.setAttribute("mon", mon);
		request.setAttribute("month", month);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/month/month.jsp");
		rd.forward(request, response);
	}
}