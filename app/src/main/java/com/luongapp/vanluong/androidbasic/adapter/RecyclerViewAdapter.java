package com.luongapp.vanluong.androidbasic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luongapp.vanluong.androidbasic.R;
import com.luongapp.vanluong.androidbasic.model.obj.DemoRecy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vanluong on 12/05/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DemoViewHolder> {

    private List<DemoRecy> demoRecies;
    private Context context;

    public RecyclerViewAdapter(List<DemoRecy> demoRecies, Context context){
        this.demoRecies=demoRecies;
        this.context=context;
    }

    @Override
    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_photo, null);
        DemoViewHolder demoViewHolder=new DemoViewHolder(layoutView, context, demoRecies);
        return demoViewHolder;
    }

    @Override
    public void onBindViewHolder(DemoViewHolder holder, int position) {
        Picasso.with(context).load(demoRecies.get(position).getIdImage())
                .resize(200, 200)
                .into(holder.imagePhoto);
            holder.textTime.setText(demoRecies.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return demoRecies.size();
    }

    public class DemoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imagePhoto;
        public TextView textTime;

        public DemoViewHolder(View itemView, Context context, List<DemoRecy> demoRecies) {
            super(itemView);

            imagePhoto= (ImageView) itemView.findViewById(R.id.image_photo);
            textTime= (TextView) itemView.findViewById(R.id.txt_time);

        }


        @Override
        public void onClick(View v) {

        }
    }


}
