package DAO;

import org.example.Actor;
import org.example.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoActor {
    Connection conn = Database.getConnection();

    public int addActor(Actor actor) throws SQLException {

        String query = "INSERT INTO actors (actor_name, country, date_of_birth)"+" VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, actor.getStageName());
        ps.setString(2, actor.getCountry());
        ps.setString(3, actor.getDateOfBirth());
        ps.executeUpdate("use bd;");
        return ps.executeUpdate();
    }
}
