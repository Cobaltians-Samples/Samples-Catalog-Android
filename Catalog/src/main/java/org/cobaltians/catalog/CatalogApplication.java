package org.cobaltians.catalog;

import android.app.Application;

import org.cobaltians.cobalt.Cobalt;

/**
 * Created by sebastien on 07/05/2014.
 */
public class CatalogApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Cobalt.DEBUG = true;
    }
}
