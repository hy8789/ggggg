package src.com.secretd.web.controller.guest.hospital;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.secretd.web.dao.HospitalDao;
import src.com.secretd.web.dao.jdbc.JdbcHospitalDao;

@WebServlet("/guest/hospital-list")
public class HospitalListController extends HttpServlet {

	
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			String _title = request.getParameter("title");
			String _page = request.getParameter("p");
			String _category = request.getParameter("c");
			String _address = request.getParameter("a");
			
			String title="";
			int page=1;
			String category="";
			String address="";
			
			if(_title !=null && !_title.equals(""))
				title = _title;
			if(_page !=null && !_page.equals(""))
				page = Integer.parseInt(_page);
			if(_category !=null && !_category.equals(""))
				category = _category;
			if(_address !=null && !_address.equals(""))
				address = _address;
			
			HospitalDao hospitalDao = new JdbcHospitalDao();
			
			request.setAttribute("list", hospitalDao.getList(page, title, category, address));
			request.setAttribute("count", hospitalDao.getCount(page, title, category, address));
			
			request.getRequestDispatcher("/WEB-INF/views/guest/hospital/list.jsp").forward(request, response);
		}
}
