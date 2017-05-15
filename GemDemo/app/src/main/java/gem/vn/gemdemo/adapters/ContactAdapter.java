package gem.vn.gemdemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gem.vn.gemdemo.R;
import gem.vn.gemdemo.models.Contact;
import gem.vn.gemdemo.view.holders.ContactViewHolder;

/**
 * Created by Lush on 5/15/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_contact, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = Contact.CONTACTS.get(position);
        holder.bind(contact);
    }

    @Override
    public int getItemCount() {
        return Contact.CONTACTS.size();
    }
}
