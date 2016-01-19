package org.cobaltians.catalog.activities;

import org.cobaltians.catalog.fragments.PullToRefreshFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public class PullToRefreshActivity extends AbstractActivity {

	protected CobaltFragment getFragment(){
		return new PullToRefreshFragment();
	}
}
