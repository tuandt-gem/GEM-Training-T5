package gem.vn.uitask.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import gem.vn.uitask.R;
import gem.vn.uitask.models.Fruit;
import gem.vn.uitask.viewholders.FruitViewHolder;

/**
 * Created by Lush on 5/17/2017.
 */

public class FruitAdapter extends ArrayAdapter {
    public FruitAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_fruit, parent, false);
        }
        new FruitViewHolder(convertView).setData(Fruit.FRUITS[position], getContext());
        return convertView;
    }
}
