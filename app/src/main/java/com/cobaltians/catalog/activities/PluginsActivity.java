package com.cobaltians.catalog.activities;

import com.cobaltians.catalog.fragments.SimpleHybridFragment;

import fr.cobaltians.cobalt.fragments.CobaltFragment;


public class PluginsActivity extends AbstractActivity {

    @Override
    protected CobaltFragment getFragment() {
        return new SimpleHybridFragment();
    }
}
