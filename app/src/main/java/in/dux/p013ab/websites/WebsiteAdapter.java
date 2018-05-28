package in.dux.p013ab.websites;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import in.dux.p013ab.R;

/**
 * Created by root on 5/28/18.
 */

public class WebsiteAdapter extends RecyclerView.Adapter<WebsiteAdapter.WebsiteViewHolder> {
    private ArrayList<WebsiteDataModel> list = new ArrayList<>();
    private Context context;
    private WebsiteAdapter.RecyclerViewClickListener recyclerViewClickListener;

    public WebsiteAdapter(ArrayList<WebsiteDataModel> lv,RecyclerViewClickListener rv) {
        list = lv;
        recyclerViewClickListener = rv;
    }

    @Override
    public WebsiteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_website, parent, false);
        WebsiteAdapter.WebsiteViewHolder holder = new WebsiteAdapter.WebsiteViewHolder(view,recyclerViewClickListener);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(WebsiteViewHolder holder, int position) {

        holder.websiteName.setText(list.get(position).getWebsiteName());
        Glide.with(context)
                .load(list.get(position).getImageUrl())
                .into(holder.websiteImage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface RecyclerViewClickListener {

        void onClick(View view, int adapterPosition);
    }

    public class WebsiteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView websiteName;
        private ImageView websiteImage;
        RecyclerViewClickListener recyclerViewClickListener;

        public WebsiteViewHolder(View itemView, RecyclerViewClickListener rv) {
            super(itemView);

            recyclerViewClickListener = rv;
            websiteImage = itemView.findViewById(R.id.websiteImageView);
            websiteName = itemView.findViewById(R.id.websiteTextView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            recyclerViewClickListener.onClick(view,getAdapterPosition());

        }
    }
}
