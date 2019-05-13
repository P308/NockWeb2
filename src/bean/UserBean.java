package bean;
import java.io.Serializable;

public class UserBean implements Serializable{

//	private static final long serialVersionUID = 1L;
	//private属性で変数を宣言
	private String id;
	private String name;
	private String dept;
	private String status;
	private String kyuyo;

//	それぞれのsetter getterをセット
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}

	public void setName(String name ) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return this.status;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDept() {
		return this.dept;
	}

	public void setKyuyo(String kyuyo) {
		this.kyuyo = kyuyo;
	}
	public String getKyuyo() {
		return this.kyuyo;
	}
}
