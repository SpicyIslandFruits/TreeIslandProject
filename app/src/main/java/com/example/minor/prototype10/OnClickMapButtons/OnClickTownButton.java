package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.AbnormalStates;
import com.example.minor.prototype10.MainActivity;

//ダンジョンのコメントを参照
public class OnClickTownButton extends SuperOnClickMapButton{

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
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.sampleSound1, 1.0f, 1.0f, 1, 0, 1);
        OnClickDungeonButton onClickDungeonButton = new OnClickDungeonButton();
        imageButton1.setOnClickListener(onClickDungeonButton);
        OnClickInnButton onClickInnButton = new OnClickInnButton();
        imageButton2.setOnClickListener(onClickInnButton);
        mainText.setText("ここは街です");
        position = 1;
        savePosition();
    }
}
