package com.cobaltians.catalog.activities;

import com.cobaltians.catalog.fragments.PullToRefreshCustomFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public class PullToRefreshCustomActivity extends AbstractActivity {

	protected CobaltFragment getFragment(){
		return new PullToRefreshCustomFragment();
	}
}
