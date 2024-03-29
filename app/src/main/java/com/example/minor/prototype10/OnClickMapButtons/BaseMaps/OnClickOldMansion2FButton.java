package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;

public class OnClickOldMansion2FButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 11;
        onInit();
        String bgmName = "oldMansionBgm";
        mediaPlayer = MediaPlayer.create(mMain, R.raw.old_mansion_bgm);
        audioPlay(mediaPlayer, bgmName);
        if(!MainActivity.mediaPlayer.isPlaying()){
            MainActivity.mediaPlayer.start();
        }

        //読ませる工夫をする。
        //次から、イベントを作セする際は、一つ一つのイベントすべてに対してFlagを立ててtrueの時は実行falseの時は実行しないようにする。数字で一元管理すると場合分けがめんどくさい。
        if(sharedPreferences.getBoolean("oldMansionGhostRunAwayFlag", false)){
            //此処の音声を変えて、イベントが終わったことが分かり易いようにする。
            MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
            mainText.setText("あれは何だったのだろうか......\n既に飛び去って行ってしまった今、お前に確認するすべはない。");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("oldMansionGhostRunAwayFlag", false);
            editor.apply();
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    OnClickRooftopButton onClickRooftopButton = new OnClickRooftopButton();
                    imageButton1.setOnClickListener(onClickRooftopButton);
                    imageButton1Text.setText("屋上");
                    OnClickStudyButton onClickStudyButton = new OnClickStudyButton();
                    imageButton2.setOnClickListener(onClickStudyButton);
                    imageButton2Text.setText("書斎");
                    OnClickBedroomButton onClickBedroomButton = new OnClickBedroomButton();
                    imageButton3.setOnClickListener(onClickBedroomButton);
                    imageButton3Text.setText("寝室");
                    OnClickOldMansion1FButton onClickOldMansion1FButton = new OnClickOldMansion1FButton();
                    imageButton8.setOnClickListener(onClickOldMansion1FButton);
                    imageButton8Text.setText("1階に降りる");
                }
            }, 3000);
        }else {
            //元の文章
            //お前は2階へと上がっていった...。
            //部屋は最小限の家具しかなく、広く、静かで、がらんとしている。
            //古い家具や、置き去りにされた敷物の醸し出す匂いは、どこか懐かしい感じがした。
            mainText.setText("お前は2階へと上がっていった...。\n部屋は、広く、静かで、がらんとしている。");
            MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
            OnClickRooftopButton onClickRooftopButton = new OnClickRooftopButton();
            imageButton1.setOnClickListener(onClickRooftopButton);
            imageButton1Text.setText("屋上");
            OnClickStudyButton onClickStudyButton = new OnClickStudyButton();
            imageButton2.setOnClickListener(onClickStudyButton);
            imageButton2Text.setText("書斎");
            OnClickBedroomButton onClickBedroomButton = new OnClickBedroomButton();
            imageButton3.setOnClickListener(onClickBedroomButton);
            imageButton3Text.setText("寝室");
            OnClickOldMansion1FButton onClickOldMansion1FButton = new OnClickOldMansion1FButton();
            imageButton8.setOnClickListener(onClickOldMansion1FButton);
            imageButton8Text.setText("1階に降りる");
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
