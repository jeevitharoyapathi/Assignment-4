// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.jeevitharoyapathi.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.codepath.apps.jeevitharoyapathi.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ProfileActivity_ViewBinding<T extends ProfileActivity> implements Unbinder {
  protected T target;

  public ProfileActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mPager = finder.findRequiredViewAsType(source, R.id.profile_pager, "field 'mPager'", ViewPager.class);
    target.mTab = finder.findRequiredViewAsType(source, R.id.profile_tab, "field 'mTab'", TabLayout.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mPager = null;
    target.mTab = null;

    this.target = null;
  }
}
