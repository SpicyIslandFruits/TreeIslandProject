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
        mainText.setText("【街第一層A通り】\n文章未定");
        String bgmName = "town1FSound";
        mediaPlayer = MediaPlayer.create(mMain, R.raw.town1f_sound);
        audioPlay(mediaPlayer, bgmName);
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        changeBaseEnemyLevel(10);
        OnClickTown1FStreetA_1Button onClickTown1FStreetA_1Button = new OnClickTown1FStreetA_1Button();
        imageButton1.setOnClickListener(onClickTown1FStreetA_1Button);
        imageButton1Text.setText("A_1通り");
        OnClickTown1FStreetA_2Button onClickTown1FStreetA_2Button = new OnClickTown1FStreetA_2Button();
        imageButton2.setOnClickListener(onClickTown1FStreetA_2Button);
        imageButton2Text.setText("A_2通り");
        OnClickTown1FObservatoryMapButton onClickTown1FObservatoryMapButton = new OnClickTown1FObservatoryMapButton();
        imageButton4.setOnClickListener(onClickTown1FObservatoryMapButton);
        imageButton4Text.setText("展望台");
        final OnClickPassButton onClickPassButton = new OnClickPassButton();
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAllButtons();
                mainText.setText("");
                audioStop();
                MainActivity.soundPool.play(MainActivity.walkTussockSound, 1.0f, 1.0f, 1, 0, 1);
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
