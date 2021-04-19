package DAO;

import org.example.Actor;
import org.example.Database;
import org.example.Director;
import org.example.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoMovie {

    Connection conn = Database.getConnection();

    public int addMovie(Movie movie) throws SQLException {

        String query = "INSERT INTO movies (title, release_date, duration, score)" + " VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, movie.getTitle());
        ps.setDate(2, movie.getRelease_date());
        ps.setInt(3, movie.getDuration());
        ps.setDouble(4, movie.getScore());
        ps.executeUpdate("use bd;");
        return ps.executeUpdate();
    }

    public Movie getMovie(int id) throws SQLException {
        String query = "select * from movies where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        Movie movie = new Movie();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            movie.setId(rs.getInt("id"));
            movie.setTitle(rs.getString("title"));
            movie.setRelease_date(rs.getDate("release_date"));
            movie.setDuration(rs.getInt("duration"));
            movie.setScore(rs.getDouble("score"));
        }
        if (check)
            return movie;
        else return null;
    }

    public List<String> getCast(String title) throws SQLException {
        System.out.print("The cast of " + title + " is: ");
        String query = "select actor_name from movies join cast on movies.id = id_movie join actors on actors.id = id_actor where title = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, title);
        ps.executeUpdate("use bd;");
        ResultSet rs = ps.executeQuery();
        List<String> cast = new ArrayList<>();
        while (rs.next()) {
            Actor actor = new Actor();
            actor.setStageName(rs.getString("actor_name"));
            //cast.add(actor.stageName);
        }
        return cast;
    }

    public List<String> getScreeplay(String title) throws SQLException {
        System.out.print("The director(s) of " + title + " is: ");
        String query = "select director_name from movies join screenplay on movies.id = id_movie join directors on directors.id = id_director where title = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, title);
        ps.executeUpdate("use bd;");
        ResultSet rs = ps.executeQuery();
        List<String> screenplay = new ArrayList<>();
        while (rs.next()) {
            Director director = new Director();
            director.setName(rs.getString("director_name"));
            //screenplay.add(director.name);
        }
        return screenplay;
    }
}


