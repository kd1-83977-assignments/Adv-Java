package com.sunbeam.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements AutoCloseable {
	private Connection connection;

	public UserDaoImpl() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/election";
        String username = "root";
        String password = "Vedant@123";
        connection = DriverManager.getConnection(url, username, password);
	}

	
	@Override
	public void close() throws Exception {
		if (connection != null)
			connection.close();
	}

	public User findByEmail(String email) throws Exception {
        String query = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        }
        return null;
    }

    public User findById(int id) throws Exception {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        }
        return null;
    }

    public int save(User user) throws Exception {
        String query = "INSERT INTO users (first_name, last_name, email, password, dob, status, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setDate(5, Date.valueOf(user.getDob()));
            stmt.setBoolean(6, user.getStatus());
            stmt.setString(7, user.getRole());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
    }

    public int updateStatus(int userId, boolean voted) throws Exception {
        String query = "UPDATE users SET status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setBoolean(1, voted);
            stmt.setInt(2, userId);
            return stmt.executeUpdate();
        }
    }

    public int updatePassword(int userId, String newPassword) throws Exception {
        String query = "UPDATE users SET password = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newPassword);
            stmt.setInt(2, userId);
            return stmt.executeUpdate();
        }
    }

    public int deleteById(int id) throws Exception {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        }
    }

    public int update(User user) throws Exception {
        String query = "UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ?, dob = ?, status = ?, role = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setDate(5, Date.valueOf(user.getDob()));
            stmt.setBoolean(6, user.getStatus());
            stmt.setString(7, user.getRole());
            stmt.setInt(8, user.getId());
            return stmt.executeUpdate();
        }
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setDob(rs.getDate("dob").toLocalDate());
        user.setStatus(rs.getBoolean("status"));
        user.setRole(rs.getString("role"));
        return user;
    }

}
