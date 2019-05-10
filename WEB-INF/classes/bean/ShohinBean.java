package bean;
import java.io.Serializable;

public class ShohinBean implements Serializable{

//	private static final long serialVersionUID = 1L;
	//private属性で変数を宣言
	private String id;
	private String name;
	private int kakaku;

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

	public void setPrice(int kakaku) {
		this.kakaku = kakaku;
	}
	public int getPrice() {
		return this.kakaku;
	}
}

