package gem.vn.gemdemo.events;

import android.support.v4.app.Fragment;

/**
 * Created by Lush on 5/14/2017.
 */

public class OpenFragmentEvent {
    private Fragment fragment;
    private boolean addToBackStack;

    public OpenFragmentEvent(Fragment fragment, boolean addToBackStack) {
        this.fragment = fragment;
        this.addToBackStack = addToBackStack;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public boolean isAddToBackStack() {
        return addToBackStack;
    }
}
