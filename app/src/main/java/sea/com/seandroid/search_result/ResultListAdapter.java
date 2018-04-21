package sea.com.seandroid.search_result;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sea.com.seandroid.R;
import sea.com.seandroid.data.model.User;

public class ResultListAdapter extends RecyclerView.Adapter<ResultListAdapter.UserViewHolder> {

    private List<User> mList;
    private ResultContract.Presenter mResultPresenter;

    public ResultListAdapter(ResultContract.Presenter p, List<User> mList) {
        mResultPresenter = p;
        this.mList = mList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_user_item, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.wFirstName.setText(mList.get(position).getFirstName());
        holder.wLastName.setText(mList.get(position).getKnowledgeList().get(0).getTitle());
        holder.wKnowledge.setText(mList.get(position).getFrequentLocalList().get(0));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView wFirstName;
        private TextView wLastName;
        private TextView wKnowledge;

        private long mLastClickTime = 0;

        UserViewHolder(View itemView) {
            super(itemView);
            wFirstName = itemView.findViewById(R.id.search_user_name);
            wLastName = itemView.findViewById(R.id.search_user_knowledge);
            wKnowledge = itemView.findViewById(R.id.search_user_location);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime >= 1000) {
                // Prevents fast clicking.
                this.mLastClickTime = SystemClock.elapsedRealtime();

                mResultPresenter.onItemSelected(view, getAdapterPosition());
            }
        }
    }
}
