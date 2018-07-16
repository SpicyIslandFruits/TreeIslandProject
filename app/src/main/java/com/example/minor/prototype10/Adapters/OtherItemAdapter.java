package com.example.minor.prototype10.Adapters;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.minor.prototype10.Models.OtherItemName;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

public class OtherItemAdapter extends RealmBaseAdapter<OtherItemName> {
    private static class ViewHolder{
        TextView otherItemName;
    }

    public OtherItemAdapter(@Nullable OrderedRealmCollection<OtherItemName> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OtherItemAdapter.ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new OtherItemAdapter.ViewHolder();
            viewHolder.otherItemName = convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (OtherItemAdapter.ViewHolder)convertView.getTag();
        }

        OtherItemName otherItemName = adapterData.get(position);
        viewHolder.otherItemName.setText(otherItemName.getOtherItemName());
        viewHolder.otherItemName.setMaxLines(1);
        return convertView;
    }
}
