package com.cobaltians.catalog.activities;

import com.cobaltians.catalog.fragments.SimpleHybridFragment;

import fr.cobaltians.cobalt.Cobalt;
import fr.cobaltians.cobalt.fragments.CobaltFragment;

public class SimpleHybridActivity extends AbstractActivity {

    protected CobaltFragment getFragment() {
		return Cobalt.getInstance(this).getFragmentForController(SimpleHybridFragment.class, "default", "index.html");
	}
}
