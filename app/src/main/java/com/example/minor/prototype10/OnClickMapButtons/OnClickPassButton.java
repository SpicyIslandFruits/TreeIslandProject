package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

/**
 *　BGMを追加する。
 * 街でのバフやお守りをすべて消滅させる。
 */
public class OnClickPassButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.sampleSound1, 1.0f, 1.0f, 1, 0, 1);
        position = 5;
        savePosition();
        OnClickOldMansionButton onClickOldMansionButton = new OnClickOldMansionButton();
        imageButton7.setOnClickListener(onClickOldMansionButton);
        imageButton7Text.setText("古びた屋敷");
        changeBaseEnemyLevel(0);
        changeAdditionalEnemyLevel(0);
        int textNum;
        textNum = (int)(Math.random()*13 + 1);
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
                mainText.setText("青い氷のような風が吹き抜けて行く");
                break;
            case 8:
                mainText.setText("ここは寒い。");
                break;
            case 9:
                mainText.setText("もうすぐ日が沈む。");
                break;
            case 10:
                mainText.setText("ユグドラシルがハッキリと見える...この世界を体現する樹だ。");
                break;
            case 11:
                mainText.setText("人々はユグドラシルの下で暮らしている。");
                break;
            case 12:
                mainText.setText("外は危険だが、街の中はもっと危険だ");
                break;
            case 13:
                mainText.setText("世界を体現する樹...本当にそうなのか？ 確かに大きいが...");
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
