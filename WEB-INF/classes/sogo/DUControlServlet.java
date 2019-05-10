package sogo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ShohinBean;

public class DUControlServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charaset = UTF-8");
		//セッションの開始
		HttpSession session = request.getSession(true);
		//とりあえず遷移先をnullで指定
		String forward = null;
		//ichiran.jspでradioボタンから送信されたidを所得
		String id = request.getParameter("fruits");
		//Errcheckをインスタンス化
		Errcheck err = new Errcheck();
		//Errcheckを実行してメッセージを受け取る
		String errmsg = err.notExistId(id);
		//もしも、きちんと選択された場合に遷移する処理を実行
		if (errmsg == null) {
			//daoをインスタンス化
			ShohinDao dao = new ShohinDao();
			//idから中身を所得
			ArrayList<ShohinBean> list = dao.jouken(id);
			//sessionに値をセット
			session.setAttribute("id", list.get(0).getId());
			session.setAttribute("name", list.get(0).getName());
			session.setAttribute("price", list.get(0).getPrice());
			//削除ボタンが押された時のforward先を決定
			if (request.getParameter("submit").contentEquals("削除")) {
				forward = "/web/kakunin.jsp";
			//変更ボタンが押された時の遷移先を指定
			} else {
				forward = "/web/mod.jsp?no=2";
			}
		//エラーメッセージをセットしてichiran.jspに返す
		} else {
			request.setAttribute("errmsg", errmsg);
			forward = "/list?no=2";
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);

	}
}