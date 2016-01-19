package com.cobaltians.catalog.fragments;

import org.cobaltians.cobalt.Cobalt;
import org.cobaltians.cobalt.fragments.CobaltFragment;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by sebastien on 13/10/2014.
 */
public class NativeBarsFragment extends CobaltFragment {

    private static final String TAG = NativeBarsFragment.class.getSimpleName();

    @Override
    protected boolean onUnhandledCallback(String callback, JSONObject data) {
        if (Cobalt.DEBUG) Log.d(TAG, "onUnhandledCallback - data: " + data.toString() + ", callback: " + callback);
        return false;
    }

    @Override
    protected boolean onUnhandledEvent(String event, JSONObject data, String callback) {
        if (Cobalt.DEBUG) Log.d(TAG, "onUnhandledCallback - event: " + event + ", data: " + data.toString() + ", callback: " + callback);
        return false;
    }

    @Override
    protected void onUnhandledMessage(JSONObject message) {
        if (Cobalt.DEBUG) Log.d(TAG, "onUnhandledCallback - message: " + message.toString());
    }
}
