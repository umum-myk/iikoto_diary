package controllers.like;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Like;
import models.Report;
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

		Like l =new Like();
		Report report_id = em.find(Report.class, (Integer)(request.getSession().getAttribute("report_id")));

		l.setEmployee((Employee)request.getSession().getAttribute("login_employee"));
		l.setYoine(Integer.parseInt(request.getParameter("1")));
		l.setReport_id(report_id);

         // データベースに保存
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        request.getSession().setAttribute("flush", "いいねしました。");
        em.close();

        response.sendRedirect(request.getContextPath() + "/reports/index");
    }
	}