package com.jean.foodapi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jean.foodapi.connection.MyConnection;
import com.jean.foodapi.entity.Food;

public class FoodDAOImpl implements IFoodDAO {
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	@Override
	public List<Food> findAll() {
		String sql = "SELECT * FROM food";
		List<Food> foodList = new ArrayList<Food>();

		try {
			con = MyConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Food food = new Food();
				food.setFood_id(rs.getInt(1));
				food.setFood_name(rs.getString(2));
				food.setFood_price(rs.getDouble(3));
				food.setFood_stock(rs.getInt(4));
				foodList.add(food);
			}
			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase FoodClientImpl, método finAll");
			e.printStackTrace();
		}
		return foodList;
	}

	@Override
	public Food findById(Integer id) {
		String sql = "SELECT * FROM food WHERE food_id = " + id;
		Food food = new Food();

		try {
			con = MyConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			if (rs == null) {
				return null;
			} else {
				food.setFood_id(rs.getInt(1));
				food.setFood_name(rs.getString(2));
				food.setFood_price(rs.getDouble(3));
				food.setFood_stock(rs.getInt(4));
			}
			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase FoodClientImpl, método findById");
			e.printStackTrace();
		}

		return food;
	}

	@Override
	public void save(Food food) {
		String sql = "INSERT INTO food VALUES (null, '" + food.getFood_name() + "', " + food.getFood_price() + ", "
				+ food.getFood_stock() + ")";
		try {
			con = MyConnection.getConnection();
			stmt = con.createStatement();
			stmt.execute(sql);
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase FoodClientImpl, método save");
			e.printStackTrace();
		}
	}

	@Override
	public void update(Integer id, Food food) {
		String sql = "UPDATE food SET food_name='" + food.getFood_name() + "', food_price=" + food.getFood_price()
				+ ", food_stock=" + food.getFood_stock() + " WHERE food_id=" + id;
		try {
			con = MyConnection.getConnection();
			stmt = con.createStatement();
			stmt.execute(sql);
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase FoodClientImpl, método update");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM food WHERE food_id=" + id;
		try {
			con = MyConnection.getConnection();
			stmt = con.createStatement();
			stmt.execute(sql);
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase FoodClientImpl, método delete");
			e.printStackTrace();
		}
	}

}
