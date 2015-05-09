package com.cobaltians.catalog.activities;

import com.cobaltians.catalog.fragments.ModalFragment;

import fr.cobaltians.cobalt.fragments.CobaltFragment;

public class ModalActivity extends AbstractActivity {

	@Override
	protected CobaltFragment getFragment() {
		return new ModalFragment();
	}

}
