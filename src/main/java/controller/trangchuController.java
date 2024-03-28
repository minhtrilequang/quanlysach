package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bean.sachbean;
import dao.loaidao;
import dao.sachdao;

/**
 * Servlet implementation class trangchuController
 */
@WebServlet("/trangchu")
public class trangchuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trangchuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loaidao ldao=new loaidao();
		sachdao sdao=new sachdao();
		int endpage=0;
		ArrayList<loaibean> list=new ArrayList<loaibean>();
		try {
			list=ldao.getloai();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("dsloai", list);
		try {
			int count=sdao.getTongSLSach();
			endpage=count/8;
			if(count%8!=0) {
				endpage++;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("endpage",endpage);
		ArrayList<sachbean> list1 = null;
		try {
			int index=1;
			if(request.getParameter("index")!=null) {
				index=Integer.parseInt(request.getParameter("index")); 
			}
			list1=sdao.getSach(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("dssach", list1);
		request.getRequestDispatcher("trangchu.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
