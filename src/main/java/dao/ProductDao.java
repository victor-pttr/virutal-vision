package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Product;

public class ProductDao {
	
	public void registerProduct(Product product) {

		String sql = "INSERT INTO PRODUTO VALUES (null,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn = null;

		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, product.getDescription());
			pStatement.setInt(2, product.getQuantity());
			pStatement.setDouble(3, product.getPrice());
			pStatement.setBoolean(4, product.isOnLine());
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<Product> SearchProductForDescription(String description) {
		String sql = "SELECT * FROM PRODUTO WHERE description LIKE '%" + description + "%'";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Product product = null;
		ArrayList<Product> products = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if (rs != null) {
				products = new ArrayList<Product>();
				while (rs.next()) {
					product = new Product();
					product.setIdProduct(rs.getInt("idProduct"));
					product.setDescription(rs.getString("description"));
					product.setQuantity(rs.getInt("quantity"));
					product.setPrice(rs.getDouble("price"));
					product.setOnLine(rs.getBoolean("onLine"));
					products.add(product);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return products;
	}

	public void ExcluirProduto(int idProduct) {
		String sql = "DELETE FROM PRODUTO WHERE idProduto = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idProduct);
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void UpdateProduct(Product product) {
		String sql = "UPDATE PRODUTO SET description = ?, quantity = ?, price = ?, onLine = ? WHERE idProduct = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, product.getDescription());
			pStatement.setInt(2, product.getQuantity());
			pStatement.setDouble(3, product.getPrice());
			pStatement.setBoolean(4, product.isOnLine());
			pStatement.setInt(5, product.getIdProduct());
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
