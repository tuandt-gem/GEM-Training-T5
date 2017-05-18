package gem.vn.uitask.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.uitask.R;
import gem.vn.uitask.adapters.CompanyAdapter;
import gem.vn.uitask.models.Company;

/**
 * Created by Lush on 5/17/2017.
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

    public void bind(final int position, final Company company, final CompanyAdapter.OnItemAction onItemAction) {
        Picasso.with(this.itemView.getContext()).load(company.getLogoUrl()).into(ivCompany);
        Log.d(TAG, company.getLogoUrl());
        tvCompanyName.setText(company.getName());
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemAction != null) {
                    onItemAction.onItemClicked(position, company);
                }
            }
        });
    }

}
