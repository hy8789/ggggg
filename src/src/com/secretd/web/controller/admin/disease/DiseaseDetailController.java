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
import src.com.secretd.web.entity.Disease;
import src.com.secretd.web.entity.Notice;

@WebServlet("/admin/disease/detail")
public class DiseaseDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String _name = request.getParameter("name");
		String name = "";
		if (_name != null && !_name.equals(""))
			name = _name;
		// Model
		DiseaseDao dao = new JdbcDiseaseDao();
		Disease n = dao.get(name);
		request.setAttribute("detail", n);
		request.getRequestDispatcher("/WEB-INF/views/admin/disease/detail.jsp").forward(request, response);
	}
}
