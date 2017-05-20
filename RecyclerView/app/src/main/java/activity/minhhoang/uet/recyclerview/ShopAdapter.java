package activity.minhhoang.uet.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by MINHHOANG-PC on 20/05/2017.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    ArrayList<DataShop> dataShops;
    Context context;

    public ShopAdapter(ArrayList<DataShop> dataShops, Context context) {
        this.dataShops = dataShops;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(dataShops.get(position).getTxtName());
        holder.imgItem.setImageResource(dataShops.get(position).getImgImageItem());
    }

    @Override
    public int getItemCount() {
        return dataShops.size();
    }
    public void RemoveItem(int position){
        dataShops.remove(position);
        notifyItemRemoved(position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView imgItem;
        public ViewHolder(final View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            imgItem = (ImageView) itemView.findViewById(R.id.imgItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RemoveItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(),"Remove" + txtName.getText(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
