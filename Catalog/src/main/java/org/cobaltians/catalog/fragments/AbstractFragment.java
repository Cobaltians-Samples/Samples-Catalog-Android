package org.cobaltians.catalog.fragments;

import org.cobaltians.cobalt.fragments.CobaltFragment;

import org.json.JSONObject;

/**
 * Created by sebastien on 01/09/2014.
 */
public abstract class AbstractFragment extends CobaltFragment {

    protected final static String TAG = "AbstractFragment";

    @Override
    protected boolean onUnhandledCallback(String callback, JSONObject data) { return false;}

    @Override
    protected boolean onUnhandledEvent(String event, JSONObject data, String callback) {return false;}

    @Override
    protected void onUnhandledMessage(JSONObject message) { }
}
