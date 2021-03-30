package net.ecodesi.randomagic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    //private ImageButton mAccessFindGame;
    private ImageButton mAccessListDeck;

    public void moveToEditDeck()
    {
        Intent intent = new Intent(this,EditDeckActivity.class);
        startActivity(intent);
    }
    public void moveToDeckList()
    {
        Intent intent = new Intent(this,DeckListActivity.class);
        startActivity(intent);
    }

    public void switchPage(int id_targetPage)
    {
        System.out.println(id_targetPage);
        switch (id_targetPage)
        {
            case 1:
                moveToDeckList();
                break;
            case 2:
                moveToEditDeck();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + id_targetPage);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mAccessFindGame = (ImageButton) findViewById(R.id.activity_main_access_findGame);
        mAccessListDeck = (ImageButton) findViewById(R.id.activity_main_access_deckList);
        mAccessListDeck.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                switchPage(1);
            }
        });



    }

}