package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Store;

public class StoreDAO {
	private StoreDAO() { 
	}
	
	private static StoreDAO instance = new StoreDAO();
	public static StoreDAO getInstance(){
		return instance;
	} 

	// insert
	public int insert(Connection conn, Store p) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into Store values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getStoreID());
			pstmt.setString(2, p.getName());
			pstmt.setString(3, p.getAddress());
			pstmt.setInt(4, p.getPhone());
			pstmt.setInt(5, p.getOpen());
			pstmt.setInt(6, p.getClose());
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
			String sql = "delete from Store where storeID=?";
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
	public Store select(Connection conn, int storeID) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from Store where storeID=?";
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
	
	// select(find/get)
	public Store selectByStoreID(Connection conn, String storeID) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from Store where storeID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storeID);
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
	
	
	public Store createFromResultSet(ResultSet rs) throws SQLException {
		int storeID = rs.getInt("storeID");
		String name = rs.getString("name");
		String address = rs.getString("address");
		int phone = rs.getInt("phone");
		int open = rs.getInt("open");
		int close = rs.getInt("close");
		
		Store c = new Store(storeID, name, address, phone, open, close);
		return c;
	}
	
	// selectList
	public List<Store> selectList(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from Store";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Store> mList = new ArrayList<>();
			while (rs.next()) {
				mList.add(createFromResultSet(rs));
			}
			return mList;
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
