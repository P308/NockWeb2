package sogo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUserServletConf extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * login.jspのフォームから送られてきたidとpassを受け取り、sqlに保存されているログイン情報との整合性を確かめる
	 *  正しければ、name情報と部署情報のAttributeを行う。
	 *  間違っていれば、エラーメッセージとともに再度ログイン画面に戻す。
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charaset = UTF-8");
		String id = request.getParameter("id");
		String pass =request.getParameter("pass");

		UserDao dao = new UserDao();

		String forward = null;

		request.setAttribute("login_name", dao.getUser(id, pass));
		request.setAttribute("login_dep", dao.getDept(id, pass));
		String requestedId = (String) request.getAttribute("login_name");
		if (requestedId != null) {
			/**
			 * 遷移先をmenu.jspに定める
			 */
			forward = "web/menu.jsp";
		} else {
			forward = "web/login.jsp";
			String message = "IDもしくはPASSが間違っています";
			request.setAttribute("errmsg", message);
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
}
