package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

//ダンジョンのコメントを参照
public class OnClickTownButton extends SuperOnClickMapButton {
    public void createMap(){
        position = 1;
        onInit();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickDungeonButton onClickDungeonButton = new OnClickDungeonButton();
        imageButton1.setOnClickListener(onClickDungeonButton);
        OnClickInnButton onClickInnButton = new OnClickInnButton();
        imageButton2.setOnClickListener(onClickInnButton);
        mainText.setText("ここは街です");

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
