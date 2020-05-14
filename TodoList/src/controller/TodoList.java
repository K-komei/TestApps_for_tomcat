package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoList
 */
@WebServlet("/TodoList")
public class TodoList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//JSPに送信する値を設定
		 String name = (String) request.getAttribute("userName");

		if (name == null || "".equals(name)) {
	        request.setAttribute("userName", "Guest");
	    }


         //request.setAttribute("foo","bar");

		//index.jspを表示

		String view = "/WEB-INF/view/index.jsp";
 	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
 	    dispatcher.forward(request, response);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    // 文字コードの指定
	    request.setCharacterEncoding("utf-8");
	    // formから値を取得
	    String name = request.getParameter("name");

	    request.setAttribute("userName", name);

	    doGet(request, response);


	}

}
