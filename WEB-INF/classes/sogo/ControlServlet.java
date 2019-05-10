package sogo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControlServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	//	商品登録から確認画面へ遷移する
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		文字コード設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charaset = UTF-8");

		//セッションの取得
		HttpSession session = request.getSession(true);
		//登録変更画面で登録された情報を所得
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");

		String forward = null;

		Errcheck err = new Errcheck();
		//mod.jspの登録ボタンを押した時の処理
		if (request.getParameter("submit").equals("登録")) {
			String errmsg = null;
			String errmsg2 = null;
			//数値が入力されていなかったら
			errmsg = err.numCheck(id, price);
			//idがすでに存在していたら
			errmsg2 = err.exitId(id);
			//mod.jsp の確認ボタンを押した際、kakunin.jspへ画面遷移する記述
			if (errmsg == null && errmsg2 == null) {
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("price", price);
				forward = "/web/kakunin.jsp";
			} else {
				//mod.jspの確認ボタンを押した際にエラーがあった場合
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("price", price);
				//errmsgをAttributeにsetしてエラーをかえす
				request.setAttribute("errmsg", errmsg);
				request.setAttribute("errmsg2", errmsg2);
				forward = "/web/mod.jsp?no=4";
			}
		}
		//mod.jspの変更ボタンを押した時の処理
		if (request.getParameter("submit").equals("変更")) {
			String errmsg = null;
			id = (String) session.getAttribute("id");
			//数値が入力されていなかったら
			errmsg = err.numCheck(id, price);
			if (errmsg == null) {
				session.setAttribute("name", name);
				session.setAttribute("price", price);
				forward = "/web/kakunin.jsp";
			} else {
				//mod.jspの確認ボタンを押した際にエラーがあった場合
				session.setAttribute("name", name);
				session.setAttribute("price", price);
				//errmsgをAttributeにsetしてエラーをかえす
				request.setAttribute("errmsg", errmsg);
				forward = "/web/mod.jsp?no=2";
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
}