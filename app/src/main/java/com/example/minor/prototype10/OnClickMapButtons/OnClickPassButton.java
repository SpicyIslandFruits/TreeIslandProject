package com.example.minor.prototype10.OnClickMapButtons;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Toast;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.Models.AmuletName;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickBossRoomButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickEmptyButton;
import com.example.minor.prototype10.OnClickMapButtons.BaseMaps.OnClickOldMansionButton;
import com.example.minor.prototype10.OnClickMapButtons.TownMaps.OnClickEnterTown1FButton;
import com.example.minor.prototype10.R;

import io.realm.RealmResults;

/**
 * BGMを追加する。
 */
public class OnClickPassButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        position = 5;
        onInit();
        String bgmName = "passSound";
        mediaPlayer = MediaPlayer.create(mMain, R.raw.pass_sound);
        audioPlay(mediaPlayer, bgmName);

        if(playerInfo.getLUK() != playerInfo.getfLUK() || playerInfo.getSP() != playerInfo.getfSP() || playerInfo.getMaxMP() != playerInfo.getFmaxMP()){
            Toast toast = Toast.makeText(MainActivity.context, "お守りや補助効果が消滅した", Toast.LENGTH_SHORT);
            toast.show();
        }

        realm.beginTransaction();
        playerInfo.setfLUK(playerInfo.getLUK());
        playerInfo.setfSP(playerInfo.getSP());
        playerInfo.setFmaxMP(playerInfo.getMaxMP());
        RealmResults<AmuletName> amuletNames = realm.where(AmuletName.class).findAll();
        amuletNames.deleteAllFromRealm();
        realm.commitTransaction();

        //戦闘処理のテストのために一時的にボスマップとつなげてあります
        OnClickBossRoomButton onClickEmptyButton1 = new OnClickBossRoomButton();
        imageButton1.setOnClickListener(onClickEmptyButton1);
        imageButton1Text.setText("ダンジョン1");

        OnClickEmptyButton onClickEmptyButton2 = new OnClickEmptyButton();
        imageButton2.setOnClickListener(onClickEmptyButton2);
        imageButton2Text.setText("ダンジョン2");

        OnClickEmptyButton onClickEmptyButton3 = new OnClickEmptyButton();
        imageButton3.setOnClickListener(onClickEmptyButton3);
        imageButton3Text.setText("ダンジョン3");

        OnClickEmptyButton onClickEmptyButton4 = new OnClickEmptyButton();
        imageButton4.setOnClickListener(onClickEmptyButton4);
        imageButton4Text.setText("ダンジョン4");

        OnClickEmptyButton onClickEmptyButton5 = new OnClickEmptyButton();
        imageButton5.setOnClickListener(onClickEmptyButton5);
        imageButton5Text.setText("ダンジョン5");

        OnClickEmptyButton onClickEmptyButton6 = new OnClickEmptyButton();
        imageButton6.setOnClickListener(onClickEmptyButton6);
        imageButton6Text.setText("ダンジョン6");

        OnClickOldMansionButton onClickOldMansionButton = new OnClickOldMansionButton();
        imageButton7.setOnClickListener(onClickOldMansionButton);
        imageButton7Text.setText("古びた屋敷");

        final OnClickEnterTown1FButton onClickEnterTown1FButton = new OnClickEnterTown1FButton();
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAllButtons();
                mainText.setText("・");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("・・");
                    }
                }, 1100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("・・・");
                    }
                }, 2100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("・・・・");
                    }
                }, 3100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("・・・・・");
                    }
                }, 4100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("・・・・・・");
                    }
                }, 5100);
                MainActivity.soundPool.play(MainActivity.walkTussockSound, 1.0f, 1.0f, 1, 0, 1);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.soundPool.play(MainActivity.chapelBellSound, 1.0f, 1.0f, 1, 0, 1);
                    }
                }, 6000);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onClickEnterTown1FButton.createMap();
                    }
                }, 6300);
            }
        });
        imageButton8Text.setText("街に行く");

        changeBaseEnemyLevel(0);
        changeAdditionalEnemyLevel(0);
        int textNum;
        textNum = (int)(Math.random()*12 + 1);
        switch (textNum){
            case 1:
                mainText.setText("どこへ行こう...。");
                break;
            case 2:
                mainText.setText("狼の遠吠えが聴こえる。");
                break;
            case 3:
                mainText.setText("外は街よりも静かだ。");
                break;
            case 4:
                mainText.setText("遠くに街が見える。");
                break;
            case 5:
                mainText.setText("この先に人の気配はない。");
                break;
            case 6:
                mainText.setText("この先は黒く沈んでいる...何がいてもおかしくない");
                break;
            case 7:
                mainText.setText("青い氷のような風がお前の横を吹き抜けて行く");
                break;
            case 8:
                mainText.setText("ここは寒い。");
                break;
            case 9:
                mainText.setText("もうすぐ日が沈む。");
                break;
            case 10:
                mainText.setText("ユグドラシルがはっきりと見える...\nこの世界を体現する樹だ。");
                break;
            case 11:
                mainText.setText("人々はユグドラシルの下で暮らしている。");
                break;
            case 12:
                mainText.setText("外は危険だが、街の中はもっと危険だ");
                break;
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
