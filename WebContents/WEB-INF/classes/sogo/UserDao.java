package sogo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao extends DBAccess{
	public String getUser(String id,String pass) {
		String sql = "select name from user where id = ? and pass = ?";

		String name = null;
		ResultSet rs = null;

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,pass);
			rs = ps.executeQuery();

			while(rs.next()) {
				name = rs.getString("name");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}

		return name;
	}

	public String getDept(String id,String pass) {
		String dept = null;
		String sql = "select name from dep where (id)=(select dep from user where id = ? and pass = ?)";

		ResultSet rs = null;
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,pass);
			rs = ps.executeQuery();

			while(rs.next()) {
				dept = rs.getString("name");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return dept;

	}
}
