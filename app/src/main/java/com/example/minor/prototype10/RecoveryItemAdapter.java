package com.example.minor.prototype10;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.minor.prototype10.Models.RecoveryItemName;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

public class RecoveryItemAdapter extends RealmBaseAdapter<RecoveryItemName> {
    private static class ViewHolder{
        TextView recoveryItemName;
    }

    public RecoveryItemAdapter(@Nullable OrderedRealmCollection<RecoveryItemName> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecoveryItemAdapter.ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new RecoveryItemAdapter.ViewHolder();
            viewHolder.recoveryItemName = convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (RecoveryItemAdapter.ViewHolder)convertView.getTag();
        }

        RecoveryItemName recoveryItemName = adapterData.get(position);
        MakeData makeData = new MakeData();
        viewHolder.recoveryItemName.setText(makeData.makeItemFromName(recoveryItemName.getItemName()).getName());
        viewHolder.recoveryItemName.setMaxLines(1);
        return convertView;
    }
}
