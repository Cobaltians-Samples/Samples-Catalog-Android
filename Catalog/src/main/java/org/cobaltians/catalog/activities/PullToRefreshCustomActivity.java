package org.cobaltians.catalog.activities;

import org.cobaltians.catalog.fragments.PullToRefreshCustomFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public final class PullToRefreshCustomActivity extends DefaultActivity
{
	@Override
	protected CobaltFragment getFragment()
	{
		return new PullToRefreshCustomFragment();
	}
}
