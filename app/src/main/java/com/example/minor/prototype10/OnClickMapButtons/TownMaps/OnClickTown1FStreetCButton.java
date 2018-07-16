package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FStreetCButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10007;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【街第一層C通り】\n文章未定");

        OnClickTown1FStreetC_1Button onClickTown1FStreetC_1Button = new OnClickTown1FStreetC_1Button();
        imageButton1.setOnClickListener(onClickTown1FStreetC_1Button);
        imageButton1Text.setText("C_1通り");

        OnClickTown1FStreetBButton onClickTown1FStreetBButton = new OnClickTown1FStreetBButton();
        imageButton2.setOnClickListener(onClickTown1FStreetBButton);
        imageButton2Text.setText("B通り");

        OnClickTown1FStreetC_2Button onClickTown1FStreetC_2Button = new OnClickTown1FStreetC_2Button();
        imageButton3.setOnClickListener(onClickTown1FStreetC_2Button);
        imageButton3Text.setText("C_2通り");

        OnClickTown1FStreetA_2Button onClickTown1FStreetA_2Button = new OnClickTown1FStreetA_2Button();
        imageButton4.setOnClickListener(onClickTown1FStreetA_2Button);
        imageButton4Text.setText("A_2通り");

        OnClickTown1FStreetDButton onClickTown1FStreetDButton = new OnClickTown1FStreetDButton();
        imageButton5.setOnClickListener(onClickTown1FStreetDButton);
        imageButton5Text.setText("D通り");

        OnClickTown1FStreetC_3Button onClickTown1FStreetC_3Button = new OnClickTown1FStreetC_3Button();
        imageButton6.setOnClickListener(onClickTown1FStreetC_3Button);
        imageButton6Text.setText("C_3通り");

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("古びた家は未実装です。");
            }
        });
        imageButton7Text.setText("古びた家");
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
