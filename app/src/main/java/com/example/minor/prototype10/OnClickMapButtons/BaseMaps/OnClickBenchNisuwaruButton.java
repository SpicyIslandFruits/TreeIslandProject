package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;

public class OnClickBenchNisuwaruButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 22;
        onInit();
        resetAllButtons();

        //初めてベンチに座る場合
        if(sharedPreferences.getInt("oldMansionGardenBenchState", 0) == 0) {

            OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
            imageButton8.setOnClickListener(onClickGardenButton);

            stopAllButtons();
            mainText.setText("");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("oldMansionGardenBenchState", 1);
            editor.apply();
            MainActivity.soundPool.play(MainActivity.woodBrokenSound, 1.0f, 1.0f, 1, 0, 1);

            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startAllButtons();
                    imageButton8Text.setText("諦める");
                    mainText.setText("ベンチが壊れてしまった...。\n木が腐っていたようだ。");
                }
            }, 2000);
        //壊れたベンチに座ろうとした場合
        }else if(sharedPreferences.getInt("oldMansionGardenBenchState", 0) == 1){
            MainActivity.soundPool.play(MainActivity.oldWoodenDoorSound, 1.0f, 1.0f, 1, 0, 1);
            OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
            imageButton8.setOnClickListener(onClickGardenButton);
            imageButton8Text.setText("諦める");
            mainText.setText("このままでは座れない...。");
        //修理済みのベンチに座ろうとした場合
        }else if(sharedPreferences.getInt("oldMansionGardenBenchState", 0) == 2){
            //ベンチとブランコの両方が修理済みの場合
            if(sharedPreferences.getInt("oldMansionGardenBurankoState", 0) == 2 && !sharedPreferences.getBoolean("BBBothRepairedEvtDoneFlag", false)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("BBBothRepairedEvtDoneFlag", true);
                editor.apply();

                String bgmName = "nightSound";
                mediaPlayer = MediaPlayer.create(mMain, R.raw.night_sound);
                audioPlay(mediaPlayer, bgmName);
                mainText.setText("お前はベンチに座った。\nこれで修理は終わった。\n自分の住んでいる家がボロボロなのは気にくわないのだ。\nなかなか大変なだった...");
                imageButton8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageButton8.setEnabled(false);
                        imageButton8Text.setText("");
                        MainActivity.soundPool.play(MainActivity.warauSound, 1.0f, 1.0f, 1, 0, 1);
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                OnClickBBBothRepairedEvtButton onClickBBBothRepairedEvtButton = new OnClickBBBothRepairedEvtButton();
                                imageButton1.setOnClickListener(onClickBBBothRepairedEvtButton);
                                imageButton1Text.setText("立ち上がる");
                                mainText.setText("！！！");
                            }
                        }, 1500);
                    }
                });
                imageButton8Text.setText("黄昏る");
            //片方だけ修理済みの場合
            }else if(!sharedPreferences.getBoolean("BBEitherOneRepairedEvtDoneFlag", false) && !sharedPreferences.getBoolean("BBBothRepairedEvtDoneFlag", false)){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("BBEitherOneRepairedEvtDoneFlag", true);
                editor.apply();

                String bgmName = "nightSound";
                mediaPlayer = MediaPlayer.create(mMain, R.raw.night_sound);
                audioPlay(mediaPlayer, bgmName);
                mainText.setText("お前はベンチに座った。\n以外に大変な作業だった。\n庭はとても静かで風が心地いい、このままひと眠りしよう...");
                imageButton8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageButton8.setEnabled(false);
                        imageButton8Text.setText("");
                        MainActivity.soundPool.play(MainActivity.warauSound, 1.0f, 1.0f, 1, 0, 1);
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                OnClickBBEitherOneRepairedEvtButton onClickBBEitherOneRepairedEvtButton = new OnClickBBEitherOneRepairedEvtButton();
                                imageButton1.setOnClickListener(onClickBBEitherOneRepairedEvtButton);
                                imageButton1Text.setText("振り向く");
                                mainText.setText("！！！");
                            }
                        }, 1500);
                    }
                });
                imageButton8Text.setText("眠ろう...");
            }else{
                //普通にベンチに座った時の処理です
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
                imageButton8.setOnClickListener(onClickGardenButton);
                imageButton8Text.setText("戻る");
                mainText.setText("お前はベンチに座り、目をつぶった...\nどうしてこんな仕打ちを受けなければならないのか、これから何を信じて生きればいいのか...\n後に残されたのは命をものともしない無常な世の中だけだ。\n絶望と虚しさが溢れ、お前はうなだれた。");
            }
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
