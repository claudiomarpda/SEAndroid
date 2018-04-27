package sea.com.seandroid.page_contacts;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sea.com.seandroid.R;
import sea.com.seandroid.data.model.Contact;

public class PageContactsAdapter extends RecyclerView.Adapter<PageContactsAdapter.ContactsViewHolder> {

    private List<Contact> contactList;
    private PageContactsContract.Presenter mContactPresenter;

    public PageContactsAdapter(PageContactsContract.Presenter p, List<Contact> list) {
        mContactPresenter = p;
        this.contactList = list;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.page_contact_item, parent, false);

        return new PageContactsAdapter.ContactsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PageContactsAdapter.ContactsViewHolder holder, int position) {
        String id = contactList.get(position).getContactId();
        holder.wFirstName.setText(id);
//        holder.wImage.setImageBitmap();
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView wImage;
        private TextView wFirstName;

        private long mLastClickTime = 0;

        ContactsViewHolder(View itemView) {
            super(itemView);
            wFirstName = itemView.findViewById(R.id.page_contacts_name);
            wImage = itemView.findViewById(R.id.page_contacts_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime >= 1000) {
                // Prevents fast clicking.
                this.mLastClickTime = SystemClock.elapsedRealtime();

                mContactPresenter.onItemSelected(view, getAdapterPosition());
            }
        }
    }
}
