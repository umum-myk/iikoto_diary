package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Diary;
import utils.DBUtil;

/**
 * Servlet implementation class LikeServlet
 */
@WebServlet("/create/like")
public class CreateLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateLikeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();

		Diary d =em.find(Diary.class, Integer.parseInt(request.getParameter("id")));

		d.setIine(1);

         // データベースに保存
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();

        response.sendRedirect(request.getContextPath() + "/index");
    }
	}