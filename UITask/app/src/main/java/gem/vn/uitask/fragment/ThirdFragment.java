package gem.vn.uitask.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gem.vn.uitask.R;
import gem.vn.uitask.activities.MainActivity;
import gem.vn.uitask.adapters.CompanyAdapter;
import gem.vn.uitask.adapters.PetAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    @BindView(R.id.gv_pets)
    GridView gvPets;

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
        gvPets.setAdapter(new PetAdapter(getContext()));
        companyAdapter = new CompanyAdapter(onItemAction);
        rvCompany.setHasFixedSize(true);
//        rvCompany.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvCompany.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        rvCompany.setAdapter(companyAdapter);
    }

    public void setOnItemAction(CompanyAdapter.OnItemAction onItemAction) {
        this.onItemAction = onItemAction;
    }

    @OnClick(R.id.bt_next_fragment)
    public void onClick() {
        ((MainActivity) getActivity()).changeFragment(new FourthFragment(), true);
    }

}
