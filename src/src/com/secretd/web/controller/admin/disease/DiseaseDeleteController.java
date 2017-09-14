package src.com.secretd.web.controller.admin.disease;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.secretd.web.dao.DiseaseDao;
import src.com.secretd.web.dao.jdbc.JdbcDiseaseDao;

@WebServlet("/admin/disease/delete")
public class DiseaseDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
	
		DiseaseDao dao = new JdbcDiseaseDao();
		dao.delete(name);

		response.sendRedirect("list");
	}
}
