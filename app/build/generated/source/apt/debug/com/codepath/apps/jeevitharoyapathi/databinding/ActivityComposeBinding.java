package com.codepath.apps.jeevitharoyapathi.databinding;
import com.codepath.apps.jeevitharoyapathi.R;
import com.codepath.apps.jeevitharoyapathi.BR;
import android.view.View;
public class ActivityComposeBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appbar, 3);
        sViewsWithIds.put(R.id.toolbar, 4);
        sViewsWithIds.put(R.id.btnCancel, 5);
        sViewsWithIds.put(R.id.btnSubmit, 6);
    }
    // views
    public final android.widget.EditText NewTweet;
    public final android.support.design.widget.AppBarLayout appbar;
    public final android.widget.Button btnCancel;
    public final android.widget.Button btnSubmit;
    private final android.widget.RelativeLayout mboundView0;
    public final android.widget.TextView remainingCount;
    public final android.support.v7.widget.Toolbar toolbar;
    // variables
    private com.codepath.apps.jeevitharoyapathi.utils.TweetListener mTweet;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityComposeBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 2);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.NewTweet = (android.widget.EditText) bindings[1];
        this.NewTweet.setTag(null);
        this.appbar = (android.support.design.widget.AppBarLayout) bindings[3];
        this.btnCancel = (android.widget.Button) bindings[5];
        this.btnSubmit = (android.widget.Button) bindings[6];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.remainingCount = (android.widget.TextView) bindings[2];
        this.remainingCount.setTag(null);
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[4];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.tweet :
                setTweet((com.codepath.apps.jeevitharoyapathi.utils.TweetListener) variable);
                return true;
        }
        return false;
    }

    public void setTweet(com.codepath.apps.jeevitharoyapathi.utils.TweetListener tweet) {
        this.mTweet = tweet;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.tweet);
        super.requestRebind();
    }
    public com.codepath.apps.jeevitharoyapathi.utils.TweetListener getTweet() {
        return mTweet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeTextTweet((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeRemainingCou((android.databinding.ObservableInt) object, fieldId);
        }
        return false;
    }
    private boolean onChangeTextTweet(android.databinding.ObservableField<java.lang.String> textTweet, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x1L;
                }
                return true;
            }
        }
        return false;
    }
    private boolean onChangeRemainingCou(android.databinding.ObservableInt remainingCountTweet, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x2L;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int remainingCountTweet = 0;
        android.text.TextWatcher watcherTweet = null;
        java.lang.String stringValueOfStringR = null;
        java.lang.String textTweet = null;
        android.databinding.ObservableField<java.lang.String> textTweet1 = null;
        com.codepath.apps.jeevitharoyapathi.utils.TweetListener tweet = mTweet;
        android.databinding.ObservableInt remainingCountTweet1 = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xcL) != 0) {

                    if (tweet != null) {
                        // read tweet.watcher
                        watcherTweet = tweet.watcher;
                    }
            }
            if ((dirtyFlags & 0xdL) != 0) {

                    if (tweet != null) {
                        // read tweet.text
                        textTweet1 = tweet.text;
                    }
                    updateRegistration(0, textTweet1);


                    if (textTweet1 != null) {
                        // read tweet.text.get()
                        textTweet = textTweet1.get();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (tweet != null) {
                        // read tweet.remainingCount
                        remainingCountTweet1 = tweet.remainingCount;
                    }
                    updateRegistration(1, remainingCountTweet1);


                    if (remainingCountTweet1 != null) {
                        // read tweet.remainingCount.get()
                        remainingCountTweet = remainingCountTweet1.get();
                    }


                    // read String.valueOf(tweet.remainingCount.get())
                    stringValueOfStringR = java.lang.String.valueOf(remainingCountTweet);
            }
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            this.NewTweet.addTextChangedListener(watcherTweet);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.NewTweet, textTweet);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.remainingCount, stringValueOfStringR);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ActivityComposeBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityComposeBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityComposeBinding>inflate(inflater, com.codepath.apps.jeevitharoyapathi.R.layout.activity_compose, root, attachToRoot, bindingComponent);
    }
    public static ActivityComposeBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityComposeBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.codepath.apps.jeevitharoyapathi.R.layout.activity_compose, null, false), bindingComponent);
    }
    public static ActivityComposeBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityComposeBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_compose_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityComposeBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): tweet.text
        flag 1 (0x2L): tweet.remainingCount
        flag 2 (0x3L): tweet
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}