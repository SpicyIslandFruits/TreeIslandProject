package com.example.minor.prototype10;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.minor.prototype10.Models.ImportantItemId;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * 編集の必要なし
 */
public class ImportantItemAdapter extends RealmBaseAdapter<ImportantItemId> {
    private static class ViewHolder{
        TextView importantItemName;
    }

    public ImportantItemAdapter(@Nullable OrderedRealmCollection<ImportantItemId> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImportantItemAdapter.ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new ImportantItemAdapter.ViewHolder();
            viewHolder.importantItemName = convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ImportantItemAdapter.ViewHolder)convertView.getTag();
        }

        ImportantItemId importantItemId = adapterData.get(position);
        MakeData makeData = new MakeData();
        viewHolder.importantItemName.setText(makeData.makeItemFromName(importantItemId.getItemName()).getName());
        viewHolder.importantItemName.setMaxLines(1);
        return convertView;
    }
}
