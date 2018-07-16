package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickEvtBedroomButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 43;
        onInit();
        mainText.setText("ここにいるのだろうか...");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton1.setEnabled(false);
                imageButton1Text.setText("");
                imageButton7.setEnabled(false);
                imageButton7Text.setText("");
                imageButton8.setEnabled(false);
                imageButton8Text.setText("");
                mainText.setText("");
                MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 0.5f);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButton1.setEnabled(true);
                        imageButton1Text.setText("ベッドを探す");
                        imageButton7.setEnabled(true);
                        imageButton7Text.setText("押入れを探す");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("戻る");
                        mainText.setText("ここにはいないようだ...");
                    }
                }, 1500);
            }
        });
        imageButton1Text.setText("ベッドを探す");

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton1.setEnabled(false);
                imageButton1Text.setText("");
                imageButton7.setEnabled(false);
                imageButton7Text.setText("");
                imageButton8.setEnabled(false);
                imageButton8Text.setText("");
                mainText.setText("");
                MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 0.5f);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButton1.setEnabled(true);
                        imageButton1Text.setText("ベッドを探す");
                        imageButton7.setEnabled(true);
                        imageButton7Text.setText("押入れを探す");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("戻る");
                        mainText.setText("ここにはいないようだ...");
                    }
                }, 1500);
            }
        });
        imageButton7Text.setText("押入れを探す");

        OnClickEvtMansion2FButton onClickEvtMansion2FButton = new OnClickEvtMansion2FButton();
        imageButton8.setOnClickListener(onClickEvtMansion2FButton);
        imageButton8Text.setText("戻る");
    }

    @Override
    public void onClick(View v) {
        stopAllButtons();
        createMap();
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAllButtons();
            }
        }, 1000);

    }
}
