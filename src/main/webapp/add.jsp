<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Mới Hoa</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        h3 {
            text-align: center;
            color: #4CAF50;
            margin-top: 20px;
        }

        table {
            width: 60%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        td {
            padding: 10px;
            font-size: 14px;
        }

        label {
            font-weight: bold;
            font-size: 16px;
        }

        input[type="text"], input[type="number"], textarea {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        textarea {
            resize: vertical;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin: 20px 0;
        }

        button:hover {
            background-color: #45a049;
        }

        input[type="checkbox"] {
            transform: scale(1.5);
            margin-top: 5px;
        }

        td[colspan="2"] {
            text-align: center;
        }

        .form-container {
            max-width: 800px;
            margin: 0 auto;
        }

        .table-container {
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
        }

    </style>
</head>
<body>
    <div class="form-container">
        <h3>Thêm Mới Hoa</h3>
        <div class="table-container">
            <form action="FlowerServlet?action=insert" method="post">
                <table>
                    <tr>
                        <td><label for="flowerid">Mã hoa</label></td>
                        <td><input type="text" id="flowerid" name="flowerid" required placeholder="Nhập mã hoa"></td>
                    </tr>
                    <tr>
                        <td><label for="flowername">Tên hoa</label></td>
                        <td><input type="text" id="flowername" name="flowername" required placeholder="Nhập tên hoa"></td>
                    </tr>
                    <tr>
                        <td><label for="unit">Đơn vị tính</label></td>
                        <td><input type="text" id="unit" name="unit" required placeholder="Nhập đơn vị tính"></td>
                    </tr>
                    <tr>
                        <td><label for="price">Giá</label></td>
                        <td><input type="number" id="price" name="price" required value="0" step="0.01" placeholder="Nhập giá hoa"></td>
                    </tr>
                    <tr>
                        <td><label for="priceold">Giá cũ</label></td>
                        <td><input type="number" id="priceold" name="priceold" value="0" step="0.01" placeholder="Nhập giá cũ (nếu có)"></td>
                    </tr>
                    <tr>
                        <td><label for="brief">Mô tả ngắn</label></td>
                        <td><textarea id="brief" name="brief" rows="3" placeholder="Nhập mô tả ngắn"></textarea></td>
                    </tr>
                    <tr>
                        <td><label for="description">Mô tả đầy đủ</label></td>
                        <td><textarea id="description" name="description" rows="5" placeholder="Nhập mô tả đầy đủ"></textarea></td>
                    </tr>
                    <tr>
                        <td><label for="picture">Ảnh</label></td>
                        <td><input type="text" id="picture" name="picture" placeholder="Nhập đường dẫn ảnh"></td>
                    </tr>
                    <tr>
                        <td><label for="active">Tình trạng</label></td>
                        <td>
                            <input type="checkbox" id="active" name="active" checked>
                            <label for="active">Còn hàng</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit">Lưu</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
