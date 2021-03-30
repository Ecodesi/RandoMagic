package DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

import Modeles.Utilisateur;
@Dao
public interface UtilisateurDAO {
    @Insert
    void insertAll(Utilisateur... utilisateurs);

    @Delete
    void delete(Utilisateur utilisateur);

    @Update
    public void updateUtilisateur(Utilisateur ... utilisateurs);

    @Query("SELECT * FROM utilisateur")
    List<Utilisateur> getAll();
}
