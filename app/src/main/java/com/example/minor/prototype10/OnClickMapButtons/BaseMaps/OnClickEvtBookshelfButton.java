package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.content.SharedPreferences;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.Models.ImportantItemName;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickEvtBookshelfButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 38;
        savePosition();
        resetAllButtons();
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
        }, 1500);
        OnClickEvtStudyButton onClickEvtStudyButton = new OnClickEvtStudyButton();
        imageButton8.setOnClickListener(onClickEvtStudyButton);
    }

    @Override
    public void onClick(View v) {
        createMap();
    }
}
