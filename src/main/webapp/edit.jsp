<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Mới Hoa</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        h3 {
            text-align: center;
            color: #4CAF50;
        }

        table {
            width: 50%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        td {
            padding: 10px;
            text-align: left;
            font-size: 14px;
        }

        input[type="text"], textarea {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        textarea {
            resize: vertical;
            height: 100px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin: 10px 0;
        }

        button:hover {
            background-color: #45a049;
        }

        input[type="checkbox"] {
            transform: scale(1.5);
            margin-top: 5px;
        }

        label {
            font-size: 16px;
        }

        .form-container {
            max-width: 800px;
            margin: 0 auto;
        }

        .table-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h3>Sửa hoa</h3>
        <div class="table-container">
            <form action="FlowerServlet?action=update" method="post">
                <table>
                    <tr>
                        <td>Mã hoa</td>
                        <td><input type="text" name="flowerid" value="${flower.flowerId}" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>Tên hoa</td>
                        <td><input type="text" name="flowername" value="${flower.flowerName}" /></td>
                    </tr>
                    <tr>
                        <td>Đơn vị tính</td>
                        <td><input type="text" name="unit" value="${flower.unit}" /></td>
                    </tr>
                    <tr>
                        <td>Giá</td>
                        <td><input type="text" name="price" value="${flower.price}" /></td>
                    </tr>
                    <tr>
                        <td>Giá cũ</td>
                        <td><input type="text" name="priceold" value="${flower.priceOld}" /></td>
                    </tr>
                    <tr>
                        <td>Mô tả ngắn</td>
                        <td><textarea name="brief">${flower.brief}  </textarea></td>
                    </tr>
                    <tr>
                        <td>Mô tả đầy đủ</td>
                        <td><textarea name="description">${flower.description}  </textarea></td>
                    </tr>
                    <tr>
                        <td>Ảnh</td>
                        <td><input type="text" name="picture" value="${flower.picture}" /></td>
                    </tr>
                    <tr>
                        <td>Tình trạng</td>
                        <td>
                            <c:if test="${flower.isActive()==true}">
                                <input type="checkbox" name="active" checked="checked" />
                            </c:if> 
                            <c:if test="${flower.isActive()==false}">
                                <input type="checkbox" name="active" />
                            </c:if> Còn hàng
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="submit">Lưu</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
