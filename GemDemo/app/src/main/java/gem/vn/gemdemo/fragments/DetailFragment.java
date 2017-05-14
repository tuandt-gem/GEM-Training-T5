package gem.vn.gemdemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.gemdemo.R;
import gem.vn.gemdemo.models.Company;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;

    @BindView(R.id.tv_company_phone)
    TextView tvCompanyPhone;

    @BindView(R.id.tv_company_website)
    TextView tvCompanyWebsite;

    private Company company;

    public DetailFragment() {
        // Required empty public constructor
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        ButterKnife.bind(this, view);

        setInfo();

        return view;
    }

    private void setInfo() {
        tvCompanyName.setText(company.getName());
        tvCompanyPhone.setText(company.getPhone());
        tvCompanyWebsite.setText(company.getWebsiteUrl());
    }
}
