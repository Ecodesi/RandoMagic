package net.ecodesi.randomagic;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import Modeles.Utilisateur;

public class EditDeckActivity extends AppCompatActivity {

    private EditText mDeckNameInput;
    private EditText mDeckLegalityInput;
    private Button mValidate;
    private String deckName;
    private String deckLegality;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_deck);
        mDeckNameInput = (EditText) findViewById(R.id.activity_edit_deck_dName);
        mDeckLegalityInput = (EditText) findViewById(R.id.activity_edit_deck_dLegality);
        mValidate = (Button) findViewById(R.id.activity_edit_deck_dValidate);

        mDeckNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                deckName = mDeckNameInput.getText().toString();
            }
        });//met à jour un String contenant le nom du deck quand le TextInput est modifié

        mDeckLegalityInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                deckLegality = mDeckNameInput.getText().toString();
            }
        });//met à jour un String contenant la légalité du deck quand le TextInput est modifié
        mValidate.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Utilisateur user =new Utilisateur("jhon","mdpdepd");
                Deck deckToInsert = new Deck(0,deckName,deckLegality,user);
                deckToInsert.afficher(); //affichage pour vérifier que le bouton fonctionne
                /*TODO
                    Insérer dans la bdd le nouveau deck avec le bon ID
                 */
            }
        });

    }

}