package org.cobaltians.catalog.fragments;

import org.cobaltians.catalog.R;

public class PullToRefreshCustomFragment extends AbstractFragment {
	
	@Override
	public void onStart() {
		super.onStart();
        setRefreshColorScheme(	R.color.holo_green_dark,
								R.color.holo_red_dark,
								R.color.holo_blue_dark,
								R.color.holo_orange_light);
	}
}
