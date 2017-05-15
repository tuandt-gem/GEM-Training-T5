package gem.vn.gemdemo.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.gemdemo.R;
import gem.vn.gemdemo.adapters.CompanyAdapter;
import gem.vn.gemdemo.events.BroadcastEvent;
import gem.vn.gemdemo.events.OpenDetailFragmentEvent;
import gem.vn.gemdemo.events.OpenFragmentEvent;
import gem.vn.gemdemo.fragments.ContactFragment;
import gem.vn.gemdemo.fragments.DetailFragment;
import gem.vn.gemdemo.fragments.FirstFragment;
import gem.vn.gemdemo.models.Company;

public class MainActivity extends AppCompatActivity implements CompanyAdapter.OnItemAction {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.fl_container)
    FrameLayout flContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();
        changeFragment(new FirstFragment(), true);
    }

    private void initInstances() {
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    public void changeFragment(Fragment fragment, boolean addToBackStack) {
        if (addToBackStack) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }
    }

    @Subscribe
    public void onOpenFragmentEvent(OpenFragmentEvent e) {
        changeFragment(e.getFragment(), e.isAddToBackStack());
    }

    @Subscribe
    public void onBroadcastEvent(BroadcastEvent e) {
        Intent intent = new Intent();
        intent.setAction("vn.gem.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    @Override
    public void onItemClicked(int position, Company company) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setCompany(company);
        changeFragment(detailFragment, true);
    }

//    @Subscribe
//    public void onOpenDetailFragmentEvent(OpenDetailFragmentEvent e) {
//        DetailFragment detailFragment = new DetailFragment();
//        detailFragment.setCompany(e.getCompany());
//        changeFragment(detailFragment, true);
//    }

}
