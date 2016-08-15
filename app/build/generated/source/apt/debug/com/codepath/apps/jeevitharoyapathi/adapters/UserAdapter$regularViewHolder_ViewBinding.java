// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.jeevitharoyapathi.adapters;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.codepath.apps.jeevitharoyapathi.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class UserAdapter$regularViewHolder_ViewBinding<T extends UserAdapter.regularViewHolder> implements Unbinder {
  protected T target;

  public UserAdapter$regularViewHolder_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mProfileImage = finder.findRequiredViewAsType(source, R.id.profile_image, "field 'mProfileImage'", ImageView.class);
    target.mName = finder.findRequiredViewAsType(source, R.id.user_name, "field 'mName'", TextView.class);
    target.mScreenName = finder.findRequiredViewAsType(source, R.id.screen_name, "field 'mScreenName'", TextView.class);
    target.mTagLine = finder.findRequiredViewAsType(source, R.id.user_tag, "field 'mTagLine'", TextView.class);
    target.mFollowingCount = finder.findRequiredViewAsType(source, R.id.user_following_count, "field 'mFollowingCount'", TextView.class);
    target.mFriendsCount = finder.findRequiredViewAsType(source, R.id.user_friends_count, "field 'mFriendsCount'", TextView.class);
    target.mFriends = finder.findRequiredViewAsType(source, R.id.user_friends, "field 'mFriends'", TextView.class);
    target.mFollowing = finder.findRequiredViewAsType(source, R.id.user_following, "field 'mFollowing'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mProfileImage = null;
    target.mName = null;
    target.mScreenName = null;
    target.mTagLine = null;
    target.mFollowingCount = null;
    target.mFriendsCount = null;
    target.mFriends = null;
    target.mFollowing = null;

    this.target = null;
  }
}
