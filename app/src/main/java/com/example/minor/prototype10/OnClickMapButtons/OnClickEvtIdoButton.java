package com.example.minor.prototype10.OnClickMapButtons;

import android.content.SharedPreferences;
import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickEvtIdoButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 32;
        savePosition();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        if(sharedPreferences.getInt("oldMansionGhostPosition", 0) == 0) {
            mainText.setText("井戸の中に隠れているかもしれない...");
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText("");
                    stopAllButtons();
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.soundPool.play(MainActivity.stoneWaterDropSound, 1.0f, 1.0f, 1, 0, 1);
                        }
                    }, 300);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mainText.setText("お前は石を投げ込んだ、果たしてここにいるのだろうか。");
                        }
                    }, 1000);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.soundPool.play(MainActivity.yuureiMituketaSound, 1.0f, 1.0f, 1, 0, 1);
                        }
                    }, 2500);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //0が井戸に隠れている状態1が屋敷に逃げ込んだ状態です
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putInt("oldMansionGhostPosition", 1);
                            editor.apply();
                            mainText.setText("黒い影が飛びだしてきた！！！\n一瞬の出来事に、お前は反応することができなかった...");
                            startAllButtons();
                            imageButton1.setOnClickListener(null);
                            imageButton8Text.setText("追いかける");
                            OnClickBBBothRepairedEvtButton onClickBBBothRepairedEvtButton = new OnClickBBBothRepairedEvtButton();
                            imageButton8.setOnClickListener(onClickBBBothRepairedEvtButton);
                        }
                    }, 3000);
                }
            });
            imageButton1Text.setText("石を投げ込む");
        }else{
            mainText.setText("もうここにはいないだろう");
        }
        OnClickBBBothRepairedEvtButton onClickBBBothRepairedEvtButton = new OnClickBBBothRepairedEvtButton();
        imageButton8.setOnClickListener(onClickBBBothRepairedEvtButton);
        imageButton8Text.setText("やめる");
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
