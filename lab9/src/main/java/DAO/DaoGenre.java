package DAO;

import Entityes.GenresEntity;
import org.example.Database;
import org.example.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoGenre {

    Connection conn = Database.getConnection();

    public int addGenre(GenresEntity genre) throws SQLException {

        String query = "INSERT INTO genres (name)"+" VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, genre.getName());
        ps.executeUpdate("use bd;");
        return ps.executeUpdate();
    }

    public GenresEntity getGenre(int id) throws SQLException {
        String query = "select * from genres where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        GenresEntity genre = new GenresEntity();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            genre.setId(Long.valueOf(rs.getInt("id")));
            genre.setName(rs.getString("name"));
        }
        if (check)
            return genre;
        else return null;
    }
}
