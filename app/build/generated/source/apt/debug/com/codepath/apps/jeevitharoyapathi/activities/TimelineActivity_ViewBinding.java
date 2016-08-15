// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.jeevitharoyapathi.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.codepath.apps.jeevitharoyapathi.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class TimelineActivity_ViewBinding<T extends TimelineActivity> implements Unbinder {
  protected T target;

  private View view2131427456;

  public TimelineActivity_ViewBinding(final T target, Finder finder, Object source) {
    this.target = target;

    View view;
    target.mRecyclerView = finder.findRequiredViewAsType(source, R.id.rvResult, "field 'mRecyclerView'", RecyclerView.class);
    target.mToolbar = finder.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    view = finder.findRequiredView(source, R.id.fab_add, "field 'mFavAdd' and method 'createNewTweet'");
    target.mFavAdd = finder.castView(view, R.id.fab_add, "field 'mFavAdd'", FloatingActionButton.class);
    view2131427456 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.createNewTweet();
      }
    });
    target.mSwipeRefreshLayout = finder.findRequiredViewAsType(source, R.id.referesh_tweets, "field 'mSwipeRefreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mRecyclerView = null;
    target.mToolbar = null;
    target.mFavAdd = null;
    target.mSwipeRefreshLayout = null;

    view2131427456.setOnClickListener(null);
    view2131427456 = null;

    this.target = null;
  }
}
