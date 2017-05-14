package gem.vn.gemdemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gem.vn.gemdemo.R;
import gem.vn.gemdemo.models.Company;
import gem.vn.gemdemo.view.holders.CompanyViewHolder;

/**
 * Created by Lush on 5/15/2017.
 */

public class CompanyAdapter extends RecyclerView.Adapter<CompanyViewHolder> {

    @Override
    public CompanyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_company, parent, false);
        CompanyViewHolder companyViewHolder = new CompanyViewHolder(view);
        return companyViewHolder;
    }

    @Override
    public void onBindViewHolder(CompanyViewHolder holder, int position) {
        holder.bind(Company.COMPANIES[position]);
    }

    @Override
    public int getItemCount() {
        return Company.COMPANIES.length;
    }

}
