package com.cts.mybudget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.List;

/**
 * Created by Ali on 4/8/16.
 */
public class MyCustomAdapter extends ArrayAdapter<CharSequence> {

    List<CharSequence> textData,
            smallTextData;

    public MyCustomAdapter (Context context, List<CharSequence> textData) {
        super (context, -1, textData);

        this.textData = textData;
        this.smallTextData = smallTextData;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)getContext ()
                        .getSystemService (Context.LAYOUT_INFLATER_SERVICE);

        View itemListingRow = layoutInflater.inflate (R.layout.item_listing_row, parent, false);

        CheckBox itemCheckBox = (CheckBox) itemListingRow.findViewById(R.id.itemCheckBox);

        itemCheckBox.setText (textData.get (position));

        return itemListingRow;
    }
}
