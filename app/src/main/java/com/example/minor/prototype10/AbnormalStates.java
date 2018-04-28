package com.example.minor.prototype10;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.minor.prototype10.Models.PlayerInfo;

import io.realm.Realm;

//
public class AbnormalStates {
    PlayerInfo playerInfo;
    Realm realm;
    TextView poisonState, bleedingState;

    public void abnormalEffect(){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        if(playerInfo.isPoisonFlag()){
            int nowHp = playerInfo.getHP();
            int newHp = (int)(nowHp*0.98);
            realm.beginTransaction();
            playerInfo.setHP(newHp);
            realm.commitTransaction();
        }
        if(playerInfo.isBleedingFlag()){
            int nowHp = playerInfo.getHP();
            int nowMp = playerInfo.getMP();
            int newHp = (int)(nowHp*0.99);
            int newMp = (int)(nowMp*0.99);
            realm.beginTransaction();
            playerInfo.setHP(newHp);
            playerInfo.setMP(newMp);
            realm.commitTransaction();
        }
        realm.close();
    }

    public int[] battleAbnormalEffect(int[] tempAllStatus) {
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        int[] newAllStatus = tempAllStatus;
        if (playerInfo.isPoisonFlag()) {
            newAllStatus[0] = (int)(tempAllStatus[0]*0.98);
        }
        if (playerInfo.isBleedingFlag()) {
            newAllStatus[0] = (int)(tempAllStatus[0]*0.99);
            newAllStatus[1] = (int)(tempAllStatus[1]*0.99);
        }
        realm.close();
        return newAllStatus;
    }
}
