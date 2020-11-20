package pers.servlet.servlet.pattern;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pattern/*")
public class PatternServelt extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����ȫ��
		ServletContext context = req.getServletContext();
		context.setAttribute("test", "test111");
		String contextTest =  (String)context.getAttribute("test");
		System.out.println(contextTest);
		context.getInitParameter("test");//��ȡ��ʼ������ ��ʼ���洢Ϊweb.xml
		// ��ѯ������Ϣ
		String url = req.getRequestURI().toString();
		System.out.println(url);
		String id = url.substring(url.lastIndexOf("/") + 1);
		Integer eid = Integer.parseInt(id);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(id);
		if (eid==1) {
			out.println("����");
		} else {
			out.println("����");
		}
	}
}