package src.com.secretd.web.dao.jdbc;

import java.util.List;

import src.com.secretd.web.dao.DiseaseDao;
import src.com.secretd.web.entity.Disease;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Statement;
public class JdbcDiseaseDao implements DiseaseDao {

/*	@Override
	public List<Disease> getList(int page, String title) {
		List<Disease> list = null;
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql = "SELECT * FROM Disease WHERE name like ? order by name limit ?,10";
		
		int offset = (page - 1) * 10;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 / 인증
			Connection con = DriverManager.getConnection(url, "soonface", "2014");

			// 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+title+"%");
			st.setInt(2, offset);

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// Model
			list = new ArrayList<>();

			// 결과 사용하기
			while (rs.next()) {
				Disease n = new Disease();
				n.setClassCode(rs.getString("CLASS_CODE"));
				n.setNumber(rs.getString("NUMBER"));
				n.setName(rs.getString("NAME"));
				n.setExplanation(rs.getString("EXPLANATION"));
				n.setPicture(rs.getBlob("PICTURE"));

				list.add(n);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int getCount() {
		int count = 0;
		String sqlCount = "SELECT COUNT(name) as count FROM Disease";

		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 / 인증
			Connection con = DriverManager.getConnection(url, "soonface", "2014");

			// 실행
			Statement stCount = con.createStatement();

			// 결과 가져오기
			ResultSet rsCount = stCount.executeQuery(sqlCount);

			rsCount.next();

			// Model
			count = rsCount.getInt("count");

			// 결과 사용하기

			rsCount.close();
			stCount.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

*/
	@Override


	public List<Disease> getList(int page, String title, String category) {
		List<Disease> list = null;
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql = "SELECT * FROM Disease WHERE name like ? and category like ? order by name limit ?,10";
		
		int offset = (page - 1) * 10;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 / 인증
			Connection con = DriverManager.getConnection(url, "soonface", "2014");

			// 실행
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, "%"+title+"%");
			st.setString(2, "%"+category+"%");
			st.setInt(3, offset);

			// 결과 가져오기
			ResultSet rs = st.executeQuery();
			System.out.println("page :"+page );
			// Model
			list = new ArrayList<>();

			// 결과 사용하기
			while (rs.next()) {
				Disease n = new Disease();
				n.setClassCode(rs.getString("CLASS_CODE"));
				n.setNumber(rs.getString("NUMBER"));
				n.setName(rs.getString("NAME"));
				n.setExplanation(rs.getString("EXPLANATION"));
				n.setPicture(rs.getBlob("PICTURE"));

				list.add(n);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int getCount(int page, String title, String category) {
		int count = 0;
		String sqlCount = "select count(name) as count from Disease where name like ? and category LIKE ? ";

		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 / 인증
			Connection con = DriverManager.getConnection(url, "soonface", "2014");

			// 실행
			PreparedStatement st = con.prepareStatement(sqlCount);

			st.setString(1, "%"+title+"%");
			st.setString(2, "%"+category+"%");
			
			// 결과 가져오기
			
			ResultSet rsCount = st.executeQuery();

			while (rsCount.next()) {
System.out.println("hhhh");
			// Model
			count = rsCount.getInt("count");
			}
			// 결과 사용하기

			rsCount.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

}
