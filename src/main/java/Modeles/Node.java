package Modeles;

import android.database.Cursor;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;

import net.ecodesi.randomagic.Deck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>Un Node est la structure de donnée contenue dans une branche d'un AVL</b>
 *
 * <p>
 *  Ce Node représente les stats du deck lié contre le deck dont l'id est égal a la clé du noeud.</br>
 *  Ci-après nous référerons du deck auquel est lié l'<span class='type'>AVL_Three</span> par <span class=name>A</span> et le deck dont l'id est représenté par <strong>key</strong> sera nommé <span class='name'>B</span>.</br>
 *  Un Node est caractérisé de la manière suivante:
 * </p>
 * <ul>
 *     <li>
 *         Une clé <strong>key</strong> de type <span class='type'>Entier</span><br />
 *         (représente l'id de B contre lequel à joué A)
 *     </li>
 *     <li>
 *         Un champ <strong>stats</strong> de type <span class='type'>Stats</span>
 *     </li>
 * </ul>
 * @see Stats
 * @see AVL_Three
 */
@Entity(primaryKeys = {"key"})
public class Node {
    @ColumnInfo(name = "key")
    private int key; //l'id du deck

    @Embedded private Stats stats;

    /**
     * <b>le constructeur a vide de Node</b>
     *
     * <ul>
     *     <li>
     *         <strong>key</strong> vaut <span class='value'>-1</span>
     *     </li>
     *     <li>
     *          <strong>stats</strong> est initialisé à vide
     *      </li>
     * </ul>
     */
    public Node() {
        this.key = -1;
        this.stats = new Stats();
    }
    /**
     * <b>le constructeur de Node à partir d'un deck</b>
     *
     * @param deck
     * <ul>
     *     <li>
     *         <strong>key</strong> vaut <span class='value'>l'id du deck</span>
     *     </li>
     *     <li>
     *          <strong>stats</strong> est initialisé avec 1 partie et 1 victoire si le paramètre victoire est à <span class='value'>true</span> et <span class='value'>0</span> sinon
     *      </li>
     * </ul>
     * @see Deck
     */
    public Node(Deck deck,boolean victoire) {
        this.key = deck.getId_deck();
        if(victoire)
        {
            this.stats = new Stats(1,1);
        }else{
            this.stats = new Stats(1,0);
        }
    }

    /**
     * <b>L'accesseur de la clé du Node</b>
     *
     * @return key
     */
    public int getKey() {
        return key;
    }

    /**
     * <b>Le mutateur de la clé du Node</b>
     *
     * @param key int
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * <b>L'accesseur des stats du deck</b>
     *
     * @return stats Stats
     */
    public Stats getStats() {
        return this.stats;
    }
    public void setStats(Stats statsToLink) {
        this.stats = statsToLink;
    }

    /**
     * <b>L'affichage du Node</b>
     *
     * <p>
     *     On se contente d'afficher l'id du deck puis on appelle la fonction d'affichage de Stats
     * </p>
     * @see Stats#afficher()
     */
    public void afficher()
    {
        System.out.print(this.getKey()+"  ");
        this.getStats().afficher();
        System.out.println("");
    }
    private Node cursorToNode(Cursor c, boolean one)
    {
        if (c.getCount() == 0)
            return null;

        if(one == true)
            c.moveToFirst();

        Node nodeBdd = new Node();

        nodeBdd.setKey(c.getInt(0));


        if(one == true)
            c.close();

        return nodeBdd;
    }
}
