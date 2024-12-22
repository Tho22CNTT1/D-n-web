package com.bkap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bkap.dao.FlowerDao;  

import com.bkap.entities.Flower;

public class FlowerImpl implements FlowerDao {
	private Connection con = null;

	public FlowerImpl() {
		this.con = DatabaseUtil.getConnect();
	}

	public List<Flower> getAll()  {
		List<Flower> data=new ArrayList<Flower>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Flowers");
			while (rs.next()) {
				Flower f=new Flower(rs.getString("flowerid"), rs.getString("flowername"), rs.getString("unit"), rs.getFloat("price"), rs.getFloat("priceold"), rs.getString("brief"), rs.getString("description"), rs.getString("picture"), rs.getDate("createdate"), rs.getBoolean("active"));
				data.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public Flower getById(String flowerid) {
		Flower flower=null;
		try {
			PreparedStatement pst = con.prepareStatement("select * from Flowers where flowerid=?");
			pst.setString(1, flowerid);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flower=new Flower(rs.getString("flowerid"), rs.getString("flowername"), rs.getString("unit"), rs.getFloat("price"), rs.getFloat("priceold"), rs.getString("brief"), rs.getString("description"), rs.getString("picture"), rs.getDate("createdate"), rs.getBoolean("active"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flower;
	}

	public boolean insert(Flower f) {
		try {
			PreparedStatement pst = con.prepareStatement("insert into flowers values(?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, f.getFlowerId());
			pst.setString(2, f.getFlowerName());
			pst.setString(3, f.getUnit());
			pst.setFloat(4, f.getPrice());
			pst.setFloat(5, f.getPriceOld());
			pst.setString(6,f.getBrief());
			pst.setString(7, f.getDescription());
			pst.setString(8, f.getPicture());
			pst.setDate(9, f.getCreateDate());
			pst.setBoolean(10, f.isActive());
			return pst.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Flower f) {
		try {
			PreparedStatement pst = con.prepareStatement("update flowers set flowername=?,unit=?,price=?,priceold=?,brief=?,description=?,picture=?,createdate=?,active=? where flowerid=?");
			pst.setString(10, f.getFlowerId());
			pst.setString(1, f.getFlowerName());
			pst.setString(2, f.getUnit());
			pst.setFloat(3, f.getPrice());
			pst.setFloat(4, f.getPriceOld());
			pst.setString(5,f.getBrief());
			pst.setString(6, f.getDescription());
			pst.setString(7, f.getPicture());
			pst.setDate(8, f.getCreateDate());
			pst.setBoolean(9, f.isActive());
			return pst.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String flowerId) {
		        try {
		            PreparedStatement pst = con.prepareStatement("DELETE FROM flowers WHERE flowerid = ?");
		            pst.setString(1, flowerId);
		            return pst.executeUpdate() > 0;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return false;
		    }

	
}