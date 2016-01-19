package com.cobaltians.catalog.activities;

import com.cobaltians.catalog.fragments.ModalFragment;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public class ModalActivity extends AbstractActivity {

	@Override
	protected CobaltFragment getFragment() {
		return new ModalFragment();
	}

}
