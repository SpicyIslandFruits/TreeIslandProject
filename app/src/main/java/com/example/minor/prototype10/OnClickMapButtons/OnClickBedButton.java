package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class
OnClickBedButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 17;
        savePosition();
        resetAllButtons();
        mainText.setText("お前は小さな白木のベッドに横たわった。\nなぜだろう、ここは不思議と安心できるのだ。\n瞳を閉じると布団の柔らかい感触が包み込んでくる。");
        MainActivity.soundPool.play(MainActivity.oldMansionBedSound, 1.0f, 1.0f, 1, 0, 1);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton1Text.setText("");
                imageButton8Text.setText("");
                MainActivity.mediaPlayer.pause();
                MainActivity.soundPool.play(MainActivity.oldMansionSleepSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                int textNum;
                textNum = (int)(Math.random()*12 + 1);
                //ここはもっと増やしたい
                switch (textNum){
                    case 1:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\nおまえは何かを求めて走り続けていた。\n人の身であるお前では、そこに辿り着けるはずがない。\nしかし諦めることを知らないお前は、どんどんこの世の理から外れていった。");
                        break;
                    case 2:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\n何かがお前を見つめている。\nその眼には底知れない憎悪が宿っていた。");
                        break;
                    case 3:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\nお前は何かの鼓動を聞いた。ゆっくりと成長を続けるそれは、確実に世界を蝕んでいた...。");
                        break;
                    case 4:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\nおまえは認識できない何かの存在を恐れていた。\nこの世界に存在する生命がそれを知ることは許されることではなかった。");
                        break;
                    case 5:
                        mainText.setText("お前には生まれた瞬間の記憶が一つだけ残っている。\nとても大きな扉の、鍵が開く音を聞いたのだ。\n小さな産小屋で生まれたお前がどうしてそんな音を聞いたのか、今となっては謎である\nそんな過去の小さな出来事を辿っているうちに、何かに誘われるように深い眠りについた。");
                        break;
                    case 6:
                        mainText.setText("家主はどんな人だったのだろう...。どうしてこんなところに住もうと思ったのだろう...。\nそんなことを考えているうちに意識が朦朧として、お前は眠りについた。");
                        break;
                    case 7:
                        mainText.setText("お前はいつも劣っていた、しかしあの頃のお前には見守ってくれる存在もいたのかもしれない。\n過ぎ去った過去に思いをはせているうちに、お前は眠気に身を委ねていった。");
                        break;
                    case 8:
                        mainText.setText("お前には何も残されていなかった。\nお前はこれからのことに考えを巡らせたが、何も得られるものはなかった。\nそうこうしているうちにお前は眠りについた。");
                        break;
                    case 9:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\nお前は何かから逃げ続けている。\n想像によって肥大化するそれは、果たして生命と呼んでいいのかわからなかった。");
                        break;
                    case 10:
                        mainText.setText("お前はふと考えた。\n自分はなぜこの屋敷にたどり着けたのだろうか。\nしかしいくら考えても答えは出てこない。\nそうこうしているうちにお前は眠気に誘われていった。");
                        break;
                    case 11:
                        mainText.setText("お前は奇妙な夢を見た...。\n何かがお前からすべてを奪い去ろうとしている。\nお前を取り巻くこの世界さえも巻き込んで...。");
                        break;
                    case 12:
                        mainText.setText("最近よく夢を見る...。\nぼんやりとして得体のしれないものばかりだが、不思議と感情だけははっきりと伝わってくる。\n思い出そうとしているうちに意識が朦朧として、お前は眠りについた。");
                }
                realm.beginTransaction();
                playerInfo.setHP(playerInfo.getFmaxHP());
                playerInfo.setMP(playerInfo.getFmaxMP());
                realm.commitTransaction();
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButton1Text.setText("眠る");
                        imageButton8Text.setText("起き上がる");
                        mainText.setText("目覚めると傷が癒えていた。\n周囲を見渡して、お前はあることに気付く。\n\n時間が経っていない...。\n\n何度も目を疑ったが、お前は現実を受け入れるしかなかった。");
                        startAllButtons();
                    }
                }, 6500);
            }
        });
        imageButton1Text.setText("眠る");

        OnClickBedroomButton onClickBedroomButton = new OnClickBedroomButton();
        imageButton8.setOnClickListener(onClickBedroomButton);
        imageButton8Text.setText("起き上がる");
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
