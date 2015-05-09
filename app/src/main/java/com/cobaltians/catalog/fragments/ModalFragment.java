package com.cobaltians.catalog.fragments;

import org.json.JSONObject;

public class ModalFragment extends AbstractFragment {

    @Override
    protected boolean onUnhandledCallback(String callback, JSONObject data) {
        return false;
    }

    @Override
    protected boolean onUnhandledEvent(String event, JSONObject data, String callback) {
        if (super.onUnhandledEvent(event, data, callback)) return true;
        else return false;
    }

    @Override
    protected void onUnhandledMessage(JSONObject message) { }
}

