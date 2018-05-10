package com.example.minor.prototype10.OnClickMapButtons;

import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.R;

//ダンジョンのコメント参照
public class OnClickBossRoomButton extends SuperOnClickMapButton{
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
    public void createMap(){
        savePosition();
        resetAllButtons();

        int bgmId = 1;
        mediaPlayer = MediaPlayer.create(mMain, R.raw.sample_bgm);
        audioPlay(mediaPlayer, bgmId);
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = (int)(Math.random()*2+1);
                encounter(id, 100);
            }
        });
        OnClickDungeon2FButton onClickDungeon2FButton = new OnClickDungeon2FButton();
        imageButton2.setOnClickListener(onClickDungeon2FButton);
        mainText.setText("ここはボス部屋です");
        position = 3;
        changeBaseEnemyLevel(60);

        OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
        imageButton8.setOnClickListener(onClickEmptyButton);
        imageButton8Text.setText("峠に戻る");
    }
}
