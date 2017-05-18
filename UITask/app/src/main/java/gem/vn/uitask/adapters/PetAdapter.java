package gem.vn.uitask.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import gem.vn.uitask.R;

/**
 * Created by Lush on 5/17/2017.
 */

public class PetAdapter extends BaseAdapter {

    private static final String[] PETS_IMG_URL = new String[] {
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfGuQAWYSmggag95f1qxijH0p5gL8NbcpkebTyLCDh2_U3JPus",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRykb76Tx1SCwr4inuZ8umVMGNyCFPfVlI8DWwe2SY8D-lBBW8",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrZ3WnEQGRnntg-RCnOWe5qHGDP9Fi1Y1ueTfINrhWutWDgANj",
            "http://s1.img.yan.vn//YanNews/2167221/201503/20150314-025106-4_520x345.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTl1rL7Xi4WPEfTbpKKcUhkf_5L_zYuGlwtPEcpo1C33bCDgRgF9w",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTasyUd5AXp2xwI7eGSS8DCD9Tmuf-VPt8Nr4De-shelrxRD18JQg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfZv2asMojPuNb0Y37oPHHd0S6vBx_e1R6ithnJTfCLwN0SLF6jw",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTOo1hds8-BCXoMbqZqQy4zaGLp4eT-HbTbFlBMHfcgB3HsEVvTg"
    };

    private Context mContext;

    public PetAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return PETS_IMG_URL.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        Picasso.with(mContext).load(PETS_IMG_URL[position]).into(imageView);
        return imageView;
    }

}
