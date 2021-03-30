package Modeles;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity(primaryKeys = {"nom"})
public class Utilisateur {
    @NonNull
    @ColumnInfo(name = "nom")
    private String nom;

    @ColumnInfo(name = "mdp")
    private String mdp;

    public Utilisateur(String nom, String mdp) {
        this.nom = nom;
        this.mdp = mdp;
    }
    @Ignore
    public Utilisateur() {
        this.nom = null;
        this.mdp = null;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public void afficher()
    {
        System.out.print(this.getNom());
    }
}
