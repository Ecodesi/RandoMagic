package Modeles;

import android.database.Cursor;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

import net.ecodesi.randomagic.Deck;

/**
 * <b>L'objet Stats représente les statistique d'un deck contre un autre</b>
 *
 * <p>
 *     Cela se résume en dexu valeurs:
 * </p>
 * <ul>
 *     <li>
 *         Un nombre de victoires <strong>nbVictoires</strong> de type <span class=type>Entier</span>
 *     </li>
 *     <li>
 *         Un nombre de parties <strong>nbParties</strong> de type <span class=type>Entier</span>
 *     </li>
 * </ul>
 */
@Entity
public class Stats {

    @Nullable
    @ColumnInfo(name = "nbVictoires")
    private int nbVictoires;

    @Nullable
    @ColumnInfo(name = "nbParties")
    private int nbParties;

    /**
     * <b>Le constructeur de Stats à vide</b>
     *
     * <li>
     *     <strong>nbVictoires</strong> vaut <span class=value>0</span>
     * </li>
     * <li>
     *     <strong>nbParties</strong> vaut <span class=value>0</span>
     * </li>
     */
    @Ignore
    public Stats()
    {
        this.nbParties=0;
        this.nbVictoires=0;
    }

    /**
     * <b>Le constructeur de Stats à partir du résultat d'une partie</b>
     *
     * @param nbParties le nombre de parties jouées
     * @param nbVictoires le nombre de parties gagnées
     * <ul>
     *     <li>
     *         <strong>nbParties</strong> vaut <span class=value>nbParties</span>(paramètre 1)
     *     </li>
     *     <li>
     *         <strong>nbVictoires</strong> vaut <span class=value>nbVictoires</span>(paramètre 2)
     *     </li>
     * </ul>
     */
    public Stats(int nbParties,int nbVictoires)
    {
        this.nbParties = nbParties;
        this.nbVictoires = nbVictoires;
    }

    /**
     *<b>L'accesseur de nbVictoire</b>
     *
     * @return nbVictoires
     */
    public int getNbVictoires() {
        return nbVictoires;
    }

    /**
     * <b>L'accesseur de nbParties</b>
     *
     * @return nbParties
     */
    public int getNbParties() {
        return nbParties;
    }

    /**
     * <b>Calcul le ratio du deck</b>
     *
     * <p>
     *     On divise le nombre de victoire par le nombre de parties<br />
     *     <strong>Si nbParties = 0 on retourne <span class=value>0</span></strong>
     * </p>
     * @return getNbVictoires()/getNbParties()
     */
    public float getRatio()
    {
        if (this.getNbParties() == 0)
        {
            return 0;
        }else{
            return getNbVictoires()/getNbParties();
        }
    }

    /**
     * <b>Méthode d'incrémentation du nombre de victoire</b>
     */
    public void incrementVictoire()
    {
        this.nbVictoires++;
        this.nbParties++;
    }
    /**
     * <b>Méthode d'incrémentation du nombre de Parties</b>
     */
    public void incrementParties()
    {
        this.nbParties++;
    }

    /**
     * <b>Méthode d'affichage des Stats</b>
     *
     * <p>
     *     format : <strong><span class=value>nbVictoire</span>/<span class=value>nbPartie</span>       <span class=value>getRatio()</span></strong>
     * </p>
     */
    public void afficher()
    {
        System.out.print(this.getNbVictoires()+"/"+this.getNbParties()+"    "+this.getRatio());
    }

    public void setNbVictoires(int nvxNbVictoires)
    {
        this.nbVictoires = nvxNbVictoires;
    }

    public void setNbParties(int nbParties) {
        this.nbParties = nbParties;
    }

    private Stats cursorToStat(Cursor c, boolean one)
    {
        if (c.getCount() == 0)
            return null;

        if(one == true)
            c.moveToFirst();

        Stats statsBDD = new Stats();

        statsBDD.setNbVictoires(c.getInt(1));
        statsBDD.setNbParties(c.getInt(2));

        if(one == true)
            c.close();

        return statsBDD;
    }
}
