package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetCButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10007;
        savePosition();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層C通り】\n文章未定、内容未定");

        OnClickTown1FStreetBButton onClickTown1FStreetBButton = new OnClickTown1FStreetBButton();
        imageButton2.setOnClickListener(onClickTown1FStreetBButton);
        imageButton2Text.setText("B通り");

        OnClickTown1FStreetA_2Button onClickTown1FStreetA_2Button = new OnClickTown1FStreetA_2Button();
        imageButton4.setOnClickListener(onClickTown1FStreetA_2Button);
        imageButton4Text.setText("A_2通り");
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
