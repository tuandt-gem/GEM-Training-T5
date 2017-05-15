package gem.vn.gemdemo.fragments;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import gem.vn.gemdemo.R;
import gem.vn.gemdemo.events.BroadcastEvent;
import gem.vn.gemdemo.events.OpenFragmentEvent;
import gem.vn.gemdemo.models.Contact;
import gem.vn.gemdemo.services.MyService;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private static final String TAG = FirstFragment.class.toString();

    @BindView(R.id.bt_start_service)
    Button btStartService;

    @BindView(R.id.bt_stop_service)
    Button btStopService;

    @BindView(R.id.bt_content_provider)
    Button btContentProvider;

    @BindView(R.id.bt_broadcast)
    Button btBroadcast;

    @BindView(R.id.bt_next_fragment)
    Button btNextFragment;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        initInstances(view);
        addListeners();

        return view;
    }

    private void initInstances(View v) {
        ButterKnife.bind(this, v);
    }

    private void addListeners() {
        btStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(new Intent(getActivity(), MyService.class));
            }
        });

        btStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(new Intent(getActivity(), MyService.class));
            }
        });

        btContentProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Getting contacts, tap to call", Toast.LENGTH_SHORT).show();
                Contact.CONTACTS = contactsList();
                Log.d(TAG, String.valueOf(Contact.CONTACTS.size()));
                EventBus.getDefault().post(new OpenFragmentEvent(new ContactFragment(), true));
            }
        });

        btBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new BroadcastEvent());
            }
        });

        btNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new OpenFragmentEvent(new SecondFragment(), true));
            }
        });
    }

    private ArrayList<Contact> contactsList() {
        ArrayList<String> nameList = new ArrayList<String>();
        Cursor nameCursor = getActivity().getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                new String[] {ContactsContract.Contacts.DISPLAY_NAME},
                null, null, null
        );
        while (nameCursor.moveToNext()) {
            nameList.add(nameCursor.getString(nameCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
        }
        nameCursor.close();

        ArrayList<String> phoneList = new ArrayList<>();
        Cursor phones = getActivity().getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[] {ContactsContract.CommonDataKinds.Phone.NUMBER},
                null, null, null
        );
        while (phones.moveToNext()) {
            phoneList.add(phones.getString(phones.getColumnIndex( ContactsContract.CommonDataKinds.Phone.NUMBER)));
        }
        phones.close();

        ArrayList<Contact> contactList = new ArrayList<>();
        Contact contact;
        for (int i = 0; i < nameList.size(); i++) {
            contact = new Contact(nameList.get(i), phoneList.get(i));
            contactList.add(contact);
        }

        return contactList;
    }

}
