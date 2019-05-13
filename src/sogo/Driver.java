package sogo;

import java.util.ArrayList;

import bean.ShohinBean;

public class Driver {

	public static void main(String[] args) {
		selectAll();

		jouken();

		insert();

		update();

		delete();

		numCheck();

		exitId();

		notExitId();

	}

	public static void selectAll() {
		System.out.println("****全件検索メソッドテスト");
		ShohinDao dao = new ShohinDao();
		ArrayList<ShohinBean> list = dao.selectAll();
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getId()+",");
			System.out.print(list.get(i).getName()+",");
			System.out.println(list.get(i).getPrice()+",");
		}
		if(list.size()==0) {
			System.out.println("Data isnot Exist");
		}
	}

	public static void jouken() {
		System.out.println("****検索のテスト");
		ShohinDao dao= new ShohinDao();
		ArrayList<ShohinBean> list  = dao.jouken("00001");

		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getId()+",");
			System.out.print(list.get(i).getName()+",");
			System.out.println(list.get(i).getPrice()+",");
		}
		if(list.size()==0) {
			System.out.println("条件に合うテーブルが見つかりません");
		}
	}

	public static void insert() {
		System.out.println("****新規追加のテスト");
		ShohinDao dao = new ShohinDao();
		int count = dao.insert("00011","テストフルーツ", 100000);

		if(count != 0) {
			System.out.println("追加できました");
		}else {
			System.out.println("追加できません");
		}
	}

	public static void update() {
		System.out.println("****更新確認テスト");
		ShohinDao dao = new ShohinDao();
		int count = dao.update("00011","テスト",100);
		if(count != 0) {
			System.out.println("削除できました");
		}else {
			System.out.println("削除できません");
		}
	}

	public static void delete() {
		System.out.println("****削除テスト");
		ShohinDao dao = new ShohinDao();
		int count = dao.delete("00011");
		if(count != 0) {
			System.out.println("delete OK");
		}else {
			System.out.println("delete failed");
		}


	}

	public static void numCheck() {
		Errcheck err = new Errcheck();

		String msg = err.numCheck("r0", "1234");
		System.out.println(msg);
	}

	public static void exitId() {
		Errcheck err = new Errcheck();
		String msg = err.exitId("00001");

		System.out.println(msg);
	}

	public static void notExitId() {
		Errcheck err = new Errcheck();

		String msg = err.notExistId("1111");

		System.out.println(msg);
	}

}
