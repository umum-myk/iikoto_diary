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
@WebServlet("/search")
public class SearchViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchViewServlet() {
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

		String search =request.getParameter("search");

		//月毎のリスト
		List<Diary> diarys_search = em.createNamedQuery("getDiarysSearch", Diary.class)
				.setParameter("MonthFind", "%" +search+ "%")
				.setFirstResult(10 * (page - 1))
				.setMaxResults(10)
				.getResultList();

		long diarys_count = (long)em.createNamedQuery("getDiarysCount", Long.class)
				.getSingleResult();


		em.close();

		request.setAttribute("diarys_search", diarys_search);
		request.setAttribute("diarys_count", diarys_count);
		request.setAttribute("page", page);
		request.setAttribute("search", search);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/month/search.jsp");
		rd.forward(request, response);
	}
}