package pers.servlet.servlet.search;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> map = new HashMap<String,String>();
		map.put("apple", "苹果");
		map.put("banana", "香蕉");
		map.put("pear", "梨");
		String searchName = request.getParameter("name");
		if(map.containsKey(searchName)) {
			request.setAttribute("name", map.get(searchName));
			request.getRequestDispatcher("su.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("name", "没有找到对应的单词解释");
			response.sendRedirect("/servlet_advanced/fail.jsp");
		}
	}

}
