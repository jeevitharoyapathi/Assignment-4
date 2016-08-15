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

public class TweetsAdapter$regularViewHolder_ViewBinding<T extends TweetsAdapter.regularViewHolder> implements Unbinder {
  protected T target;

  public TweetsAdapter$regularViewHolder_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mProfileImage = finder.findRequiredViewAsType(source, R.id.profile_image, "field 'mProfileImage'", ImageView.class);
    target.mName = finder.findRequiredViewAsType(source, R.id.name, "field 'mName'", TextView.class);
    target.mUserName = finder.findRequiredViewAsType(source, R.id.user_name, "field 'mUserName'", TextView.class);
    target.mTweetTime = finder.findRequiredViewAsType(source, R.id.tweetTime, "field 'mTweetTime'", TextView.class);
    target.mContent = finder.findRequiredViewAsType(source, R.id.content, "field 'mContent'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mProfileImage = null;
    target.mName = null;
    target.mUserName = null;
    target.mTweetTime = null;
    target.mContent = null;

    this.target = null;
  }
}
