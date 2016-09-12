package br.ufrn.eaj.tads.testesd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView mTextFieldCOndition;
    Button mButtonSunny;
    Button mButtonFoggy;
    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   @Override
    protected void onStart() {
        super.onStart();
        mTextFieldCOndition = (TextView) findViewById(R.id.textViewCondition);
        mButtonFoggy = (Button) findViewById(R.id.buttonFoggy);
        mButtonSunny = (Button) findViewById(R.id.buttonSunny);

       mRef = new Firebase("https://trabalhosd-422f0.firebaseio.com/Tempo");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String texto = dataSnapshot.getValue(String.class);
                mTextFieldCOndition.setText(texto);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mButtonFoggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.setValue("Foggy");

            }
        });
        mButtonSunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.setValue("Sunny");

            }
        });
    }

}