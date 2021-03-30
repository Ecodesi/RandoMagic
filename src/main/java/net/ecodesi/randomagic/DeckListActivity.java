package net.ecodesi.randomagic;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import DataBase.AppDatabase;
import DataBase.DeckDAO;
public class DeckListActivity extends AppCompatActivity {
    public AppDatabase db;
    public DeckDAO deckDao;
    public List<String> decksNames;


    public void onStart(){
        super.onStart();
        Thread DeckDatabaseRetriever = new Thread(new Runnable() {
            @Override
            public void run() {
                db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "deck").build();
                deckDao = db.deckDAO();
                decksNames = deckDao.getAllDeckName();
            }
        });
        DeckDatabaseRetriever.start();
        for (String name : decksNames)
        {
            System.out.println(name);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decks_list);



    }

}
