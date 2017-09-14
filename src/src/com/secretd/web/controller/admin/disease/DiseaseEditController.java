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

@WebServlet("/admin/disease/edit")
public class DiseaseEditController extends HttpServlet {
	@Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
		   String  _name = request.getParameter("name"); 
		   String name = ""; 
			if(_name != null && !_name.equals(""))
				name=_name;

			Disease n= null;

			DiseaseDao diseaseDao = new JdbcDiseaseDao();
			n=diseaseDao.get(name);	
			request.setAttribute("detail",n);
	        request.getRequestDispatcher("/WEB-INF/views/admin/disease/edit.jsp").forward(request, response);
	   }

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("UTF-8");
		   String code = request.getParameter("code");
		   String number = request.getParameter("number");
		   String name = request.getParameter("name"); 
		   String explanation = request.getParameter("explanation"); 
		   String picture = request.getParameter("picture"); 

		   DiseaseDao diseaseDao = new JdbcDiseaseDao();
		   diseaseDao.edit(code,number,name,explanation,picture);
		   response.sendRedirect("detail?name="+name);
		}
}
