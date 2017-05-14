package gem.vn.gemdemo.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.gemdemo.R;
import gem.vn.gemdemo.events.BroadcastEvent;
import gem.vn.gemdemo.events.OpenDetailFragmentEvent;
import gem.vn.gemdemo.events.OpenFragmentEvent;
import gem.vn.gemdemo.fragments.DetailFragment;
import gem.vn.gemdemo.fragments.FirstFragment;

public class MainActivity extends AppCompatActivity {

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

    private void changeFragment(Fragment fragment, boolean addToBackStack) {
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

    @Subscribe
    public void onEvent(OpenDetailFragmentEvent openFragmentEvent) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setCompany(openFragmentEvent.getCompany());
        changeFragment(detailFragment, true);
    }

}
