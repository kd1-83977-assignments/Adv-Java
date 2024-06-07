package com.sunbeam.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entity.Student;
import com.sunbeam.utils.DbUtil;

public class CandidateDaoImpl implements AutoCloseable {
	private Connection connection;

	public CandidateDaoImpl() throws SQLException {
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

	public List<Candidate> findAll() throws Exception {
        List<Candidate> candidates = new ArrayList<>();
        String query = "SELECT * FROM candidates";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                candidates.add(extractCandidateFromResultSet(rs));
            }
        }
        return candidates;
    }

    public List<Candidate> findByParty(String party) throws Exception {
        List<Candidate> candidates = new ArrayList<>();
        String query = "SELECT * FROM candidates WHERE party = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, party);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                candidates.add(extractCandidateFromResultSet(rs));
            }
        }
        return candidates;
    }

    public List<Candidate> findAllOrderByVotesDesc() throws Exception {
        List<Candidate> candidates = new ArrayList<>();
        String query = "SELECT * FROM candidates ORDER BY votes DESC";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                candidates.add(extractCandidateFromResultSet(rs));
            }
        }
        return candidates;
    }

    public int save(Candidate c) throws Exception {
        String query = "INSERT INTO candidates (name, party, votes) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getParty());
            stmt.setInt(3, c.getVotes());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating candidate failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating candidate failed, no ID obtained.");
                }
            }
        }
    }

    public int deleteById(int id) throws Exception {
        String query = "DELETE FROM candidates WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        }
    }

    public int update(Candidate c) throws Exception {
        String query = "UPDATE candidates SET name = ?, party = ?, votes = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getParty());
            stmt.setInt(3, c.getVotes());
            stmt.setInt(4, c.getId());
            return stmt.executeUpdate();
        }
    }

    public Candidate findById(int id) throws Exception {
        String query = "SELECT * FROM candidates WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractCandidateFromResultSet(rs);
            }
        }
        return null;
    }

    public int incrementVotes(int id) throws Exception {
        String query = "UPDATE candidates SET votes = votes + 1 WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        }
    }

    private Candidate extractCandidateFromResultSet(ResultSet rs) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(rs.getInt("id"));
        candidate.setName(rs.getString("name"));
        candidate.setParty(rs.getString("party"));
        candidate.setVotes(rs.getInt("votes"));
        return candidate;
    }

}
