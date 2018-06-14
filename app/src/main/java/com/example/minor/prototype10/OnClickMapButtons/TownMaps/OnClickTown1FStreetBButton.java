package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetBButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10005;
        savePosition();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層B通り】\n文章未定");

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("畑は未実装です。作物を盗めます。使いまわせるように作ります。");
            }
        });
        imageButton1Text.setText("畑");

        OnClickTown1FStreetCButton onClickTown1FStreetCButton = new OnClickTown1FStreetCButton();
        imageButton2.setOnClickListener(onClickTown1FStreetCButton);
        imageButton2Text.setText("C通り");

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("木の家は未実装です。お金を盗めます。使いまわせるように作ります。");
            }
        });
        imageButton3Text.setText("木の家");

        OnClickTown1FStreetA_1Button onClickTown1FStreetA_1Button = new OnClickTown1FStreetA_1Button();
        imageButton4.setOnClickListener(onClickTown1FStreetA_1Button);
        imageButton4Text.setText("A_1通り");

        OnClickTown1FStreetA_2Button onClickTown1FStreetA_2Button = new OnClickTown1FStreetA_2Button();
        imageButton6.setOnClickListener(onClickTown1FStreetA_2Button);
        imageButton6Text.setText("A_2通り");
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
