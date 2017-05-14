package gem.vn.gemdemo.events;

import android.support.v4.app.Fragment;

import gem.vn.gemdemo.models.Company;

/**
 * Created by Lush on 5/15/2017.
 */

public class OpenDetailFragmentEvent {

    private Fragment fragment;
    private boolean addToBackStack;
    private Company company;

    public OpenDetailFragmentEvent(Fragment fragment, boolean addToBackStack) {
        this.fragment = fragment;
        this.addToBackStack = addToBackStack;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public boolean isAddToBackStack() {
        return addToBackStack;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
