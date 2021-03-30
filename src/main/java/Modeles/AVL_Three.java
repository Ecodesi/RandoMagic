package Modeles;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

import net.ecodesi.randomagic.Deck;

import static androidx.room.ForeignKey.NO_ACTION;

/**
 * <b>Un arbre AVL qui représente les deck contre lesquelle le deck lié à joué</b>
 *
 * <p>
 *     Dans la suite de cette documentation <span class=name>A</span> sera le deck lié à l'arbre et <span class=name>B</span> Le deck aassimilé au noeud
 * </p>
 * <p>
 *     Un AVL se compose des chose suivantes:
 * </p>
 * <ul>
 *     <li>
 *         Un <span class=type>Node</span> nommé <strong>root</strong>
 *     </li>
 *     <li>
 *         Un <span class=type>AVL_Three</span> nommé <strong>left</strong>
 *     </li>
 *     <li>
 *         Un <span class=type>AVL_Tree</span> nommé <strong>right</strong>
 *     </li>
 *     <li>
 *         Un <span class=type>Entier</span> nommé <strong>balance</strong>
 *     </li>
 *     <li>
 *         Un <span class=type>Entier</span> nommé <strong>height</strong>
 *     </li>
 * </ul>
 */
@Entity(primaryKeys = {"id"}, foreignKeys = @ForeignKey(
    entity = AVL_Three.class,
            parentColumns = "id",
            childColumns = "id",
            onDelete = NO_ACTION
))
public class AVL_Three {

    @ColumnInfo(name = "id")
    private int id;

    @Embedded private Node root;


    @ColumnInfo(name = "id_left_child")
    private int id_left_child;

    @Ignore
    private AVL_Three left;

    @ColumnInfo(name = "id_right_child")
    private int id_right_child;

    @Ignore
    private AVL_Three right;

    @ColumnInfo(name = "id_parent")
    private int id_parent;

    @Ignore
    private AVL_Three parent;

    @ColumnInfo(name = "balance")
    private int balance;

    @ColumnInfo(name = "height")
    private int height;

    /**
     * <b>Constructeur à vide d'un AVL_Three</b>
     *
     * <p>
     * A vide l'AVL_Three est initialisé de la manière suivante:
     * </p>
     * <ul>
     *     <li>
     *         <span class=name>root</span> est un <span class=type>Node()</span>
     *     </li>
     *     <li>
     *         <span class=name>left</span> est <span class=value>null</span>
     *      </li>
     *      <li>
     *          <span class=name>right</span> est <span class=value>null</span>
     *      </li>
     *      <li>
     *          <span class=name>parent</span> est <span class=value>null</span>
     *      </li>
     *      <li>
     *          <span class=name>balance</span> est égal à <span class=value>0</span>
     *      </li>
     *      <li>
     *          <span class=name>height</span> est égal à <span class=value>0</span>
     *      </li>
     * </ul>
     */
    public AVL_Three()
    {
        this.root = new Node();
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
        this.height = 0;
    }
    /**
     * <b>Constructeur d'un AVL_Three</b>
     *
     * <p>
     * Avec paramètre l'AVL_Three est initialisé de la manière suivante:
     * </p>
     * @param n <span class=type>Node</span>
     *
     * <ul>
     *     <li>
     *         <span class=name>root</span> est un <span class=type>Node()</span>
     *     </li>
     *     <li>
     *         <span class=name>left</span> est <span class=value>null</span>
     *      </li>
     *      <li>
     *          <span class=name>right</span> est <span class=value>null</span>
     *      </li>
     *      <li>
     *          <span class=name>parent</span> est <span class=value>null</span>
     *      </li>
     *      <li>
     *          <span class=name>balance</span> est égal à <span class=value>0</span>
     *      </li>
     *      <li>
     *          <span class=name>height</span> est égal à <span class=value>0</span>
     *      </li>
     * </ul>
     */
    public AVL_Three(Node n)
    {
        this.root = n;
        this.left = new AVL_Three();
        this.right = new AVL_Three();
        this.parent = null;
        this.balance = 0;
        this.height = 0;
    }
    /**
     * <b>Getter de l'arbre principal</b>
     *
     * <p>
     *     Retourne la première jonction de l'arbre (racine)
     * </p>
     * @param a <span class=type>AVL_Tree</span>
     * @return AVL_root
     *
     *
     */
    public AVL_Three getMainRoot(AVL_Three a)
    {
        if(a.getParent() != null)
        {
            return getMainRoot(a.getParent());
        }else{
            return a;
        }
    }

    /**
     * <b>Accesseur du noeud racine de l'arbre courrant</b>
     *
     * <p>
     *     Retourne le noeud à la racine de la jonction
     * </p>
     * @return noeud
     */
    public Node getRoot() {
        return root;
    }

    /**
     * <b>Mutateur de l'arbre courrant</b>
     *
     * @param root <span class=type>Node</span>
     */
    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * <b>Accesseur de l'arbre gauche</b>
     *
     * @return Left
     */
    public AVL_Three getLeft() {
        return left;
    }

    /**
     * <b>Mutateur de l'arbre gauche</b>
     *
     * @param left <span class=type>AVL_Three</span>
     */
    public void setLeft(AVL_Three left) {
        this.left = left;
    }

    /**
     * <b>Accesseur de l'arbre droit</b>
     *
     * @return right
     */
    public AVL_Three getRight() {
        return right;
    }

    /**
     * <b>Mutateur de l'arbre droit</b>
     *
     * @param right <span class=type>AVL_Three</span>
     */
    public void setRight(AVL_Three right) {
        this.right = right;
    }

    /**
     * <b>fonction de calcul de la balance</b>
     *
     * <p>
     *     La balance correspond a une valeur numérique représentant la différence de hauteur des deux branche d'un arbre:
     * </p>
     * <ul>
     *     <li>
     *         Une valeur <strong>positive</strong> signifie que l'arbre <strong>gauche</strong> est plus <strong>haut</strong>
     *     </li>
     *     <li>
     *         Une valeur <strong>négative</strong> signifie que l'arbre <strong>droit</strong> est plus <strong>haut</strong>
     *     </li>
     *     <li>
     *         Une valeur <strong>nulle</strong> signifie que <strong>les deux fils</strong> sont <strong>de même hauteur</strong>
     *     </li>
     * </ul>
     * <p>
     *     Dans le détail cette fonction récupère la hauteur des deux fils de l'arbre avec la fonction <span class=function>getHeight()</span> et soustrait celle de gauche à celle de droite puis stock le résultat dans l'attribut <span class=name>balance</span> de l'arbre
     * </p>
     * @param arbre <span class=type>AVL_Three</span>
     * @return arbre
     * @see AVL_Three#getHeight(AVL_Three)
     */
    public int getBalance(AVL_Three arbre) {
        int equilibre = 0;
        int hauteurG = 0;
        int hauteurD = 0;
        if (arbre != null)
        {
            AVL_Three fd = arbre.getRight();
            AVL_Three fg = arbre.getLeft();
            if (fd != null)
            {
                hauteurD = getHeight(fd);
            }
            if(fg != null)
            {
                hauteurG = getHeight(fg);
            }
            equilibre = hauteurG-hauteurD;
            arbre.setBalance(equilibre);
        }
        return equilibre;
    }

    /**
     *<b>Accesseur de l'attribut balance de l'arbre</b>
     *
     * @return balance
     */
    public int getBalance()
    {
        return this.balance;
    }

    /**
     * <b>Mutateur de l'attribut balance de l'arbre</b>
     *
     * @param balance <span class=type>Entier</span>
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * <b>Accesseur de l'attribut parent de l'arbre</b>
     *
     * @return parent
     */
    public AVL_Three getParent() {
        return parent;
    }

    /**
     * <b>Mutateur de l'attribut parent de l'arbre</b>
     *
     * @param parent <span class=type>AVL_Three</span>
     */
    public void setParent(AVL_Three parent) {
        this.parent = parent;
    }

    /**
     * <b>Calculateur de la hauteur d'un arbre [Récursive]</b>
     *
     * <p>
     *      Si l'arbre n'est pas une feuille on appelle <span class=function>getHeight(fils_gauche)</span> et <span class=function>getHeight(fils_droit)</span><br/>
     *      Puis set la hauteur de l'arbre courrant à 1+la hauteur max des fils
     * </p>
     * @param arbre <span class=type>AVL_Three</span>
     * @return hauteur
     */
    public int getHeight(AVL_Three arbre) {
        int hauteur = 0;
        if(!arbre.isnull())
        {
            int hauteurG = getHeight(arbre.getLeft());
            int hauteurD = getHeight(arbre.getRight());
            int hauteurMax = 0;
            hauteurMax = Math.max(hauteurG, hauteurD);
            if(arbre.getLeft().isnull() && arbre.getRight().isnull())
            {
                hauteur = 0;
            }else{
                hauteur = 1+hauteurMax;
            }
            arbre.setHeight(hauteur);
        }
        return hauteur;
    }

    /**
     * <b>Mutateur de la hauteur de l'arbre</b>
     *
     * @param height <span class=type>Entier</span>
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * <b>Rotation droite de l'arbre</b>
     *
     * <p>
     *     Une rotation droite consiste à un équilibrage de l'arbre en tournant l'arbre sur la droite soit:
     * </p>
     * <ul>
     *     <li>
     *         <span class=name>aG</span> le <strong>fils gauche initial</strong> de <span class=name>a</span>
     *     </li>
     *     <li>
     *         Le <strong>fils gauche</strong> de <span class=name>a</span> <- <strong>fils droit </strong>de <span class=name>aG</span>
     *     </li>
     *     <li>
     *         Le <strong>fils droit</strong> de <span class=name>aG</span> <- <span class=name>a</span>
     *     </li>
     *     <li>
     *         Le <strong>parent</strong> de <span class=name>aG</span> <- <span class=name>a</span>.<span class=function>getParent()</span>
     *     </li>
     *     <li>
     *         Le <strong>parent</strong> de <span class=name>a</span> <- <span class=name>aG</span>
     *     </li>
     * </ul>
     * @param a <span class=type>AVL_Three</span>
     * @return aG (nouvelle racine du trinome)
     */
    public AVL_Three rotateRight(AVL_Three a)
    {
        AVL_Three aG = a.getLeft();
        a.setLeft(aG.getRight());
        aG.setRight(a);
        aG.setParent(a.getParent());
        a.setParent(aG);
        return aG;
    }
    /**
     * <b>Rotation gauche de l'arbre</b>
     *
     * <p>
     *     Une rotation gauche consiste à un équilibrage de l'arbre en tournant l'arbre sur la gauche soit:
     * </p>
     * <ul>
     *     <li>
     *         <span class=name>aD</span> le <strong>fils droit initial</strong> de <span class=name>a</span>
     *     </li>
     *     <li>
     *         Le <strong>fils gauche</strong> de <span class=name>a</span> <- <strong>fils gauche </strong>de <span class=name>aD</span>
     *     </li>
     *     <li>
     *         Le <strong>fils gauche</strong> de <span class=name>aD</span> <- <span class=name>a</span>
     *     </li>
     *     <li>
     *         Le <strong>parent</strong> de <span class=name>aD</span> <- <span class=name>a</span>.<span class=function>getParent()</span>
     *     </li>
     *     <li>
     *         Le <strong>parent</strong> de <span class=name>a</span> <- <span class=name>aD</span>
     *     </li>
     * </ul>
     * @param a <span class=type>AVL_Three</span>
     * @return aD (nouvelle racine du trinome)
     */
    public AVL_Three rotateLeft(AVL_Three a)
    {
        AVL_Three aD = a.getRight();
        a.setLeft(aD.getLeft());
        aD.setLeft(a);
        aD.setParent(a.getParent());
        a.setParent(aD);
        return aD;
    }
    public AVL_Three reequilibrage(AVL_Three a)
    {
        if(!a.isnull())
        {
            while(a.getBalance() < -1 || a.getBalance() > 1)
            {
                a.setLeft(reequilibrage(a.getLeft()));
                a.setRight(reequilibrage(a.getRight()));
                if(a.getBalance() <= -2)
                {
                    a = rotateLeft(a);
                }
                if(a.getBalance() >= 2)
                {
                    a = rotateRight(a);
                }
                getHeight(a);
                getBalance(a);
            }
        }
        return a;
    }
    public Node find(Deck deck, AVL_Three a)
    {
        if(!a.isnull())
        {
            if(deck.getId_deck() == a.getRoot().getKey())
            {
                System.out.println(deck.getId_deck()+" Trouvé!");
                return a.getRoot();
            }else if(deck.getId_deck() < a.getRoot().getKey() && a.getLeft() != null){
                if(a.getLeft() != null)
                {
                    System.out.println(deck.getId_deck()+" a gauche de : "+a.getRoot().getKey());
                    return a.getLeft().find(deck,a.getLeft());
                }
            }else if(deck.getId_deck() > a.getRoot().getKey()){
                if(a.getRight() != null)
                {
                    System.out.println(deck.getId_deck()+" a droite de : "+a.getRoot().getKey());
                    return a.getRight().find(deck,a.getRight());
                }
            }
        }
        System.out.println(deck.getId_deck()+" non trouvé");
        return new Node();
    }
    public int getNbVictoiresVs(Deck deck)
    {
        if (find(deck,this) != null)
        {
            return find(deck,this).getStats().getNbVictoires();
        }else{
            return 0;
        }

    }

    public float getRatioVs(Deck deck)
    {
        if (find(deck,this) != null)
        {
            return find(deck,this).getStats().getRatio();
        }else{
            return 0;
        }
    }

    /**
     * <b>Méthode d'ajout d'un noeud</b>
     *
     * @param n <span class=type>Node</span>
     * @param a <span class=type>AVL_Three</span>
     *
     * <p>On parcourt l'arbre de manière récursive et on ajoute <strong>a(n)</strong>(paramètre) à la branche correspondante, en initialise l'autre branche du parent a si elle était nulle</p>
     */

    public AVL_Three add(Node n, AVL_Three a)
    {
        if(!a.isnull())
        {
            System.out.println("a est non null!");
            if(a.getRoot().getKey() > n.getKey())
            {
                if(a.getLeft().isnull())
                {
                    a.getLeft().setParent(a);
                }
                this.add(n,a.getLeft());
            }else{
                System.out.println("on va a droite pour l'insertion");
                if(a.getRight().isnull())
                {
                    a.getRight().setParent(a);
                }
                this.add(n,a.getRight());
            }
        }else{
            System.out.println("Ajout effectué au niveau de "+a.getRoot().getKey());
            a.setRoot(n);
            a.setLeft(new AVL_Three());
            a.setRight(new AVL_Three());
            System.out.println("c'est devenu : "+a.getRoot().getKey());
        }
        reequilibrage(this.getMainRoot(a));
        return a;
    }
    public void victoireVs(Deck deck)
    {
        if(find(deck, this).getKey() != -1)
        {
            System.out.println("find a retourné autre chose que null");
            find(deck,this).getStats().incrementVictoire();
        }else{
            add(new Node(deck, true),this);
        }
    }
    public void afficher(AVL_Three a)
    {
        if(!a.isnull())
        {
            if(!a.getLeft().isnull())
            {
                afficher(a.getLeft());
            }
            a.getRoot().afficher();
            if(!a.getRight().isnull())
            {
                afficher(a.getRight());
            }
        }
    }
    public boolean isnull()
    {
        return this.getRoot().getKey() == -1;
    }

    public int getId_left_child() {
        return id_left_child;
    }

    public void setId_left_child(int id_left_child) {
        this.id_left_child = id_left_child;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_right_child() {
        return id_right_child;
    }

    public void setId_right_child(int id_right_child) {
        this.id_right_child = id_right_child;
    }

    public int getId_parent() {
        return id_parent;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public int getHeight() {
        return height;
    }
}
