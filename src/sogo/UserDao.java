package sogo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.UserBean;

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
	public String getStatus(String id,String pass) {
		String dept = null;
		String sql = "select name from status where (id)=(select status from user where id = ? and pass = ?)";

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

	public ArrayList<UserBean> selectSalaly() {
		//arrayListをnewする
		ArrayList<UserBean> list = new ArrayList<UserBean>();

		String sql = "select user.id,user.name,dep.name,status.name,status.kyuyo from user right join dep on  user.dep = dep.id right join status on user.status = status.id";

		try {
			//Connectionオブジェクトを取得する
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			//ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				UserBean bean = new UserBean();
				bean.setId(rs.getString("user.id"));
				bean.setName(rs.getString("user.name"));
				bean.setDept(rs.getString("dep.name"));
				bean.setStatus(rs.getString("status.name"));
				bean.setKyuyo(rs.getString("status.kyuyo"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
