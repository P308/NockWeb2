package sogo;

import java.util.ArrayList;

import bean.ShohinBean;

public class Errcheck extends DBAccess{
	public String numCheck(String id,String price){
		//return用のString message を召喚
		String message;
		//数字が入力されているかどうかを判定
		if(id.matches("[0-9]+") && price.matches("[0-9]+")) {
			//整数が入力されているかどうかを判定
			if(Integer.parseInt(id)>0 && Integer.parseInt(price)>0){
				message = null;
			}else {
				message = "IDと価格には整数を入力してください";
			}
		}else {
			message = "IDと価格には数字を入力してください";
		}

		return message;
	}

	public String exitId(String id) {
		String message = null;
		ShohinDao dao = new ShohinDao();
		ArrayList<ShohinBean> list = dao.jouken(id);
		for(int i = 0;i<list.size();i++) {
			message = "既に存在しています";
		}

		return message;
	}

	public String notExistId(String id) {
		ShohinDao dao = new ShohinDao();

		ArrayList<ShohinBean> list = dao.jouken(id);

		if(list.size()==0) {
			return "対象データはありません";
		}else {
			return null;
		}
	}
}
