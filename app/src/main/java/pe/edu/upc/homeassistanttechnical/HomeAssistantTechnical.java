package pe.edu.upc.homeassistanttechnical;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by jlosorio on 10/3/17.
 */

public class HomeAssistantTechnical extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
