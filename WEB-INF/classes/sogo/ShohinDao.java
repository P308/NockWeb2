package sogo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ShohinBean;

//DBAccessを継承
public class ShohinDao extends DBAccess {

	//shohinテーブルを全件検索するメソッド
	public ArrayList<ShohinBean> selectAll() {
		//arrayListをnewする
		ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();

		String sql = "select * from shohin";

		try {
			//Connectionオブジェクトを取得する
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			//ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				ShohinBean bean = new ShohinBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPrice(rs.getInt("kakaku"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	//idを所得してデータベースから検索するメソッド
	public ArrayList<ShohinBean> jouken(String id) {
		ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
		//		SQLをStringで定義
		String sql = "SELECT * from shohin where id= ?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			//queryに入れるIDを発行
			ps.setString(1, id);
			//SQLを発行
			ResultSet rs = ps.executeQuery();
			//Beanにユーザー情報を設定
			while (rs.next()) {
				ShohinBean bean = new ShohinBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPrice(rs.getInt("kakaku"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	//id,name,priceを所得してテーブルに挿入。
	public int insert(String id, String name, int price) {
		String sql = "insert into shohin(id,name,kakaku) values (?,?,?) ";
		//counterを宣言
		int counter = 0;

		try {
			connect();

			PreparedStatement ps = getConnection().prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, price);

			counter = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return counter;
	}

	//データを更新するメソッド
	public int update(String id, String name, int price) {
		int counter = 0;
		String sql = "UPDATE shohin SET name =?,kakaku=? where id=? ";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, price);
			ps.setString(3, id);
			//counterに件数を記録
			counter = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return counter;
	}

	//削除するメソッド
	public int delete(String id) {
		int counter = 0;
		String sql = "DELETE FROM shohin WHERE id=?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);

			counter = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return counter;
	}
}
