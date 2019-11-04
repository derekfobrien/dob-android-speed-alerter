package com.example.derek.myspeedalerter;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.media.MediaPlayer;

public class DisplayFragment extends Fragment {
    private static TextView textYourSpeed;
    private static TextView textMessage;
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState){
        View view = inflater.inflate(R.layout.display_fragment, container, false);

        textYourSpeed = (TextView)view.findViewById(R.id.textKmh);
        textMessage = (TextView)view.findViewById(R.id.textViewMessage);

        return view;
    }

    public void displayMessages(double yourspeedkmh, double speedLimitkmh, MediaPlayer mpSD) {
        float yourspeedkmhf;
        String yourspeedstring;

        // code to get speed from GPS goes here
        yourspeedkmhf = (float) (0.01 * Math.floor((100 * yourspeedkmh) + 0.5));

        yourspeedstring = String.format("%.2f km/h", yourspeedkmhf);

        textYourSpeed.setText(yourspeedstring);

        if (yourspeedkmh < speedLimitkmh) {
            // inside the speed limit - no alerts
            if (mpSD.isPlaying()) {
                mpSD.stop();
            }
        } else {
            // exceeding the speed limit
            if (!mpSD.isPlaying()) {
                mpSD.start();
            }
        }
   }
}
