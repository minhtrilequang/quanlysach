package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.loaibean;
import bo.giohangbo;
import dao.loaidao;

/**
 * Servlet implementation class giohangController
 */
@WebServlet("/giohang")
public class giohangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//nap loai sach
		loaidao ldao=new loaidao();
		ArrayList<loaibean> list=new ArrayList<loaibean>();
		try {
			list=ldao.getloai();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("dsloai", list);
		
		//them 1 mat hang
		String masach=request.getParameter("ms");
		String tensach=request.getParameter("ts");
		String tacgia=request.getParameter("tg");
		long gia=Long.parseLong(request.getParameter("gia")); 
		String anh=request.getParameter("anh");
		giohangbo ghbo=null;
		if (session.getAttribute("gh")==null) {
			ghbo=new giohangbo();
			session.setAttribute("gh", ghbo);
		}
		ghbo=(giohangbo)session.getAttribute("gh");
		try {
			ghbo.Themhang(masach, tensach, tacgia, (long)1,gia, anh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("gh", ghbo);
		
		
		
		request.getRequestDispatcher("giohang.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
