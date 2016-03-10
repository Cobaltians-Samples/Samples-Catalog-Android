package org.cobaltians.catalog.activities;

import org.cobaltians.catalog.fragments.NativeBarsFragment;

import org.cobaltians.cobalt.activities.CobaltActivity;
import org.cobaltians.cobalt.fragments.CobaltFragment;

/**
 * Created by sebastien on 13/10/2014.
 */
public class NativeBarsActivity extends CobaltActivity {
    @Override
    protected CobaltFragment getFragment() {
        return new NativeBarsFragment();
    }
}
