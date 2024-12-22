<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách danh mục</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: #fff;
            padding: 10px;
            text-align: left;
        }
        td {
            padding: 10px;
            text-align: left;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .actions a {
            margin-right: 10px;
        }
        .add-button {
            display: block;
            width: fit-content;
            margin: 10px auto;
            background-color: #28a745;
            color: white;
            padding: 10px 15px;
            text-align: center;
            border-radius: 5px;
            text-decoration: none;
        }
        .add-button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h1>Danh sách danh mục</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Tên danh mục</th>
            <th>Danh mục cha</th>
            <th>Hành động</th>
        </tr>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.categoryId}</td>
                <td>${category.categoryName}</td>
                <td>${category.parentId == null ? "Không có" : category.parentId}</td>
                <td class="actions">
                    <a href="editcategory.jsp?id=${category.categoryId}">Sửa</a>
                    <a href="CategoryServlet?action=delete&id=${category.categoryId}" style="color: red;">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="addcategory.jsp" class="add-button">Thêm mới danh mục</a>
</body>
</html>
