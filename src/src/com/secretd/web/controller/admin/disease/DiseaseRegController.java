package src.com.secretd.web.controller.admin.disease;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.secretd.web.dao.DiseaseDao;
import src.com.secretd.web.dao.NoticeDao;
import src.com.secretd.web.dao.jdbc.JdbcDiseaseDao;
import src.com.secretd.web.dao.jdbc.JdbcNoticeDao;

@WebServlet("/admin/disease/reg")
public class DiseaseRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/admin/disease/reg.jsp").forward(request, response);
	}
	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String explanation = request.getParameter("explanation");
		String picture = request.getParameter("picture");

		DiseaseDao dao = new JdbcDiseaseDao();
		dao.insert(code, number,name,explanation,picture);

		response.sendRedirect("list");
	}
}
