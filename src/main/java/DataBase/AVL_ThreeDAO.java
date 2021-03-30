package DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Modeles.AVL_Three;

@Dao
public interface AVL_ThreeDAO {
    @Insert
    void insertAll(AVL_Three... avl_threes);

    @Delete
    void delete(AVL_Three avl_three);

    @Update
    public void updateAvl(AVL_Three ... avl_threes);

    @Query("SELECT * FROM avl_three")
    List<AVL_Three> getAll();
}
