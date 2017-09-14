package src.com.secretd.web.dao.jdbc;

import java.util.List;

import src.com.secretd.web.dao.HospitalDao;
import src.com.secretd.web.entity.Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class JdbcHospitalDao implements HospitalDao {

	@Override
	public List<Hospital> getList(int page, String title, String category, String address) {
		
		List<Hospital> list = null;
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";	
		String sql = "SELECT * FROM Hospital WHERE name like ? and subject like ? and address LIKE ? order by name limit ?,10";
		
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
			st.setString(3, "%"+address+"%");
			st.setInt(4, offset);

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// Model
			list = new ArrayList<>();
			// 결과 사용하기
			while (rs.next()) {
				Hospital n = new Hospital();
				
				n.setNumber(rs.getString("NUMBER"));
				n.setSubject(rs.getString("SUBJECT"));
				n.setName(rs.getString("NAME"));
				n.setAddress(rs.getString("ADDRESS"));
				n.setPhoneNumber(rs.getString("PHONE_NUMBER"));
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
	public int getCount(int page, String title, String category, String address) {
		
		int count = 0;
		String sqlCount = "select count(name) as count from Hospital "
				+ "where name like ? and subject LIKE ?   and address LIKE ?";
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 / 인증
			Connection con = DriverManager.getConnection(url, "soonface", "2014");

			// 실행
			PreparedStatement stCount = con.prepareStatement(sqlCount);
			stCount.setString(1, "%"+title+"%");
			stCount.setString(2, "%"+category+"%");
			stCount.setString(3, "%"+address+"%");
			
			// 결과 가져오기
			  ResultSet rscount = stCount.executeQuery();
              
              rscount.next();
              
              count = rscount.getInt("count");
			// 결과 사용하기

			rscount.close();
			stCount.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

}
