package DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import net.ecodesi.randomagic.Deck;

import Modeles.AVL_Three;
import Modeles.Node;
import Modeles.Utilisateur;

@Database(entities = {Deck.class, Utilisateur.class, AVL_Three.class, Node.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DeckDAO deckDAO();
    public abstract UtilisateurDAO utilisateurDAO();
    public abstract AVL_ThreeDAO avl_threeDAO();
    public abstract  NodeDAO nodeDAO();

}
