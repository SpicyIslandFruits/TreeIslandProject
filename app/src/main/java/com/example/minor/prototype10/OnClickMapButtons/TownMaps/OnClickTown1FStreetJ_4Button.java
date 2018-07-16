package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetJ_4Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10029;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層J_4通り】\n文章未定");

        imageButton1.setOnClickListener(new OnClickTown1FStreetJ_2Button());
        imageButton1Text.setText("J_2通り");

        imageButton3.setOnClickListener(new OnClickTown1FStreetJ_3Button());
        imageButton3Text.setText("J_3通り");

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("ここは地下街の入り口です。入るとランダムでマップが生成されます。");
            }
        });
        imageButton6Text.setText("地下街");
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
