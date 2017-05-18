package gem.vn.uitask.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gem.vn.uitask.R;
import gem.vn.uitask.adapters.CompanyAdapter;
import gem.vn.uitask.fragment.DetailFragment;
import gem.vn.uitask.fragment.FirstFragment;
import gem.vn.uitask.models.Company;

public class MainActivity extends AppCompatActivity implements CompanyAdapter.OnItemAction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(new FirstFragment(), true);
    }

    public void changeFragment(Fragment fragment, boolean addToBackStack) {
        if (addToBackStack) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onItemClicked(int position, Company company) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setCompany(company);
        changeFragment(detailFragment, true);
    }
}
