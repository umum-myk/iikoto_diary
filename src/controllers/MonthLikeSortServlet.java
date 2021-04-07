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
@WebServlet("/sort")
public class MonthLikeSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MonthLikeSortServlet() {
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
		Integer year =Integer.parseInt(request.getParameter("year"));

		//月毎ソート
		List<Diary> sort_month = em.createNamedQuery("getSortMonth", Diary.class)
				.setParameter("MonthFind",mon)
				.setParameter("YearFind",year)
				.setFirstResult(10 * (page - 1))
				.setMaxResults(10)
				.getResultList();


		long diarys_count = (long)em.createNamedQuery("getDiarysCount", Long.class)
				.getSingleResult();

		//月ページへのリンク作成用
		List<Diary> month = em.createNamedQuery("getMonth", Diary.class)
				.getResultList();

		em.close();

		request.setAttribute("page", page);
		request.setAttribute("sort_month", sort_month);
		request.setAttribute("diarys_count", diarys_count);
		request.setAttribute("mon", mon);
		request.setAttribute("year", year);
		request.setAttribute("month", month);


		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/month/sortmonth.jsp");
		rd.forward(request, response);
	}

}