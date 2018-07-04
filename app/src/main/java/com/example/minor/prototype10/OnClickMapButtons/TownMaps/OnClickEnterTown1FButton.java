package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.OnClickPassButton;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickEnterTown1FButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10001;
        onInit();
        mainText.setText("【街の門】\n街の第一層へ入る門に着きました。文章未定");

        OnClickTown1FStreetAButton onClickTown1FStreetAButton = new OnClickTown1FStreetAButton();
        imageButton1.setOnClickListener(onClickTown1FStreetAButton);
        imageButton1Text.setText("入る");
        //見直しの可能性あり
        final OnClickPassButton onClickPassButton = new OnClickPassButton();
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAllButton();
                mainText.setText("・");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("・・");
                    }
                }, 1100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("・・・");
                    }
                }, 2100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("・・・・");
                    }
                }, 3100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("・・・・・");
                    }
                }, 4100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("・・・・・・");
                    }
                }, 5100);

                MainActivity.soundPool.play(MainActivity.walkTussockSound, 1.0f, 1.0f, 1, 0, 1);

                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onClickPassButton.createMap();
                    }
                }, 6300);
            }
        });
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
