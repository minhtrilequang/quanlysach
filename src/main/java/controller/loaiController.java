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
 * Servlet implementation class loaiController
 */
@WebServlet("/loai")
public class loaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sachdao sdao=new sachdao();
		loaidao ldao=new loaidao();
		int endpage=0;
		String maloai=request.getParameter("ml");
		ArrayList<loaibean> list1=new ArrayList<loaibean>();
		try {
			list1=ldao.getloai();
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("dsloai", list1);
		try {
			int count=sdao.getTongSLSachByLoai(maloai);
			endpage=count/8;
			if(endpage%8!=0) {
				endpage++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("endpage", endpage);
		request.setAttribute("ml", maloai);
		ArrayList<sachbean> list=new ArrayList<sachbean>();
		try {
			int index=1;
			if(request.getParameter("index")!=null) {
				index=Integer.parseInt(request.getParameter("index")); 
			}
			list=sdao.getSachByLoai(index, maloai);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		request.setAttribute("dssach", list);
		request.getRequestDispatcher("sachtheoloai.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
