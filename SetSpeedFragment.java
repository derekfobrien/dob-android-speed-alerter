package com.example.derek.myspeedalerter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SetSpeedFragment extends Fragment {

    private TextView textcurrentspeedlimit;
    private ImageView image030;
    private ImageView image040;
    private ImageView image050;
    private ImageView image060;
    private ImageView image070;
    private ImageView image080;
    private ImageView image090;
    private ImageView image100;
    private ImageView image110;
    private ImageView image120;
    private double currentSpeedLimit;

    SetSpeedListener activityCallback;

    public interface SetSpeedListener{
        void onButtonClick(double speedlimit);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState){
        View view = inflater.inflate(R.layout.setspeed_fragment, container, false);

        textcurrentspeedlimit = (TextView)view.findViewById(R.id.textCurrentSpeedLimit);
        image030 = (ImageView)view.findViewById(R.id.imageView030);
        image040 = (ImageView)view.findViewById(R.id.imageView040);
        image050 = (ImageView)view.findViewById(R.id.imageView050);
        image060 = (ImageView)view.findViewById(R.id.imageView060);
        image070 = (ImageView)view.findViewById(R.id.imageView070);
        image080 = (ImageView)view.findViewById(R.id.imageView080);
        image090 = (ImageView)view.findViewById(R.id.imageView090);
        image100 = (ImageView)view.findViewById(R.id.imageView100);
        image110 = (ImageView)view.findViewById(R.id.imageView110);
        image120 = (ImageView)view.findViewById(R.id.imageView120);

        // when the 30km/h speed limit sign is clicked
        image030.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                speed030Clicked(v);
            }
        });

        // when the 40km/h speed limit sign is clicked
        image040.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                speed040Clicked(v);
            }
        });

        // when the 50km/h speed limit sign is clicked
        image050.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                speed050Clicked(v);
            }
        });

        // when the 60km/h speed limit sign is clicked
        image060.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                speed060Clicked(v);
            }
        });

        // when the 70km/h speed limit sign is clicked
        image070.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                speed070Clicked(v);
            }
        });

        // when the 80km/h speed limit sign is clicked
        image080.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                speed080Clicked(v);
            }
        });

        // when the 90km/h speed limit sign is clicked
        image090.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                speed090Clicked(v);
            }
        });

        // when the 100km/h speed limit sign is clicked
        image100.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                speed100Clicked(v);
            }
        });

        // when the 110km/h speed limit sign is clicked
        image110.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                speed110Clicked(v);
            }
        });

        // when the 120km/h speed limit sign is clicked
        image120.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                speed120Clicked(v);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCallback = (SetSpeedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement SpeedListener");
        }
    }

    public void speed030Clicked(View v){
        currentSpeedLimit = 30;
        textcurrentspeedlimit.setText(String.format("Current limit is %1.0f km/h", currentSpeedLimit));
        activityCallback.onButtonClick(currentSpeedLimit);
    }

    public void speed040Clicked(View v){
        currentSpeedLimit = 40;
        textcurrentspeedlimit.setText(String.format("Current limit is %1.0f km/h", currentSpeedLimit));
        activityCallback.onButtonClick(currentSpeedLimit);
    }

    public void speed050Clicked(View v){
        currentSpeedLimit = 50;
        textcurrentspeedlimit.setText(String.format("Current limit is %1.0f km/h", currentSpeedLimit));
        activityCallback.onButtonClick(currentSpeedLimit);
    }

    public void speed060Clicked(View v){
        currentSpeedLimit = 60;
        textcurrentspeedlimit.setText(String.format("Current limit is %1.0f km/h", currentSpeedLimit));
        activityCallback.onButtonClick(currentSpeedLimit);
    }

    public void speed070Clicked(View v){
        currentSpeedLimit = 70;
        textcurrentspeedlimit.setText(String.format("Current limit is %1.0f km/h", currentSpeedLimit));
        activityCallback.onButtonClick(currentSpeedLimit);
    }

    public void speed080Clicked(View v){
        currentSpeedLimit = 80;
        textcurrentspeedlimit.setText(String.format("Current limit is %1.0f km/h", currentSpeedLimit));
        activityCallback.onButtonClick(currentSpeedLimit);
    }

    public void speed090Clicked(View v){
        currentSpeedLimit = 90;
        textcurrentspeedlimit.setText(String.format("Current limit is %1.0f km/h", currentSpeedLimit));
        activityCallback.onButtonClick(currentSpeedLimit);
    }

    public void speed100Clicked(View v){
        currentSpeedLimit = 100;
        textcurrentspeedlimit.setText(String.format("Current limit is %1.0f km/h", currentSpeedLimit));
        activityCallback.onButtonClick(currentSpeedLimit);
    }

    public void speed110Clicked(View v){
        currentSpeedLimit = 110;
        textcurrentspeedlimit.setText(String.format("Current limit is %1.0f km/h", currentSpeedLimit));
        activityCallback.onButtonClick(currentSpeedLimit);
    }

    public void speed120Clicked(View v){
        currentSpeedLimit = 120;
        textcurrentspeedlimit.setText(String.format("Current limit is %1.0f km/h", currentSpeedLimit));
        activityCallback.onButtonClick(currentSpeedLimit);
    }

    public double getCurrentSpeedLimit() {
        return currentSpeedLimit;
    }

}
