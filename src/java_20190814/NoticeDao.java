package java_20190814;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeDao {
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 1. singleton
	// -1. static 변수로 self 자료형 변수를 선언하고 접근 한정자는 private으로 한다. 
	private static NoticeDao single;
	// -2. defalut 생성자의 접근한정자는 private로 선언한다.
	// -> 외부에서 객체 생성을 못하게 하기 위해서
	private NoticeDao() {
	}
	// -3. 객체생성할 수 있는 getInstance() 메서드를 선언한다.
	// 이 때, single 변수의 null 체크를 하여 null인 경우에만 객체를 생성한다.
	// 이렇게 함으로써 다중클라이언트가 접근하더라도 한개의 객체를 공유해서 사용할 수 있다.
	public static NoticeDao getInstace() {
		if (single == null) {
			// 객체를 생성할 수 있는 생성자의 접근 한정자가 private이기 때문에
			// 클래스내에서만 객체를 생성할 수 있다.
			single = new NoticeDao();
		}
		
		return single;
	}
	
	public boolean insert(NoticeDto n) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into notice(num, writer, title, content, regdate) ");
			sql.append("values(?, ?, ?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, n.getWriter());
			pstmt.setString(index++,  n.getTitle());
			pstmt.setString(index++, n.getContent());
			pstmt.setString(index++, n.getRegdate());
			pstmt.executeUpdate();
			
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	public boolean update(NoticeDto n) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("update notice ");
			sql.append("set writer = ?, title = ?, content = ?, regdate = ? ");
			sql.append("where num = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, n.getWriter());
			pstmt.setString(index++, n.getTitle());
			pstmt.setString(index++, n.getContent());
			pstmt.setString(index++, n.getRegdate());
			pstmt.setInt(index, n.getNum());
			pstmt.executeUpdate();
			
			isSuccess = true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	public boolean delete(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("delete from notice ");
			sql.append("where num = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index, num);
			pstmt.executeUpdate();
			
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	public ArrayList<NoticeDto> select(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			
			sql.append("select num, writer, title, content, regdate ");
			sql.append("from notice ");
			
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
}