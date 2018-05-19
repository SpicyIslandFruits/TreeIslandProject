package com.example.minor.prototype10;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.minor.prototype10.Models.AmuletName;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

public class AmuletAdapter extends RealmBaseAdapter<AmuletName> {
    private static class ViewHolder{
        TextView amuletName;
    }

    public AmuletAdapter(@Nullable OrderedRealmCollection<AmuletName> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AmuletAdapter.ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new AmuletAdapter.ViewHolder();
            viewHolder.amuletName = convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (AmuletAdapter.ViewHolder)convertView.getTag();
        }

        AmuletName amuletName = adapterData.get(position);
        viewHolder.amuletName.setText(amuletName.getAmuletName());
        viewHolder.amuletName.setMaxLines(1);
        return convertView;
    }
}
