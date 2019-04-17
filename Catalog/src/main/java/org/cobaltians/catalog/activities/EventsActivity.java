package org.cobaltians.catalog.activities;

import org.cobaltians.catalog.fragments.EventsFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public final class EventsActivity extends DefaultActivity
{
	@Override
	protected CobaltFragment getFragment()
	{
		return new EventsFragment();
	}
}
