package com.example.minor.prototype10;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.minor.prototype10.Models.ArmorId;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * 武器アダプターを参考にして編集
 */
public class ArmorAdapter extends RealmBaseAdapter<ArmorId> {
    private static class ViewHolder{
        TextView armorName;
    }

    public ArmorAdapter(@Nullable OrderedRealmCollection<ArmorId> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.armorName = convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        ArmorId armorId = adapterData.get(position);
        MakeData makeData = new MakeData();
        viewHolder.armorName.setText(makeData.makeWeaponFromId(armorId.getArmorId()).getName());
        viewHolder.armorName.setMaxLines(1);
        return convertView;
    }
}
