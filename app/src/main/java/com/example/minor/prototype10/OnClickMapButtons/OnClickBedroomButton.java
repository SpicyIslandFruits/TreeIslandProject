package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickBedroomButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 13;
        savePosition();
        resetAllButtons();
        mainText.setText("お前は小さな白木のベッドに横たわった。\nなぜだろう、ここは不思議と安心できるのだ。\n瞳を閉じると布団の柔らかい感触が包み込んでくる。");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton1Text.setText("");
                imageButton8Text.setText("");
                MainActivity.mediaPlayer.pause();
                MainActivity.soundPool.play(MainActivity.oldMansionSleepSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                int textNum;
                textNum = (int)(Math.random()*8 + 1);
                switch (textNum){
                    case 1:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\nおまえは走り続けていた。人には決して辿り着けないどこかを目指して...。");
                        break;
                    case 2:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\n何かがお前を見つめていた。底知れない憎悪の眼差しで...。");
                        break;
                    case 3:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\nお前は何かの鼓動を聞いた。ゆっくりと成長を続けるそれは、確実に世界を蝕んでいた...。");
                        break;
                    case 4:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\nおまえは認識できない何かの存在を恐れていた。この世界に存在する生命がそれを知ることは、決して許されることではなかった。");
                        break;
                    case 5:
                        mainText.setText("何かにいざなわれるように、お前は深い眠りについた。");
                        break;
                    case 6:
                        mainText.setText("家主はどんな人だったのだろう...。どうしてこんなところに住もうと思ったのだろう...。\nそんなことを考えているうちに意識が朦朧として、お前は眠りについた。");
                        break;
                    case 7:
                        mainText.setText("お前はいつも劣っていた、しかしあの頃のお前には見守ってくれる存在もいたのかもしれない。\n過ぎ去った過去に思いをはせているうちに、お前は眠気に身を委ねていった。");
                        break;
                    case 8:
                        mainText.setText("お前には何も残されていなかった。\nお前はこれからのことに考えを巡らせたが、何も得られるものはなかった。\nそうこうしているうちに、お前は眠りに誘われていった。");
                        break;
                }
                realm.beginTransaction();
                playerInfo.setHP(playerInfo.getFmaxHP());
                playerInfo.setMP(playerInfo.getFmaxMP());
                realm.commitTransaction();
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButton1Text.setText("眠る");
                        imageButton8Text.setText("戻る");
                        mainText.setText("目覚めると傷が癒えていた。\n周囲を見渡して、お前はあることに気付く。\n\n時間が経っていない...。\n\n何度も目を疑ったが、お前は現実を受け入れるしかなかった。");
                        startAllButtons();
                    }
                }, 6500);
            }
        });
        imageButton1Text.setText("眠る");


        OnClickOldMansion2FButton onClickOldMansion2FButton = new OnClickOldMansion2FButton();
        imageButton8.setOnClickListener(onClickOldMansion2FButton);
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
