package org.cobaltians.catalog.fragments;

import org.cobaltians.catalog.R;

import org.cobaltians.cobalt.fragments.CobaltFragment;
import org.cobaltians.cobalt.pubsub.PubSub;
import org.cobaltians.cobalt.pubsub.PubSubInterface;
import org.cobaltians.cobalt.Cobalt;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

public final class EventsFragment extends CobaltFragment implements PubSubInterface
{
    // ZOOM
    protected final static String JSNameSetZoom = "setZoom";
    protected final static String JSNameHello = "hello";

	private Button zoomInButton,zoomOutButton;
	private int zoomLevel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		zoomLevel = 10;
	}
	
	@Override
	protected int getLayoutToInflate() {
		return R.layout.events_fragment;
	}


	@Override
	protected void setUpViews(View rootView) {
		super.setUpViews(rootView);
		zoomInButton = (Button) rootView.findViewById(R.id.zoomInButton);
		zoomOutButton = (Button) rootView.findViewById(R.id.zoomOutButton);
	}

	@Override
	protected void setUpListeners() {
		zoomInButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				zoomOutButton.setEnabled(true);
				zoomLevel++;

				if(zoomLevel >= 20)
				{
					zoomInButton.setEnabled(false);
				}
				setZoomLevelInWebView(zoomLevel);
			}
		});

		zoomOutButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				zoomInButton.setEnabled(true);
				zoomLevel--;

				if(zoomLevel <= 5)
				{
					zoomOutButton.setEnabled(false);
				}
				setZoomLevelInWebView(zoomLevel);
			}
		});
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		
		Cobalt.subscribeToChannel(JSNameHello, this);
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		
		Cobalt.unsubscribeFromChannel(JSNameHello, this);
	}
	
	@Override
	public void onMessageReceived(@Nullable JSONObject message, @NonNull String channel)
	{
		if (channel.equals(JSNameHello))
		{
			getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run()
				{
					AlertDialog alert = new AlertDialog.Builder(getActivity())
							.setTitle("hello")
							.setMessage("hello world")
							.setPositiveButton("OK", null)
							.create();
					alert.setCanceledOnTouchOutside(true);
					alert.show();
				}
			});
		}
	}
	
	private void setZoomLevelInWebView(int nZoomLevel)
	{
		try
		{
			JSONObject message = new JSONObject();
			message.put(Cobalt.kJSValue, nZoomLevel);
			Cobalt.publishMessage(message, JSNameSetZoom);
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
	}
}
