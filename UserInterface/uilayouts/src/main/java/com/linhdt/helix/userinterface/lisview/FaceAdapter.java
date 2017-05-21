package com.linhdt.helix.userinterface.lisview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.linhdt.helix.userinterface.R;

import java.util.ArrayList;

/**
 * Created by DangThanhLinh on 18/05/2017.
 */

public class FaceAdapter extends BaseAdapter {
    private ArrayList<FaceItem> list = new ArrayList<>();
    private LayoutInflater minflater;
    public Context mContext;

    public FaceAdapter(Context mContext) {
        this.mContext = mContext;
        minflater = LayoutInflater.from(mContext);
        initData();
    }

    private void initData() {
        list.add(new FaceItem(R.drawable.ic_oh, "Oh"));
        list.add(new FaceItem(R.drawable.ic_matrix, "Matrix"));
        list.add(new FaceItem(R.drawable.ic_sweet_kiss, "Sweet kiss"));
        list.add(new FaceItem(R.drawable.ic_oh, "Oh"));
        list.add(new FaceItem(R.drawable.ic_matrix, "Matrix"));
        list.add(new FaceItem(R.drawable.ic_oh, "Oh"));
        list.add(new FaceItem(R.drawable.ic_matrix, "Matrix"));
        list.add(new FaceItem(R.drawable.ic_sweet_kiss, "Sweet kiss"));
        list.add(new FaceItem(R.drawable.ic_oh, "Oh"));
        list.add(new FaceItem(R.drawable.ic_matrix, "Matrix"));
        list.add(new FaceItem(R.drawable.ic_sweet_kiss, "Sweet kiss"));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public FaceItem getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            view = minflater.inflate(R.layout.item_listview, parent, false);
            holder = new ViewHolder();
            holder.imview = (ImageView) view.findViewById(R.id.iv_item);
            holder.tvview = (TextView) view.findViewById(R.id.tv_item);
            view.setTag(holder);

        }
        holder = (ViewHolder) view.getTag();
        holder.imview.setImageResource(list.get(position).getImage());
        holder.tvview.setText(list.get(position).getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, list.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private class ViewHolder {
        ImageView imview;
        TextView tvview;
    }
}
