package br.ufrn.eaj.tads.testesd;

import com.firebase.client.Firebase;

/**
 * Created by VILA on 08/09/2016.
 */
public class CrowdWeather extends android.app.Application {

    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
