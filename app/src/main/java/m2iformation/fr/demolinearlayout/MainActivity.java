package m2iformation.fr.demolinearlayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPseudo; // Ces variables représentent les zones de saisie
    EditText etPassword;
    //EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "on create", Toast.LENGTH_LONG).show();

        etPseudo = findViewById(R.id.etPseudo);
        etPassword = findViewById(R.id.etPassword);
        //etAge = findViewById(R.id.etAge);


        etPseudo.setTextColor(Color.CYAN);
        etPseudo.setText("Bonjour");

        //Accéder à l'objet qui gère les préférences :
        SharedPreferences pref = getPreferences(MODE_PRIVATE);

        //Avec cet objet, récupérer la valeur pseudo :
        String pseudo = pref.getString("pseudo","");

        //Ecrire cette valeur dans la zone de saisie :
        etPseudo.setText(pseudo);

    }

    public void ok(View view){
        Toast.makeText(this, "ok", Toast.LENGTH_LONG).show();
        //Accéder à l'objet qui gère les préférences :
        SharedPreferences pref = getPreferences(MODE_PRIVATE);

        //Accéder à l'objet Editor pour écrire des valeurs :
        SharedPreferences.Editor editor = pref.edit();

        //Ecrire la saisie dans les préférences :
        editor.putString("pseudo", etPseudo.getText().toString());

        //Valider cet enregistrement :
        editor.commit();

       // int age = Integer.parseInt(etAge.getText().toString());
        //int restant = 65 - age;
        //Toast.makeText(this, String.valueOf(restant), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "on restart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "on destroy", Toast.LENGTH_LONG).show();
    }

    public void Annuler(View view) {
        Toast.makeText(this, "Annuler", Toast.LENGTH_LONG).show();
    }
}
