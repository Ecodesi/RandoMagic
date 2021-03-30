package DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Modeles.Stats;


@Dao
public interface StatsDAO {
    @Insert
    void insertAll(Stats... statss);

    @Delete
    void delete(Stats stats);

    @Update
    public void updateStats(Stats ... statss);

    @Query("SELECT * FROM stats")
    List<Stats> getAll();
}
