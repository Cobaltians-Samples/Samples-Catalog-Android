package org.cobaltians.catalog.activities;

import org.cobaltians.cobalt.Cobalt;
import org.cobaltians.cobalt.fragments.CobaltFragment;

public final class IndexActivity extends DefaultActivity
{
	@Override
    protected CobaltFragment getFragment()
	{
		return Cobalt.getInstance(this)
					 .getFragmentForController(CobaltFragment.class,
											   "index",
											   "index.html");
	}

	@Override
	public String getInitPage()
	{
		return "index.html";
	}
}
