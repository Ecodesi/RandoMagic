package DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Modeles.Node;

@Dao
public interface NodeDAO {
    @Insert
    void insertAll(Node... nodes);

    @Delete
    void delete(Node node);

    @Update
    public void updateNode(Node ... nodes);

    @Query("SELECT * FROM node")
    List<Node> getAll();
}
