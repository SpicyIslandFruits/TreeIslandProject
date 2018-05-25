package com.example.minor.prototype10.OnClickMapButtons;

import android.content.SharedPreferences;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.Models.ImportantItemName;

import io.realm.Realm;

public class OnClickEvtBookshelfButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 38;
        savePosition();
        resetAllButtons();
        mainText.setText("古そうな書物が並んでいる...");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        imageButton1Text.setText("書物1を読む");
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("書物1の内容");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("本を閉じる");
                        OnClickEvtBookshelfButton onClickEvtBookshelfButton = new OnClickEvtBookshelfButton();
                        imageButton8.setOnClickListener(onClickEvtBookshelfButton);
                    }
                }, 800);
            }
        });
        imageButton2Text.setText("書物2を読む");
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("書物2の内容");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("本を閉じる");
                        OnClickEvtBookshelfButton onClickEvtBookshelfButton = new OnClickEvtBookshelfButton();
                        imageButton8.setOnClickListener(onClickEvtBookshelfButton);
                    }
                }, 800);
            }
        });
        imageButton3Text.setText("書物3を読む");
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.soundPool.play(MainActivity.horrorPianoSound, 1.0f, 1.0f, 1, 0, 1);
                        MainActivity.mediaPlayer.pause();
                        mainText.setText("おや？棚の奥の方で何かが光っている...");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("確認する");
                        imageButton8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                imageButton8.setEnabled(false);
                                imageButton8Text.setText("");
                                OnClickStudyButton onClickStudyButton = new OnClickStudyButton();
                                imageButton8.setOnClickListener(onClickStudyButton);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putBoolean("oldMansionGardenCornerKeyFoundFlag", true);
                                editor.apply();
                                realm.beginTransaction();
                                ImportantItemName importantItemName = realm.createObject(ImportantItemName.class);
                                importantItemName.setItemName("地下室の鍵");
                                realm.commitTransaction();
                                mainText.setText("これは...\n\nおそらく地下室の鍵だ。\nどうしてこんなところにあるのだろう...");
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageButton8.setEnabled(true);
                                        imageButton8Text.setText("戻る");
                                    }
                                }, 1000);
                            }
                        });
                    }
                }, 2000);
            }
        });
        OnClickEvtStudyButton onClickEvtStudyButton = new OnClickEvtStudyButton();
        imageButton8.setOnClickListener(onClickEvtStudyButton);
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
