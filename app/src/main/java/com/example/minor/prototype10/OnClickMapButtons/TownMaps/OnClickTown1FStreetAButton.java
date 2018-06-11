package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEmptyButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickPassButton;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;

public class OnClickTown1FStreetAButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10002;
        savePosition();
        resetAllButtons();
        mainText.setText("ここは街の第一層のA通りです。文章未定");
        String bgmName = "town1FSound";
        mediaPlayer = MediaPlayer.create(mMain, R.raw.town1f_sound);
        audioPlay(mediaPlayer, bgmName);
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
        imageButton1.setOnClickListener(onClickEmptyButton);
        imageButton1Text.setText("A-1通り");
        OnClickEmptyButton onClickEmptyButton1 = new OnClickEmptyButton();
        imageButton2.setOnClickListener(onClickEmptyButton1);
        imageButton2Text.setText("A-3通り");
        OnClickEmptyButton onClickEmptyButton2 = new OnClickEmptyButton();
        imageButton3.setOnClickListener(onClickEmptyButton2);
        imageButton3Text.setText("B通り");
        OnClickEmptyButton onClickEmptyButton3 = new OnClickEmptyButton();
        imageButton4.setOnClickListener(onClickEmptyButton3);
        imageButton4Text.setText("展望台");
        final OnClickPassButton onClickPassButton = new OnClickPassButton();
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAllButtons();
                mainText.setText("");
                audioStop();
                MainActivity.soundPool.play(MainActivity.walkTussockSound, 1.0f, 1.0f, 1, 0, 1);

                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onClickPassButton.createMap();
                    }
                }, 6300);
            }
        });
        imageButton8Text.setText("街を出る");
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
