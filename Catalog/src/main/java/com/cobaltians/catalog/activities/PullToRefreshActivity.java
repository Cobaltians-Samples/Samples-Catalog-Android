package com.cobaltians.catalog.activities;

import com.cobaltians.catalog.fragments.PullToRefreshFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public class PullToRefreshActivity extends AbstractActivity {

	protected CobaltFragment getFragment(){
		return new PullToRefreshFragment();
	}
}
