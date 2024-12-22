package com.bkap.servlets;

import java.io.IOException;
import java.util.List;
import com.bkap.dao.CategoryDAO;
import com.bkap.entities.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    private CategoryDAO categoryDAO = new CategoryDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "list":
                List<Category> categories = categoryDAO.getAllCategories();
                request.setAttribute("categories", categories);
                request.getRequestDispatcher("categorylist.jsp").forward(request, response);
                break;
            case "delete":
                int idToDelete = Integer.parseInt(request.getParameter("id"));
                categoryDAO.deleteCategory(idToDelete);
                response.sendRedirect("CategoryServlet");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                String name = request.getParameter("name");
                Integer parentId = request.getParameter("parentId").isEmpty() ? null : Integer.parseInt(request.getParameter("parentId"));
                categoryDAO.addCategory(name, parentId);
                response.sendRedirect("CategoryServlet");
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                String updatedName = request.getParameter("name");
                Integer updatedParentId = request.getParameter("parentId").isEmpty() ? null : Integer.parseInt(request.getParameter("parentId"));
                categoryDAO.updateCategory(id, updatedName, updatedParentId);
                response.sendRedirect("CategoryServlet");
                break;
        }
    }
}
