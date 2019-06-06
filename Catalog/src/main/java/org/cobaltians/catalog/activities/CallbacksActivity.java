package org.cobaltians.catalog.activities;

import org.cobaltians.catalog.fragments.CallbacksFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public final class CallbacksActivity extends DefaultActivity
{
    @Override
    protected CobaltFragment getFragment()
    {
        return new CallbacksFragment();
    }
}
