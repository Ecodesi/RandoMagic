package net.ecodesi.randomagic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class LeftNavbarActivity extends AppCompatActivity {
    private ImageButton mAccessFindGame;
    private ImageButton mAccessListDeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mAccessFindGame = (ImageButton) findViewById(R.id.activity_main_access_findGame);
        mAccessListDeck = (ImageButton) findViewById(R.id.activity_main_access_deckList);

        mAccessFindGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                /*Intent gameActivity = new Intent(MainActivity.this, findGameActivity.class);
                startActivity(findGameActivity);*/
            }
        });
        mAccessListDeck.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                moveToEditDeck();
            }
        });


    }
    public void moveToEditDeck()
    {
        Intent intent = new Intent(this,EditDeckActivity.class);
        startActivity(intent);
    }
}
