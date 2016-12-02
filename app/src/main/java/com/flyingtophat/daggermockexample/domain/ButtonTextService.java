package com.flyingtophat.daggermockexample.domain;

import android.content.Context;

import com.flyingtophat.daggermockexample.R;

public class ButtonTextService {

    private final String text;

    public ButtonTextService(final Context context) {
        text = context.getString(R.string.button_text);
    }

    public String getText() {
        return text;
    }
}
