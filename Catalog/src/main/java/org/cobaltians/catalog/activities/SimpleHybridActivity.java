package org.cobaltians.catalog.activities;

import org.cobaltians.catalog.fragments.SimpleHybridFragment;

import org.cobaltians.cobalt.Cobalt;
import org.cobaltians.cobalt.fragments.CobaltFragment;

public class SimpleHybridActivity extends AbstractActivity {

    protected CobaltFragment getFragment() {
		return Cobalt.getInstance(this).getFragmentForController(SimpleHybridFragment.class, "default", "index.html");
	}

	@Override
	public String getInitPage() {
		return "index.html";
	}
}
