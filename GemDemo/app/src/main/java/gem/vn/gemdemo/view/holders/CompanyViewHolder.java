package gem.vn.gemdemo.view.holders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.gemdemo.R;
import gem.vn.gemdemo.events.OpenDetailFragmentEvent;
import gem.vn.gemdemo.events.OpenFragmentEvent;
import gem.vn.gemdemo.fragments.DetailFragment;
import gem.vn.gemdemo.models.Company;

/**
 * Created by Lush on 5/15/2017.
 */

public class CompanyViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = CompanyViewHolder.class.toString();
    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;

    @BindView(R.id.iv_company)
    ImageView ivCompany;

    public CompanyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Company company) {
        Picasso.with(this.itemView.getContext()).load(company.getLogoUrl()).into(ivCompany);
        Log.d(TAG, company.getLogoUrl());
        tvCompanyName.setText(company.getName());
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDetailFragmentEvent e = new OpenDetailFragmentEvent(
                        new DetailFragment(), false
                );

                e.setCompany(company);

                EventBus.getDefault().post(e);
            }
        });
    }

}
