// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.jeevitharoyapathi.activities;

import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.codepath.apps.jeevitharoyapathi.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ComposeActivity_ViewBinding<T extends ComposeActivity> implements Unbinder {
  protected T target;

  public ComposeActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mBody = finder.findRequiredViewAsType(source, R.id.NewTweet, "field 'mBody'", EditText.class);
    target.mCount = finder.findRequiredViewAsType(source, R.id.remainingCount, "field 'mCount'", TextView.class);
    target.mToolbar = finder.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mSubmit = finder.findRequiredViewAsType(source, R.id.btnSubmit, "field 'mSubmit'", Button.class);
    target.mCancel = finder.findRequiredViewAsType(source, R.id.btnCancel, "field 'mCancel'", Button.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mBody = null;
    target.mCount = null;
    target.mToolbar = null;
    target.mSubmit = null;
    target.mCancel = null;

    this.target = null;
  }
}
