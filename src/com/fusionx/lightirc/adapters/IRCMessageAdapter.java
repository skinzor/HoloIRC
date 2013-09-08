package com.fusionx.lightirc.adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Spanned;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fusionx.lightirc.R;
import com.fusionx.lightirc.util.UIUtils;

import java.util.ArrayList;

public class IRCMessageAdapter extends ArrayAdapter<Spanned> {
    public IRCMessageAdapter(Context context, ArrayList<Spanned> objects) {
        super(context, R.layout.irc_listview_textview, objects);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view;
        if (convertView == null) {
            view = (TextView) LayoutInflater.from(getContext()).inflate(R.layout
                    .irc_listview_textview, parent, false);
            view.setTypeface(UIUtils.getRobotoLight(getContext()));
            if (UIUtils.hasHoneycomb()) {
                view.setTextIsSelectable(true);
            }
            view.setTextColor(UIUtils.getThemedTextColor(getContext()));
        } else {
            view = (TextView) convertView;
        }
        view.setText(getItem(position));
        Linkify.addLinks(view, Linkify.WEB_URLS | Linkify.EMAIL_ADDRESSES);
        return view;
    }
}