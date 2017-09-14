package src.com.secretd.web.dao.jdbc;

import java.util.List;

import src.com.secretd.web.dao.DiseaseDao;
import src.com.secretd.web.entity.Disease;
import src.com.secretd.web.entity.NoticeView;

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
		// JDBC µÂ∂Û¿Ãπˆ ∑ŒµÂ
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// ø¨∞· / ¿Œ¡ı
			Connection con = DriverManager.getConnection(url, "soonface", "2014");

			// Ω««‡
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+title+"%");
			st.setInt(2, offset);

			// ∞·∞˙ ∞°¡Æø¿±‚
			ResultSet rs = st.executeQuery();

			// Model
			list = new ArrayList<>();

			// ∞·∞˙ ªÁøÎ«œ±‚
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

		// JDBC µÂ∂Û¿Ãπˆ ∑ŒµÂ
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// ø¨∞· / ¿Œ¡ı
			Connection con = DriverManager.getConnection(url, "soonface", "2014");

			// Ω««‡
			Statement stCount = con.createStatement();

			// ∞·∞˙ ∞°¡Æø¿±‚
			ResultSet rsCount = stCount.executeQuery(sqlCount);

			rsCount.next();

			// Model
			count = rsCount.getInt("count");

			// ∞·∞˙ ªÁøÎ«œ±‚

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
		// JDBC µÂ∂Û¿Ãπˆ ∑ŒµÂ
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// ø¨∞· / ¿Œ¡ı
			Connection con = DriverManager.getConnection(url, "soonface", "2014");

			// Ω««‡
			PreparedStatement st = con.prepareStatement(sql);


			st.setString(1, "%"+title+"%");
			st.setString(2, "%"+category+"%");
			st.setInt(3, offset);

			// ∞·∞˙ ∞°¡Æø¿±‚
			ResultSet rs = st.executeQuery();
			System.out.println("page :"+page );
			// Model
			list = new ArrayList<>();

			// ∞·∞˙ ªÁøÎ«œ±‚
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

		// JDBC µÂ∂Û¿Ãπˆ ∑ŒµÂ
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// ø¨∞· / ¿Œ¡ı
			Connection con = DriverManager.getConnection(url, "soonface", "2014");

			// Ω««‡
			PreparedStatement st = con.prepareStatement(sqlCount);

			st.setString(1, "%"+title+"%");
			st.setString(2, "%"+category+"%");

			// ∞·∞˙ ∞°¡Æø¿±‚

			ResultSet rsCount = st.executeQuery();

			while (rsCount.next()) {
				// Model
				count = rsCount.getInt("count");
			}
			// ∞·∞˙ ªÁøÎ«œ±‚

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

	@Override
	public void insert(String code, String number, String name, String explanation, String picture) {
		String sql = "INSERT INTO Disease(class_code,number, name, explanation,picture,manager_id) VALUES(?,?,?,?,?,admin)";
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "soonface", "2014");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, code);
			st.setString(2, number);
			st.setString(3, name);
			st.setString(4, explanation);
			st.setString(5, picture);
			int result = st.executeUpdate();
			if(result==1)
				System.out.println("Í∏??ì±Î°? ?ôÑÎ£?");
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Disease get(String name) {
		Disease n = null;
		String sql = "SELECT * FROM Disease WHERE name = ?";
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC ?ìú?ùº?ù¥Î≤? Î°úÎìú
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ?ó∞Í≤? / ?ù∏Ï¶?
			Connection con = DriverManager.getConnection(url, "soonface", "2014");
			// ?ã§?ñâ
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			// Í≤∞Í≥º Í∞??†∏?ò§Í∏?
			ResultSet rs = st.executeQuery();
			// Í≤∞Í≥º ?Ç¨?ö©?ïòÍ∏?
			if (rs.next()) {
				n = new Disease();
				n.setNumber(rs.getString("number"));
				n.setClassCode(rs.getString("class_code"));
				n.setName(rs.getString("name"));
				n.setExplanation(rs.getString("explanation"));
				n.setPicture(rs.getBlob("picture"));
				n.setManagerI(rs.getString("manager_id"));
				n.setCategory(rs.getString("category"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public void delete(String name) {
		String sql = "DELETE FROM Disease WHERE name = ?";
		String url = "jdbc:mysql://211.238.142.247/soonfacedb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		// JDBC ?ìú?ùº?ù¥Î≤? Î°úÎìú
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ?ó∞Í≤? / ?ù∏Ï¶?
			Connection con = DriverManager.getConnection(url, "soonface", "2014");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			int result = st.executeUpdate();
			if (result == 1)
				System.out.println("?Ç≠?†ú?ôÑÎ£?");
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(String code, String number, String name, String explanation, String picture) {
		String sql = "UPDATE Disease SET class_code= ?,number = ? ,explanation=?, picture=? WHERE name = ?";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		// JDBC ?ìú?ùº?ù¥Î≤? Î°úÎìú
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ?ó∞Í≤? / ?ù∏Ï¶?
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, code);
			st.setString(2, number);
			st.setString(3, explanation);
			st.setString(4, picture);
			st.setString(5, name);

			int result = st.executeUpdate();
			if (result == 1)
				System.out.println("?àò?†ï?ôÑÎ£?");
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
