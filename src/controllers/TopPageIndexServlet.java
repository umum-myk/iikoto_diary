package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
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
@WebServlet("/index")
public class TopPageIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopPageIndexServlet() {
		super();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();

		Diary d = new Diary();

		d.setBodytext(request.getParameter("iikoto"));


		//Date、Month、Yearの格納
		Date createDate = new Date(System.currentTimeMillis());
		Integer createMonth = new Integer(Calendar.getInstance().get(Calendar.MONTH)+1);
		Integer createYear = new Integer(Calendar.getInstance().get(Calendar.YEAR));
		d.setCreateDate(createDate);
		d.setCreateMonth(createMonth);
		d.setCreateYear(createYear);

		d.setIine(0);

		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();


        response.sendRedirect(request.getContextPath() + "/index");

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

		List<Diary> diarys = em.createNamedQuery("getMyAllDiarys", Diary.class)
				.setFirstResult(10 * (page - 1))
				.setMaxResults(10)
				.getResultList();

		long diarys_count = (long)em.createNamedQuery("getDiarysCount", Long.class)
				.getSingleResult();

		//月ページへのリンク作成用
		List<Diary> month = em.createNamedQuery("getMonth", Diary.class)
				.getResultList();


		em.close();

		request.setAttribute("diarys", diarys);
		request.setAttribute("diarys_count", diarys_count);
		request.setAttribute("page", page);
		request.setAttribute("month", month);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topPage/index.jsp");
		rd.forward(request, response);
	}

}