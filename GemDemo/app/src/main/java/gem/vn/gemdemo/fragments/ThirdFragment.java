package gem.vn.gemdemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.gemdemo.R;
import gem.vn.gemdemo.adapters.CompanyAdapter;
import gem.vn.gemdemo.models.Company;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    @BindView(R.id.rv_company)
    RecyclerView rvCompany;

    CompanyAdapter companyAdapter;
    private CompanyAdapter.OnItemAction onItemAction;
    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        ButterKnife.bind(this, view);
        setupUI();

        return view;
    }

    private void setupUI() {
        companyAdapter = new CompanyAdapter(onItemAction);
        rvCompany.setHasFixedSize(true);
        rvCompany.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//        rvCompany.setLayoutManager(new GridLayoutManager(this, GRID_LAYOUT_COLUMN));
        rvCompany.setAdapter(companyAdapter);
    }

    public void setOnItemAction(CompanyAdapter.OnItemAction onItemAction) {
        this.onItemAction = onItemAction;
    }
}
