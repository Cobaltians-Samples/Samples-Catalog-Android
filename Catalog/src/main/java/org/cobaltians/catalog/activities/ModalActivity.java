package org.cobaltians.catalog.activities;

import org.cobaltians.catalog.fragments.ModalFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public class ModalActivity extends AbstractActivity {

	@Override
	protected CobaltFragment getFragment() {
		return new ModalFragment();
	}

}
