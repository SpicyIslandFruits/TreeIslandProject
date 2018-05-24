package com.example.minor.prototype10.OnClickMapButtons;

import android.content.SharedPreferences;
import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickStudyButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 15;
        savePosition();
        resetAllButtons();
        if(sharedPreferences.getBoolean("oldMansionGardenCornerKeyFoundFlag", false)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("oldMansionGardenCornerKeyFoundFlag", false);
            editor.apply();
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MainActivity.soundPool.play(MainActivity.birdsFlySound, 1.0f, 1.0f, 1, 0, 1);
                }
            }, 600);
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mainText.setText("！！！");
                }
            }, 1000);
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mainText.setText("窓の外で、黒い影がものすごい速さで飛び去って行くのが見えた...");
                    OnClickBookshelfButton onClickBookshelfButton = new OnClickBookshelfButton();
                    imageButton3.setOnClickListener(onClickBookshelfButton);
                    imageButton3Text.setText("書棚");
                    OnClickOldMansion2FButton onClickOldMansion2FButton = new OnClickOldMansion2FButton();
                    imageButton8.setOnClickListener(onClickOldMansion2FButton);
                    imageButton8Text.setText("戻る");
                }
            }, 2000);
        }else{
            MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
            mainText.setText("書斎の文章は未定です。これから二つのオブジェクトを追加する予定です。");
            OnClickBookshelfButton onClickBookshelfButton = new OnClickBookshelfButton();
            imageButton3.setOnClickListener(onClickBookshelfButton);
            imageButton3Text.setText("書棚");
            OnClickOldMansion2FButton onClickOldMansion2FButton = new OnClickOldMansion2FButton();
            imageButton8.setOnClickListener(onClickOldMansion2FButton);
            imageButton8Text.setText("戻る");
        }
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
