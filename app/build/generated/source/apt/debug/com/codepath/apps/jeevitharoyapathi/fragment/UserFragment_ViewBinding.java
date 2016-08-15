// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.jeevitharoyapathi.fragment;

import android.support.v7.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.codepath.apps.jeevitharoyapathi.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class UserFragment_ViewBinding<T extends UserFragment> implements Unbinder {
  protected T target;

  public UserFragment_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mRecyclerView = finder.findRequiredViewAsType(source, R.id.rvResult, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mRecyclerView = null;

    this.target = null;
  }
}
