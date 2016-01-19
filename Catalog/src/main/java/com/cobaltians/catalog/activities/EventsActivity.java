package com.cobaltians.catalog.activities;

import com.cobaltians.catalog.fragments.EventsFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public class EventsActivity extends AbstractActivity {
	
	protected CobaltFragment getFragment(){
		return new EventsFragment();
	}

}
