package org.cobaltians.catalog.activities;

import org.cobaltians.catalog.fragments.PluginsFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public final class PluginsActivity extends DefaultActivity
{
    @Override
    protected CobaltFragment getFragment()
    {
        return new PluginsFragment();
    }
}
