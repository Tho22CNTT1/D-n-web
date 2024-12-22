package com.bkap.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bkap.entities.Category;

public class CategoryDAO {

    // Lấy danh sách tất cả danh mục
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM Categories";
        try (Connection conn = DatabaseUtil.getConnect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                categories.add(new Category(
                    rs.getInt("categoryid"),
                    rs.getString("categoryname"),
                    rs.getObject("parentid") != null ? rs.getInt("parentid") : null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    // Thêm mới danh mục
    public boolean addCategory(String categoryName, Integer parentId) {
        String query = "INSERT INTO Categories (categoryname, parentid) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, categoryName);
            if (parentId != null) {
                ps.setInt(2, parentId);
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật danh mục
    public boolean updateCategory(int categoryId, String categoryName, Integer parentId) {
        String query = "UPDATE Categories SET categoryname = ?, parentid = ? WHERE categoryid = ?";
        try (Connection conn = DatabaseUtil.getConnect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, categoryName);
            if (parentId != null) {
                ps.setInt(2, parentId);
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setInt(3, categoryId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa danh mục
    public boolean deleteCategory(int categoryId) {
        String query = "DELETE FROM Categories WHERE categoryid = ?";
        try (Connection conn = DatabaseUtil.getConnect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, categoryId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách danh mục con theo parentId
    public List<Category> getSubCategories(int parentId) {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM Categories WHERE parentid = ?";
        try (Connection conn = DatabaseUtil.getConnect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, parentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(new Category(
                    rs.getInt("categoryid"),
                    rs.getString("categoryname"),
                    rs.getObject("parentid") != null ? rs.getInt("parentid") : null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
