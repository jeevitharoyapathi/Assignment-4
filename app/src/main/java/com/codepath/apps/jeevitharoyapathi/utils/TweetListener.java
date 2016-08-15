package com.codepath.apps.jeevitharoyapathi.utils;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.Editable;
import android.text.TextWatcher;

public class TweetListener {
    public final ObservableField<String> text = new ObservableField<>();
    public final ObservableInt remainingCount = new ObservableInt();

    public TweetListener() {
        remainingCount.set(140);
    }

    public TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String newText = s.toString();
            String currentText = text.get();
            if (!newText.equals(currentText)) {
                text.set(newText);
                if (!isEmpty()) {
                    remainingCount.set(140 - text.get().length());
                }
            }
        }
    };

    public boolean isEmpty() {
        return text.get() == null || text.get().isEmpty();
    }
}
