package sogo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SyainKyuyoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charaset = UTF-8");

		UserDao dao = new UserDao();
		request.setAttribute("list", dao.selectSalaly());

		//login.jspへ画面遷移する記述
		RequestDispatcher rd = request.getRequestDispatcher("web/syainn_kyuuyo.jsp");
		rd.forward(request,response);
	}
}