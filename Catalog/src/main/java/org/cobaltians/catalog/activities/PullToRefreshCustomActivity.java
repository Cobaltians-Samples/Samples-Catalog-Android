package org.cobaltians.catalog.activities;

import org.cobaltians.catalog.fragments.PullToRefreshCustomFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public class PullToRefreshCustomActivity extends AbstractActivity {

	protected CobaltFragment getFragment(){
		return new PullToRefreshCustomFragment();
	}
}
