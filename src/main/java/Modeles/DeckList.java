package Modeles;

import net.ecodesi.randomagic.Deck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class DeckList {
    private ArrayList <Deck> deckList = new ArrayList<Deck>();
    private int lastIdDeck;

    public void incrementLastId()
    {
        this.lastIdDeck++;
    }
    public void decrementLastId()
    {
        this.lastIdDeck--;
    }
    public int getLastIdDeck()
    {
        return this.getLastIdDeck();
    }

    public ArrayList<Deck> getDeckList() {
        return this.deckList;
    }

    public Deck getDeck(Deck deckToGet)
    {
        return this.getDeckList().get(deckToGet.getId_deck());
    }

    public void addDeck(Deck deckToAdd)
    {
        this.deckList.add(deckToAdd);
        this.incrementLastId();
    }
    public void deleteDeck(Deck deckToDelete)
    {
        ListIterator<Deck> iterator = this.getDeckList().listIterator(deckToDelete.getId_deck());
        while (iterator.hasNext())
        {
            iterator.next().decrementId();
        }
        this.deckList.remove(deckToDelete.getId_deck());
    }
}
