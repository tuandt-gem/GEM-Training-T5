package com.linhdt.helix.userinterface.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.linhdt.helix.userinterface.R;
import com.linhdt.helix.userinterface.lisview.FaceItem;

import java.util.List;

/**
 * Created by DangThanhLinh on 18/05/2017.
 */

public class AdapterRecycle extends RecyclerView.Adapter<AdapterRecycle.MyViewHolder> {
    private List<FaceItem> list;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public AdapterRecycle(Context mContext, List<FaceItem> list) {
        this.mContext = mContext;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mLayoutInflater.inflate(R.layout.item_listview, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FaceItem faceItem = list.get(position);
        holder.image.setImageResource(faceItem.getImage());
        holder.name.setText(faceItem.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.iv_item);
            name = (TextView) itemView.findViewById(R.id.tv_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, name.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
