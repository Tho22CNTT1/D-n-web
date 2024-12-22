package com.bkap.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bkap.dao.FlowerDao;
import com.bkap.dao.FlowerImpl;
import com.bkap.entities.Flower;
/**
 * Servlet implementation class FlowerServlet
 */
@WebServlet("/FlowerServlet")
public class FlowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlowerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp"); 
            return;
        }

        request.setCharacterEncoding("UTF8");
        FlowerDao flowerDao = new FlowerImpl();
        String action = request.getParameter("action");

        if (action == null) {
            request.setAttribute("flowers", flowerDao.getAll());
            request.getRequestDispatcher("index.jsp?page=flowertables").forward(request, response);
        } else if (action.equals("flowers")) {
            request.setAttribute("flowers", flowerDao.getAll());
            request.getRequestDispatcher("index.jsp?page=flowercells").forward(request, response);
        } else if (action.equals("detail") || action.equals("edit")) {
            String flowerid = request.getParameter("flowerid");
            request.setAttribute("flower", flowerDao.getById(flowerid));
            if (action.equals("detail"))
                request.getRequestDispatcher("index.jsp?page=flowerdetails").forward(request, response);
            else
                request.getRequestDispatcher("index.jsp?page=edit").forward(request, response);
        } else if (action.equals("delete")) {
            String flowerid = request.getParameter("flowerid");
            if (flowerDao.delete(flowerid))
                request.setAttribute("msg", "Xóa thành công");
            else
                request.setAttribute("msg", "Xóa không thành công");
            request.setAttribute("flowers", flowerDao.getAll());
            request.getRequestDispatcher("index.jsp?page=flowertables").forward(request, response);
        } else if (action.equals("add")) {
     
            request.getRequestDispatcher("index.jsp?page=add").forward(request, response);
        } else if (action.equals("insert") || action.equals("update")) {
            String flowerid = request.getParameter("flowerid");
            String flowername = request.getParameter("flowername");
            String unit = request.getParameter("unit");
            Float price = Float.parseFloat(request.getParameter("price"));
            Float priceold = Float.parseFloat(request.getParameter("priceold"));
            String brief = request.getParameter("brief");
            String description = request.getParameter("description");
            String picture = request.getParameter("picture");
            boolean active = request.getParameter("active") != null;
            Date createdate = Date.valueOf(LocalDate.now());

            Flower f = new Flower(flowerid, flowername, unit, price, priceold, brief, description, picture, createdate, active);
            if (action.equals("insert")) {
                if (flowerDao.insert(f))
                    request.setAttribute("msg", "Thêm thành công");
                else
                    request.setAttribute("msg", "Thêm không thành công");
            
                request.getRequestDispatcher("index.jsp?page=add").forward(request, response);
            } else {
                if (flowerDao.update(f))
                    request.setAttribute("msg", "Sửa thành công");
                else
                    request.setAttribute("msg", "Sửa không thành công");
                request.setAttribute("flowers", flowerDao.getAll());
                request.getRequestDispatcher("index.jsp?page=flowertables").forward(request, response);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("CategoryServlet");
        dispatcher.forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}