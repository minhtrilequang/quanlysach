package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bo.giohangbo;
import dao.chitiethoadondao;
import dao.hoadondao;

/**
 * Servlet implementation class thanhtoanController
 */
@WebServlet("/thanhtoan")
public class thanhtoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanhtoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		try {
			if (session.getAttribute("dn")==null) {
				response.sendRedirect("dangnhap.jsp");
			}else {
				hoadondao hddao=new hoadondao();
				khachhangbean kh=(khachhangbean) session.getAttribute("dn");
				hddao.ThemHD(kh.getMakh());
				long maxhd=hddao.maxhd();
				giohangbo ghbo=(giohangbo) session.getAttribute("gh");
				chitiethoadondao cthd=new chitiethoadondao();
				for (giohangbean i : ghbo.getDS()) {
					cthd.ThemCTHD(i.getMasach(), i.getSoluong(), maxhd);
					
				}
				session.removeAttribute("gh");
				response.sendRedirect("trangchu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
