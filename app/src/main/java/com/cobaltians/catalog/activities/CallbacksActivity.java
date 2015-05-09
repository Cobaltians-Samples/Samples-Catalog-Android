package com.cobaltians.catalog.activities;

import com.cobaltians.catalog.fragments.CallbacksFragment;

import fr.cobaltians.cobalt.fragments.CobaltFragment;

public class CallbacksActivity extends AbstractActivity {

    protected CobaltFragment getFragment() {
        return new CallbacksFragment();
    }
}
