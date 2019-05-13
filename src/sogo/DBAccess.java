package sogo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccess {
//	DB接続用の定数を宣言、代入
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/sogo?useUnicode=true&characterEncoding=utf8";
	private static final String DB_USER = "root";
//	自前環境のデータベース接続でパスワードは設定済み
	private static final String DB_PWD = "password";
//java.sql.Connectionメソッドを呼び出し
	private Connection connection = null;

//Connection sogo.DBAccess.getConnection()
	public Connection getConnection() {
		return this.connection;
	}

	public void connect() {
		connect(DB_DRIVER,DB_URL,DB_USER,DB_PWD);
	}
//オーバーロード connect処理
	public void connect(String driver,String url, String user,String pass) {
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(url,user,pass);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

//disconnect処理
	public void disconnect() {
		try {
			if(this.connection != null) {
//				リソースの解放
				this.connection.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			this.connection = null;
		}
	}

}
