package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class suaxoaController
 */
@WebServlet("/suaxoa")
public class suaxoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suaxoaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String ms=request.getParameter("masach");
		giohangbo ghbo=new giohangbo();
		
		if(ms.equals("hellokitty")) {
			ghbo.XoaALL();
		}else {
			try {
				ghbo=(giohangbo) session.getAttribute("gh");
				ghbo.Xoahang(ms);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String a[]=request.getParameterValues("boxsach");
		if(a!=null) {
			for (String i : a) {
				try {
					ghbo.Xoahang(i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		session.setAttribute("gh", ghbo);
		
		response.sendRedirect("giohang.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
