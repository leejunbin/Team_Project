package SW.review_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SW_dao.AsWriteDao;
import SW_vo.AsWriteVo;

@WebServlet("/SW_review/Rupdate")
public class R_UpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int asnum=Integer.parseInt(req.getParameter("asnum"));
		AsWriteDao dao=AsWriteDao.getInstance();
		AsWriteVo vo=dao.getInfo(asnum);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/SW_review/R_Update.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String asimg=req.getParameter("asimg");
		String astitle=req.getParameter("astitle");
		String ascontent=req.getParameter("ascontent");
		String mid=req.getParameter("mid");
		String gocode=req.getParameter("gocode");
		int purnum=Integer.parseInt(req.getParameter("purnum"));
		int ashit=Integer.parseInt(req.getParameter("ashit"));
		AsWriteVo vo=new AsWriteVo(0, asimg, astitle, ascontent, mid, gocode, purnum, ashit);
		AsWriteDao dao=AsWriteDao.getInstance();
		int n=dao.update(vo);
		if(n>0){
			resp.sendRedirect(req.getContextPath()+"/SW_review/Rlist");
		}else {
			req.setAttribute("msg", "fail");
			req.setAttribute("top", "/pro/header.jsp");
			req.setAttribute("main","/SW_pro/result.jsp");
			req.setAttribute("bottom", "/pro/footer.jsp");
			req.getRequestDispatcher("/pro/product.jsp").forward(req, resp);
		}
	}
}
