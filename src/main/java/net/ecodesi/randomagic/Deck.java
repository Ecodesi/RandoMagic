package net.ecodesi.randomagic;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import Modeles.AVL_Three;
import Modeles.Utilisateur;
@Entity(primaryKeys={"id_deck"})
public class Deck {

    private int id_deck;

    @ColumnInfo(name = "nbGame")
    private int nbGames;

    @ColumnInfo(name = "deckName")
    private String deckName;

    @ColumnInfo(name = "deckLegality")
    private String deckLegality;

    @Nullable
    @Embedded private AVL_Three AVL_parties;

    @Embedded private Utilisateur possesseur;

    public Deck(int i, String name, String legality,Utilisateur pos) {
        this.id_deck = i;
        this.deckName = name;
        this.deckLegality = legality;
        this.nbGames = 0;
        this.AVL_parties = new AVL_Three();
        this.possesseur = pos;
    }
    public Deck()
    {
        this.id_deck = Integer.parseInt(null);
        this.deckName = null;
        this.deckLegality = null;
        this.nbGames = 0;
        this.AVL_parties = new AVL_Three();
        this.possesseur = null;
    }

    public int getId_deck()
    {
        return this.id_deck;
    }

    public String getDeckName()
    {
        return this.deckName;
    }
    public String getDeckLegality()
    {
        return this.deckLegality;
    }

    public void setDeckName(String newName)
    {
        this.deckName = newName;
    }
    public void setDeckLegality(String newLegality)
    {
        this.deckLegality = newLegality;
    }

    public void setId_deck(int newId)
    {
        this.id_deck = newId;
    }
    public void decrementId()
    {
        this.id_deck--;
    }
    public void incrementId()
    {
        this.id_deck++;
    }

    public void victoireVs(Deck deck)
    {
        this.AVL_parties.victoireVs(deck);
    }

    public void afficher()
    {
        System.out.println("Deck name : "+ this.getDeckName());
        System.out.println("     Legality : "+this.getDeckLegality());
        System.out.print("     Possesseur : ");
        this.getPossesseur().afficher();
        System.out.println();
        System.out.println("-----------PARTIES CONTRE : ---------");
        System.out.println("NOM DU DECK | NB VICTOIRES/NB PARTIES   | RATIO");
        this.AVL_parties.afficher(this.AVL_parties);
    }
    public void setAVL_parties(AVL_Three Avl)
    {
        this.AVL_parties = Avl;
    }
    public AVL_Three getAVL_parties(){
        return this.AVL_parties;
    }

    public int getNbGames() {
        return nbGames;
    }

    public void setNbGames(int nbGames) {
        this.nbGames = nbGames;
    }
    public void incrementNbGames()
    {
        this.nbGames++;
    }
    public void decrementNbGames()
    {
        this.nbGames--;
    }

    public Utilisateur getPossesseur() {
        return possesseur;
    }

    public void setPossesseur(Utilisateur possesseur) {
        this.possesseur = possesseur;
    }
}
