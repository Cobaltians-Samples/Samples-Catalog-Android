package com.cobaltians.catalog.activities;

import com.cobaltians.catalog.fragments.EventsFragment;

import fr.cobaltians.cobalt.fragments.CobaltFragment;

public class EventsActivity extends AbstractActivity {
	
	protected CobaltFragment getFragment(){
		return new EventsFragment();
	}

}
