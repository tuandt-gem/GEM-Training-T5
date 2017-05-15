package gem.vn.gemdemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.gemdemo.R;
import gem.vn.gemdemo.adapters.ContactAdapter;
import gem.vn.gemdemo.models.Contact;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

    @BindView(R.id.rv_contacts)
    RecyclerView rvContacts;

    private ContactAdapter contactAdapter;

    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        setupUI(view);
        return view;
    }

    private void setupUI(View v) {
        ButterKnife.bind(this, v);
        contactAdapter = new ContactAdapter();
        rvContacts.setHasFixedSize(true);
        rvContacts.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        rvContacts.setAdapter(contactAdapter);
    }

}
