package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickGardenCornerButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 20;
        savePosition();
        resetAllButtons();
        mainText.setText("土が不自然に盛り上がっている...。");
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);

        //イベントによってbgmが止められていた場合再生しなおす。

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAllButtons();
                //あとで音声を変える
                MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
                mainText.setText("目の前に扉が現れた...。\nこの先にはいったい何があるというのだろう。");
                OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
                imageButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopAllButtons();
                        MainActivity.mediaPlayer.pause();
                        imageButton8Text.setText("戻る");
                        MainActivity.soundPool.play(MainActivity.burstSound, 1.0f, 1.0f, 1, 0, 1);
                        mainText.setText("お前はありったけの力を振り絞り、魔法を放った！");
                        realm.beginTransaction();
                        playerInfo.setMP(0);
                        realm.commitTransaction();
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                MainActivity.mediaPlayer.start();
                                mainText.setText("...しかし扉はびくともしない。\n\nどうやら魔力が足りなかったようだ...。");
                                startAllButtons();
                            }
                        }, 6500);
                    }
                });
                imageButton1Text.setText("爆破する");
                imageButton8Text.setText("戻る");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() { startAllButtons();
                    }
                }, 1000);
            }
        });
        imageButton1Text.setText("土をどかす");

        //地下室を作ります。街で素材を買ってブランコとベンチを修理すると幽霊が現れるのでそいつの指示に従うと鍵が手に入ります。
        if(sharedPreferences.getBoolean("oldMansionGardenCornerKeyFoundedFlag", false)
                ){
            OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
            imageButton7.setOnClickListener(onClickEmptyButton);
            imageButton7Text.setText("鍵を使う");
        }

        OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
        imageButton8.setOnClickListener(onClickGardenButton);
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
