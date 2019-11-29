package SH.Info_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SH.Info_Dao.InfoDao;
import SH.Info_Vo.Info_Vo;

@WebServlet("/info/update")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//일단 상세글에서 받고
		int infonum=Integer.parseInt(req.getParameter("infonum"));
		InfoDao dao=new InfoDao();
		Info_Vo vo=dao.detail(infonum);
		req.setAttribute("vo", vo);
		req.setAttribute("top", "/pro/header.jsp");
		req.setAttribute("main",	"/SH.info/infoupdate.jsp");
		req.setAttribute("bottom", "/pro/footer.jsp");
		req.getRequestDispatcher("/pro/product.jsp").forward(req, resp);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int infonum=Integer.parseInt(req.getParameter("infonum"));
		String infotitle=req.getParameter("infotitle");
		String infocontent=req.getParameter("infocontent");
		InfoDao dao=new InfoDao();
		Info_Vo vo=new Info_Vo(infonum,infotitle,infocontent,null);
		int n=dao.update(vo);
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/info/list");
		}else {
			req.setAttribute("code", "fail");
			
			req.getRequestDispatcher("/SH.info/inforesult.jsp").forward(req, resp);
		}
		
	}
}
