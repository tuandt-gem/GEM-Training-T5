package giaodien.admin.listview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 01/04/2017.
 */

public class CustomAdapter extends ArrayAdapter<Pokemon> {


    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Pokemon> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.my_item_layout,null);

        Pokemon pkm = getItem(position);
        TextView txtvitem = (TextView) convertView.findViewById(R.id.txtvitem);
        txtvitem.setText(pkm.toString());

        ImageView imgitem = (ImageView) convertView.findViewById(R.id.imgitem);
        String gen = pkm.getGen();
        switch (gen){
            case "Gen1":
                imgitem.setImageResource(R.drawable.img_1);
                break;
            case "Gen2":
                imgitem.setImageResource(R.drawable.img_2);
                break;
            case "Gen3":
                imgitem.setImageResource(R.drawable.img_3);
                break;
            case "Gen4":
                imgitem.setImageResource(R.drawable.img_4);
                break;
            case "Gen5":
                imgitem.setImageResource(R.drawable.img_5);
                break;
        }

        return convertView;
    }


}
