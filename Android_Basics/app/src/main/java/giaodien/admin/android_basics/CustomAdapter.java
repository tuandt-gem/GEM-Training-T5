package giaodien.admin.android_basics;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 20/05/2017.
 */

public class CustomAdapter extends ArrayAdapter<Song> {

    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.activity_song_row,null);

        Song song = getItem(position);

        TextView txtTen = (TextView) convertView.findViewById(R.id.txtTen);
        TextView txtCaSi = (TextView) convertView.findViewById(R.id.txtCaSi);
        TextView txtTrangThai = (TextView) convertView.findViewById(R.id.txtTrangThai);

        txtTen.setText(song.getTen());
        txtCaSi.setText(song.getCaSi());
        txtTrangThai.setText(song.getTrangThai());

        return convertView;
    }
}
