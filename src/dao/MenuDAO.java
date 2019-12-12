package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Menu;

public class MenuDAO {
	private MenuDAO() { 
	}
	
	private static MenuDAO instance = new MenuDAO();
	public static MenuDAO getInstance(){
		return instance;
	} 

	// insert
	public int insert(Connection conn, Menu p) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into Menu values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getStoreID());
			pstmt.setInt(2, p.getMenuID());
			pstmt.setString(3, p.getMenuName());
			pstmt.setInt(4, p.getPrice());
			return pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	// delete
	public int delete(Connection conn, int storeID) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from Menu where storeID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, storeID);
			return pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	
	// select(find/get)
	public Menu select(Connection conn, int storeID) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from Menu where storeID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, storeID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return createFromResultSet(rs);
			}
			else {
				return null;
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	
	
	
	public Menu createFromResultSet(ResultSet rs) throws SQLException {
		int storeID = rs.getInt("storeID");
		int menuID = rs.getInt("menuID");
		String menuName = rs.getString("menuName");
		int price = rs.getInt("price");

		Menu s = new Menu(storeID, menuID, menuName, price);
		return s;
	}
	
	// selectList
	public List<Menu> selectList(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from Menu";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Menu> sList = new ArrayList<>();
			while (rs.next()) {
				sList.add(createFromResultSet(rs));
			}
			return sList;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	// selectList
		public List<Menu> selectListByStoreID(Connection conn, int storeID) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = "select * from Menu where storeID=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, storeID);
				rs = pstmt.executeQuery();
				List<Menu> sList = new ArrayList<>();
				while (rs.next()) {
					sList.add(createFromResultSet(rs));
				}
				return sList;
			} finally {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			}
		}
}
