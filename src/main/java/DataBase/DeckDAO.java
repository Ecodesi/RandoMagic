package DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import net.ecodesi.randomagic.Deck;

import java.util.List;

@Dao
public interface DeckDAO {
    @Insert
    void insertAll(Deck ... decks);

    @Delete
    void delete(Deck deck);

    @Update
    public void updateDeck(Deck ... decks);

    @Query("SELECT * FROM deck")
    public List<Deck> getAll();

    @Query("SELECT deckName FROM deck")
    public List<String> getAllDeckName();
}
