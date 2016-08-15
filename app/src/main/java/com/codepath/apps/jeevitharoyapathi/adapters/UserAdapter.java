package com.codepath.apps.jeevitharoyapathi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.jeevitharoyapathi.R;
import com.codepath.apps.jeevitharoyapathi.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User> mDataset;
    private Context mContext;
    private OnItemClickListener mclicklistener;

    public UserAdapter(Context myContext, List<User> myDataset) {
        mContext = myContext;
        mDataset = myDataset;
    }

    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.follower_item, parent, false);
        return new regularViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = mDataset.get(position);
        holder.bindArticleData(user);

    }

    public void setOnClickListener(OnItemClickListener onClickListener)
    {
        mclicklistener=onClickListener;
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

        public abstract void bindArticleData(User user);
    }

    public class regularViewHolder extends ViewHolder {
        @BindView(R.id.profile_image)
        ImageView mProfileImage;
        @BindView(R.id.user_name)
        TextView mName;
        @BindView(R.id.screen_name)
        TextView mScreenName;
        @BindView(R.id.user_tag)
        TextView mTagLine;
        @BindView(R.id.user_following_count)
        TextView mFollowingCount;
        @BindView(R.id.user_friends_count)
        TextView mFriendsCount;
        @BindView(R.id.user_friends)
        TextView mFriends;
        @BindView(R.id.user_following)
        TextView mFollowing;

        public regularViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mclicklistener != null) {
                        mclicklistener.onItemClick(mDataset.get(getPosition()).getScreenName());
                        mDataset.clear();
                        notifyDataSetChanged();
                    }
                }

            });
        }

        public void bindArticleData(User user) {
            mScreenName.setText("@" + user.getScreenName());
            mName.setText(user.getName());
            mTagLine.setText(user.getTag());
            mFollowingCount.setText(user.getFollowers());
            mFriendsCount.setText(user.getFriendsCount());
            Glide.with(mContext).
                    load(user.getProfileImageUrl())
                    .asBitmap()
                    .centerCrop()
                    .error(R.drawable.twitter_logo_mini)
                    .placeholder(R.drawable.twitter_logo_mini)
                    .into(mProfileImage);
            mFriends.setText("Followers");
            mFollowing.setText("Following");

        }
    }


    public interface OnItemClickListener {
        public void onItemClick(String screenName);
    }

}
