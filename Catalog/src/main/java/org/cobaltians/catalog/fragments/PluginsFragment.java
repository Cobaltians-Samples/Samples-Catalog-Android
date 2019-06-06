package org.cobaltians.catalog.fragments;

import io.kristal.geolocpicker.GeolocPicker;
import io.kristal.signature.Signature;

import org.cobaltians.cobalt.fragments.CobaltFragment;

import android.content.Intent;

public class PluginsFragment extends CobaltFragment
{
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// Forward result to GeolocPicker
		GeolocPicker.getInstance().onActivityResult(requestCode, resultCode, data);

		// Result for Signature
		Signature.getInstance().onActivityResult(requestCode, resultCode, data);

		super.onActivityResult(requestCode, resultCode, data);
	}
}
