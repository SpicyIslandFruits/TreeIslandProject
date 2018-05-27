package com.example.minor.prototype10.OnClickMapButtons;

import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.R;

public class OnClickOldMansionInBasementButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 45;
        savePosition();
        resetAllButtons();
        stopAllButtons();
        int bgmId = 4;
        mediaPlayer = MediaPlayer.create(mMain, R.raw.noise);
        audioPlay(mediaPlayer, bgmId);
        MainActivity.soundPool.play(MainActivity.walkGymnasiumSound, 5.0f, 5.0f, 1, 0, 0.8f);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.soundPool.play(MainActivity.doorOpenSound, 1.0f, 1.0f, 1, 0, 0.8f);
            }
        }, 4500);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAllButtons();
                int bgmId = 5;
                mediaPlayer = MediaPlayer.create(mMain, R.raw.basement_sound);
                audioPlay(mediaPlayer, bgmId);
                mainText.setText("地下室の中です。");
                OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
                imageButton8.setOnClickListener(onClickGardenButton);
                imageButton8Text.setText("出る");
            }
        }, 5500);
    }

    @Override
    public void onClick(View v) {
        createMap();
    }
}
