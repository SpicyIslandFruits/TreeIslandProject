package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;

public class OnClickGardenCornerButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 20;
        onInit();
        resetAllButtons();
        String bgmName = "oldMansionBgm";
        mediaPlayer = MediaPlayer.create(mMain, R.raw.old_mansion_bgm);
        audioPlay(mediaPlayer, bgmName);
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        if(sharedPreferences.getInt("oldMansionGardenCornerSandRemoved", 0) == 0) {
            mainText.setText("土が不自然に盛り上がっている...");
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    //0が土をかぶっている状態、1が土をどかした状態です。
                    editor.putInt("oldMansionGardenCornerSandRemoved", 1);
                    editor.apply();
                    stopAllButtons();
                    //あとで音声を変える
                    MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
                    mainText.setText("目の前に扉が現れた...。\nこの先にはいったい何があるというのだろう。");
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
                    //地下室を作ります。街で素材を買ってブランコとベンチを修理すると幽霊が現れるのでそいつの指示に従うと鍵が手に入ります。
                    if(sharedPreferences.getBoolean("oldMansionBasementOpenFlag", false)){
                        OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
                        imageButton7.setOnClickListener(onClickEmptyButton);
                        imageButton7Text.setText("扉を開く");
                    }else{
                        imageButton7Text.setText("扉を開く");
                        imageButton7.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mainText.setText("扉には鍵がかかっている...");
                            }
                        });
                    }

                    imageButton8Text.setText("戻る");
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startAllButtons();
                        }
                    }, 1000);
                }
            });
            imageButton1Text.setText("土をどかす");
        }else if(sharedPreferences.getInt("oldMansionGardenCornerSandRemoved", 0) == 1){
            mainText.setText("扉が現れた...");
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

            //地下室を作ります。街で素材を買ってブランコとベンチを修理すると幽霊が現れるのでそいつの指示に従うと鍵が手に入ります。
            if(sharedPreferences.getBoolean("oldMansionBasementOpenFlag", false)){
                OnClickOldMansionEnterBasementButton onClickOldMansionEnterBasementButton = new OnClickOldMansionEnterBasementButton();
                imageButton7.setOnClickListener(onClickOldMansionEnterBasementButton);
                imageButton7Text.setText("扉を開く");
            }else{
                imageButton7Text.setText("扉を開く");
                imageButton7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainText.setText("扉には鍵がかかっている...");
                    }
                });
            }
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
