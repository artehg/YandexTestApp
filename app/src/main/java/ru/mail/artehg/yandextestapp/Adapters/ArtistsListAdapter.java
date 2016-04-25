package ru.mail.artehg.yandextestapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.mail.artehg.yandextestapp.ArtistsInfo;
import ru.mail.artehg.yandextestapp.ListActivity;
import ru.mail.artehg.yandextestapp.R;

/**
 * Created by artehg on 24.04.2016.
 */
public class ArtistsListAdapter extends RecyclerView.Adapter<ArtistsListAdapter.ViewHolder> {
    ArrayList<ArtistsInfo> mInfo;
    Context mContext;
    ListActivity mActivity;

    public ArtistsListAdapter(Context context, ListActivity activity) {
        mContext = context;
        mActivity = activity;
    }

    public void setInfo(ArrayList<ArtistsInfo> info) {
        mInfo = info;
        notifyDataSetChanged();
    }

    @Override
    public ArtistsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.list_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ArtistsListAdapter.ViewHolder holder, int position) {
        ArtistsInfo info = mInfo.get(position);
        holder.title.setText(info.getName());
        holder.genre.setText(info.getGenresString());
        holder.info.setText(info.getAlbumsAndTracks(mContext, ArtistsInfo.LIST_ACTIVITY));
        Picasso.with(mContext).load(info.getCover().getSmall()).into(holder.cover);
        holder.mLayout.setOnClickListener(v -> openArtistInfo(info, holder));
    }

    private void openArtistInfo(ArtistsInfo info, ViewHolder holder) {
        mActivity.openDetailInformation(info, holder.title, holder.genre, holder.info);
    }

    @Override
    public int getItemCount() {
        if (mInfo != null){
            return mInfo.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.listRowLayout)
        LinearLayout mLayout;
        @Bind(R.id.lisRowArtistTitle)
        TextView title;
        @Bind(R.id.listRowGenre)
        TextView genre;
        @Bind(R.id.listRowArtistInformation)
        TextView info;
        @Bind(R.id.listRowIv)
        ImageView cover;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
