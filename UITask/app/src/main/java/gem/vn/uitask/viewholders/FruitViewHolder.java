package gem.vn.uitask.viewholders;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.uitask.R;
import gem.vn.uitask.models.Fruit;

/**
 * Created by Lush on 5/17/2017.
 */

public class FruitViewHolder {

    private static final String TAG = FruitViewHolder.class.toString();

    @BindView(R.id.iv_fruit)
    ImageView ivFruit;

    @BindView(R.id.tv_fruit_name)
    TextView tvFruitName;

    @BindView(R.id.tv_fruit_cost)
    TextView tvFruitCost;

    public FruitViewHolder(View view) {
        ButterKnife.bind(this, view);
    }

    public void setData(Fruit fruit, Context context) {
        Log.d(TAG, fruit.getImgURL());
        Picasso.with(context).load(fruit.getImgURL())
                .centerCrop()
                .resize(100, 100).into(ivFruit);
        tvFruitName.setText(fruit.getName());
        tvFruitCost.setText(fruit.getCost());
    }

}
