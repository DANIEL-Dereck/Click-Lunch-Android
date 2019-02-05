package fr.rennes.clicklunch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.Proxy;

import fr.rennes.clicklunch.R;
import fr.rennes.database.Entity.RequestBuilder;
import fr.rennes.database.Entity.Type;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RequestBuilder.getInstance().create("toto")
                .addCol("name",Type.STRING)
                .addCol("photo",Type.BLOB)
                .build();

        RequestBuilder.getInstance().insert("").table("");

    }
}
