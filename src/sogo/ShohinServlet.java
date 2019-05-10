package sogo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShohinServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charaset = UTF-8");
		HttpSession session = request.getSession(true);

		ShohinDao dao = new ShohinDao();

		String forward = null;


		//kakunin.jspで登録ボタンが押された時
		if(request.getParameter("submit").equals("登録")){

			String id = (String) session.getAttribute("id");
			String name = (String) session.getAttribute("name");
			int price = Integer.parseInt((String)session.getAttribute("price"));

			request.setAttribute("update", "登録が完了しました");
			dao.insert(id, name, price);

			forward = "/web/mod.jsp?no=4";

		}

		if(request.getParameter("submit").equals("削除")) {
			request.setAttribute("update","削除が完了しました");
			String id = (String) session.getAttribute("id");

//			削除メソッドを呼び出して実行
			dao.delete(id);

			forward="/list?no=2";
		}

		if(request.getParameter("submit").equals("変更")) {

			String id = (String) session.getAttribute("id");
			String name = (String) session.getAttribute("name");
			int price = Integer.parseInt((String)session.getAttribute("price"));

			request.setAttribute("update","変更が完了しました");
			dao.update(id, name, price);

			forward="/list?no=2";
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request,response);
	}
}