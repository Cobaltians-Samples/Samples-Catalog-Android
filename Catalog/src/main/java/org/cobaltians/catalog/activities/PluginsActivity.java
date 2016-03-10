package org.cobaltians.catalog.activities;

import org.cobaltians.catalog.fragments.SimpleHybridFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;


public class PluginsActivity extends AbstractActivity {

    @Override
    protected CobaltFragment getFragment() {
        return new SimpleHybridFragment();
    }
}
