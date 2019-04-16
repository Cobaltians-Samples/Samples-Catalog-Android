package org.cobaltians.catalog.fragments;

import android.content.Intent;

import org.cobaltians.cobalt.plugin.CobaltPluginWebContainer;

import io.kristal.geolocpicker.GeolocPicker;

public class SimpleHybridFragment extends AbstractFragment {

	@Override
	protected void onPullToRefreshRefreshed() { }

	@Override
	protected void onInfiniteScrollRefreshed() { }

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		// Forward result to GeolocPicker
		GeolocPicker geolocPicker = (GeolocPicker)GeolocPicker.getInstance(new CobaltPluginWebContainer(getActivity(),this));
		geolocPicker.onActivityResult(requestCode, resultCode, data);
		super.onActivityResult(requestCode, resultCode, data);
	}
}
