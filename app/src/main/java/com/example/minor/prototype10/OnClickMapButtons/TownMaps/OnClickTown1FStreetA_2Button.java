package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetA_2Button extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10006;
        onInit();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層A_2通り】\n文章未定");

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("レンガの家は未実装です。お金を盗めます。バレると敵のレベルが大幅に上がります。こういうマップは使いまわせるように作ります。");
            }
        });
        imageButton1Text.setText("レンガの家");

        OnClickTown1FStreetAButton onClickTown1FStreetAButton = new OnClickTown1FStreetAButton();
        imageButton2.setOnClickListener(onClickTown1FStreetAButton);
        imageButton2Text.setText("A通り");

        OnClickTown1FStreetCButton onClickTown1FStreetCButton = new OnClickTown1FStreetCButton();
        imageButton4.setOnClickListener(onClickTown1FStreetCButton);
        imageButton4Text.setText("C通り");

        OnClickTown1FStreetBButton onClickTown1FStreetBButton = new OnClickTown1FStreetBButton();
        imageButton6.setOnClickListener(onClickTown1FStreetBButton);
        imageButton6Text.setText("B通り");
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
