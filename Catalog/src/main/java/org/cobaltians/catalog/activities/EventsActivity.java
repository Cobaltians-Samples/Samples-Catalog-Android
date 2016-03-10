package org.cobaltians.catalog.activities;

import org.cobaltians.catalog.fragments.EventsFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public class EventsActivity extends AbstractActivity {
	
	protected CobaltFragment getFragment(){
		return new EventsFragment();
	}

}
