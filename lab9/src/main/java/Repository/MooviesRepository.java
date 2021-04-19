package Repository;

import DAO.DaoMovie;
import Entityes.MoviesEntity;
import org.example.Database;

import java.sql.Connection;

public class MooviesRepository {
    Connection conn = Database.getConnection();

    public void create(MoviesEntity movie){

    }

    public MoviesEntity findById(int id){
        DaoMovie daoMovie = new DaoMovie();
        MoviesEntity x = new MoviesEntity();
        try{
            x = daoMovie.getMovie(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return x;
    }
    public MoviesEntity findByName(int id){
        MoviesEntity x= new MoviesEntity();
        return x;
    }
}
