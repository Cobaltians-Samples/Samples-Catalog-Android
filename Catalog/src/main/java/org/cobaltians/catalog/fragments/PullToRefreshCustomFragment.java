package org.cobaltians.catalog.fragments;

public class PullToRefreshCustomFragment extends AbstractFragment {
	
	@Override
	public void onStart() {
		super.onStart();

        setRefreshColorScheme(  android.R.color.holo_green_dark,
                                android.R.color.holo_red_dark,
                                android.R.color.holo_blue_dark,
                                android.R.color.holo_orange_light);
	}
}
