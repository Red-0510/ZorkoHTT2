package com.example.zorkohtt2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.zorkohtt2.R; // Assuming your layout file is in the same resource directory

import java.util.List;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder> {

    private final List<String> names;
    private final List<String> comments;
    private final List<String> upvotesList;
    private final List<String> downvotesList;

    public CommunityAdapter(List<String> names, List<String> comments, List<String> upvotesList,List<String> downvotesList) {
        this.names = names;
        this.comments = comments;
        this.upvotesList = upvotesList;
        this.downvotesList = downvotesList;
    }

    @Override
    public CommunityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.community_item, parent, false); // Assuming your layout file is named popular_item.xml
        return new CommunityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommunityViewHolder holder, int position) {
        String name = names.get(position);
        String comment = comments.get(position);
        String upvotes = upvotesList.get(position);
        String downvotes = downvotesList.get(position);
        holder.bind(name,comment,upvotes,downvotes);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class CommunityViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView comment;

        private final TextView upvotes;
        private final TextView downvotes;

        public CommunityViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.namecommunity);
            comment = itemView.findViewById(R.id.comment);
            upvotes = itemView.findViewById(R.id.upvotes);
            downvotes = itemView.findViewById(R.id.downvotes);
        }

        public void bind(String _name, String _comment, String _upvotes,String _downvotes) {
            name.setText(_name);
            comment.setText(_comment);
            upvotes.setText(_upvotes);
            downvotes.setText(_downvotes);
        }
    }
}