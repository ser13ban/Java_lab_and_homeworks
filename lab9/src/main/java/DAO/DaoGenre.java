package DAO;

import org.example.Database;
import org.example.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoGenre {

    Connection conn = Database.getConnection();

    public int addGenre(Genre genre) throws SQLException {

        String query = "INSERT INTO genres (name)"+" VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, genre.getName());
        ps.executeUpdate("use bd;");
        return ps.executeUpdate();
    }

    public Genre getGenre(int id) throws SQLException {
        String query = "select * from genres where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        Genre genre = new Genre();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            genre.setGenreId(rs.getInt("id"));
            genre.setName(rs.getString("name"));
        }
        if (check)
            return genre;
        else return null;
    }
}
