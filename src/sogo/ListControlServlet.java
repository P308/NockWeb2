package sogo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListControlServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	//	商品登録から確認画面へ遷移する
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charaset = UTF-8");

		String forward = null;
		//一覧を表示するメソッドを実行
		ShohinDao dao = new ShohinDao();
		request.setAttribute("list", dao.selectAll());

		//もしも削除変更ボタンが押された場合、エラーメッセージがあればセットする
		if (request.getParameter("no").equals("2")) {
			request.setAttribute("errmsg", request.getAttribute("errmsg"));
		}
		forward = "/web/ichiran.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
}