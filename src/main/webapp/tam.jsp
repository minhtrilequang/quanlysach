package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import bo.giohangbo;

/**
 * Servlet implementation class xoaController
 */
public class xoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		giohangbo ghbo = (giohangbo) session.getAttribute("gh");
		String ms = request.getParameter("ms");
		String ms1 = request.getParameter("ms1");
		String tru = request.getParameter("tru");
		String cong = request.getParameter("cong");
		String[] xoadc = request.getParameterValues("xoadc");
		try {
			if (ms != null) {
				ghbo.Xoahang(ms);
			}
			String xoaall = request.getParameter("xoa");
			if (xoaall != null) {
				session.removeAttribute("gh");
			}
			if (tru != null) {
				ghbo.tru(ms1);
			}
			if (cong != null) {
				ghbo.Cong(ms1);
			}
			//xoa da chon
			String[] a = request.getParameterValues("deleteSelected");
			if(a != null){
				for (String deleteSelected : a) {
					ghbo.Xoahang(deleteSelected);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("htgioController");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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