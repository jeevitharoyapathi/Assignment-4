package com.codepath.apps.jeevitharoyapathi.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.codepath.apps.jeevitharoyapathi.R;
import com.codepath.apps.jeevitharoyapathi.models.Tweet;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jeevitha.royapathi on 7/30/16.
 */
public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {

    public final static int IMAGE_VIEW = 1;
    private List<Tweet> mDataset;
    private Context mContext;
    private OnItemClickListener mclicklistener;

    public TweetsAdapter(Context myContext, List<Tweet> myDataset) {
        mContext = myContext;
        mDataset = myDataset;

    }

    public TweetsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_tweet, parent, false);
        return new regularViewHolder(v);

    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        mclicklistener = onItemClickListener;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tweet tweet = mDataset.get(position);
        holder.bindArticleData(tweet);

    }

    public int getItemCount() {
        return mDataset.size();
    }

    public Object getItem(int position) {
        return mDataset.get(position);
    }

    public abstract class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View v) {
            super(v);
        }

        public abstract void bindArticleData(Tweet tweet);
    }

    public class regularViewHolder extends ViewHolder {
        @BindView(R.id.profile_image)
        ImageView mProfileImage;

        @BindView(R.id.name)
        TextView mName;

        @BindView(R.id.user_name)
        TextView mUserName;

        @BindView(R.id.tweetTime)
        TextView mTweetTime;

        @BindView(R.id.content)
        TextView mContent;

        public regularViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mclicklistener != null) {
                        mclicklistener.onItemClick(mDataset.get(getPosition()), IMAGE_VIEW);
                    }
                }

            });
        }

        public void bindArticleData(Tweet tweet) {
            final regularViewHolder viewHolder = this;
            mContent.setText(tweet.getText());
            mName.setText(tweet.getUser().getName());
            mUserName.setText("@" +tweet.getUser().getScreenName());
            mTweetTime.setText(getDateTimeString(tweet.getCreatedAt()));
            Glide.with(mContext).
                    load(tweet.getUser().getProfileImageUrl())
                    .asBitmap()
                    .centerCrop()
                    .error(R.drawable.twitter_logo_mini)
                    .placeholder(R.drawable.twitter_logo_mini)
                    .into(new BitmapImageViewTarget(mProfileImage) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            mProfileImage.setImageDrawable(circularBitmapDrawable);
                        }
                    });

        }
    }

    public void setCellColors(Bitmap b, final regularViewHolder viewHolder) {

        if (b != null) {
            Palette.generateAsync(b, new Palette.PaletteAsyncListener() {

                @Override
                public void onGenerated(Palette palette) {

                    Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();

                    if (vibrantSwatch != null) {

                        // viewHolder.articleTitle.setTextColor(vibrantSwatch.getTitleTextColor());
//                        animationUtils.animateViewColor(viewHolder.layout_news,
//                                mContext.getResources().getColor(R.color.book_without_palette),
//                                vibrantSwatch.getRgb());

                    } else {

                        Log.e("[ERROR]", "The VibrantSwatch were null at: ");
                    }
                }
            });
        }
    }

    //Interface to handle recylerview onClick Events
    public interface OnItemClickListener {
        public void onItemClick(Tweet tweet, int type);
    }

    public static String getDateTimeString(final Date date) {
        if (date != null)
            return android.text.format.DateUtils.getRelativeTimeSpanString(date.getTime(),
                    System.currentTimeMillis(),
                    android.text.format.DateUtils.MINUTE_IN_MILLIS,
                    android.text.format.DateUtils.FORMAT_ABBREV_RELATIVE).toString();
        return "";
    }

    public String getLastTweetId() {
        String tweetId = null;
        if (!mDataset.isEmpty()) {
            final Tweet tweet = mDataset.get(mDataset.size() - 1);
            tweetId = String.valueOf(tweet.getId());
        }
        return tweetId;
    }

    public void addToFirstPosition(Tweet tweet) {
        mDataset.add(0, tweet);
        notifyDataSetChanged();
    }
}
