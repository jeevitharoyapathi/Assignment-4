// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.jeevitharoyapathi.fragment;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.codepath.apps.jeevitharoyapathi.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ProfileFragment_ViewBinding<T extends ProfileFragment> implements Unbinder {
  protected T target;

  public ProfileFragment_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.ivProfileImage = finder.findRequiredViewAsType(source, R.id.profile_img, "field 'ivProfileImage'", ImageView.class);
    target.mName = finder.findRequiredViewAsType(source, R.id.user_name, "field 'mName'", TextView.class);
    target.mScreenName = finder.findRequiredViewAsType(source, R.id.screen_name, "field 'mScreenName'", TextView.class);
    target.mUserTag = finder.findRequiredViewAsType(source, R.id.user_tag, "field 'mUserTag'", TextView.class);
    target.mFollowingCount = finder.findRequiredViewAsType(source, R.id.user_following_count, "field 'mFollowingCount'", TextView.class);
    target.mFollowing = finder.findRequiredViewAsType(source, R.id.user_following, "field 'mFollowing'", TextView.class);
    target.mFriendsCount = finder.findRequiredViewAsType(source, R.id.user_friends_count, "field 'mFriendsCount'", TextView.class);
    target.mFriends = finder.findRequiredViewAsType(source, R.id.user_friends, "field 'mFriends'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivProfileImage = null;
    target.mName = null;
    target.mScreenName = null;
    target.mUserTag = null;
    target.mFollowingCount = null;
    target.mFollowing = null;
    target.mFriendsCount = null;
    target.mFriends = null;

    this.target = null;
  }
}
