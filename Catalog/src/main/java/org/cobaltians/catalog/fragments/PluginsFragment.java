package org.cobaltians.catalog.fragments;

import io.kristal.geolocpicker.GeolocPicker;
import io.kristal.signature.Signature;

import org.cobaltians.cobalt.fragments.CobaltFragment;
import org.cobaltians.cobalt.plugin.CobaltPluginWebContainer;

import android.content.Intent;

public class PluginsFragment extends CobaltFragment
{
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// Forward result to GeolocPicker
		GeolocPicker geolocPicker = (GeolocPicker) GeolocPicker.getInstance(new CobaltPluginWebContainer(getActivity(),
																										 this));
		geolocPicker.onActivityResult(requestCode, resultCode, data);

		// Result for Signature
		Signature signature = (Signature) Signature.getInstance(new CobaltPluginWebContainer(getActivity(),
																							 this));
		signature.onActivityResult(requestCode, resultCode, data);

		super.onActivityResult(requestCode, resultCode, data);
	}
}
