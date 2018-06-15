package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetDButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10008;
        savePosition();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層D通り】\n文章未定、内容未定");

        OnClickTown1FStreetC_4Button onClickTown1FStreetC_4Button = new OnClickTown1FStreetC_4Button();
        imageButton3.setOnClickListener(onClickTown1FStreetC_4Button);
        imageButton3Text.setText("C_4通り");

        OnClickTown1FStreetCButton onClickTown1FStreetCButton = new OnClickTown1FStreetCButton();
        imageButton5.setOnClickListener(onClickTown1FStreetCButton);
        imageButton5Text.setText("C通り");
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
