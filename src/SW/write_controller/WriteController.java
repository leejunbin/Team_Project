package SW.write_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SH.Inventory_Dao.InventoryDao;
import SH.Inventory_Vo.InventoryVo;
import SW_dao.WriteDao;
import SW_vo.WriteVo;

@WebServlet("/SW_write/write")
public class WriteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("top", "/pro/header.jsp");
		req.setAttribute("main","/SW_write/write.jsp");
		req.setAttribute("bottom", "/pro/footer.jsp");
		req.getRequestDispatcher("/pro/product.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String mid=req.getParameter("mid");
		String title=req.getParameter("title");
		String writecontent=req.getParameter("writecontent");
		String gocode=req.getParameter("gocode"); //상품코드 받음

		System.out.println(gocode);
		InventoryDao dao1=new InventoryDao();
		InventoryVo ivo=dao1.getInfo(gocode);
		
		WriteVo vo=new WriteVo(0, mid, gocode, title, writecontent, null, null);
		WriteDao dao=WriteDao.getInstance();
		int n=dao.insert(vo);
		if(n>0){
			resp.sendRedirect(req.getContextPath()+"/SW_write/Wlist");
		}else {
			req.setAttribute("msg", "fail");
			req.setAttribute("top", "/pro/header.jsp");
			req.setAttribute("main","/SW_pro/result.jsp");
			req.setAttribute("bottom", "/pro/footer.jsp");
			req.getRequestDispatcher("/pro/product.jsp").forward(req, resp);
		}
		req.setAttribute("ivo",ivo );
	}
}
