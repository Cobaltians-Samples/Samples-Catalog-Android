package com.cobaltians.catalog.util;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;

import com.cobaltians.catalog.R;

import org.cobaltians.cobalt.Cobalt;
import org.cobaltians.cobalt.font.CobaltAbstractFontDrawable;

/**
 * Created by sebastienfamel on 10/12/15.
 */
public class FontAwesomeDrawable extends CobaltAbstractFontDrawable {
    private static final String TAG = FontAwesomeDrawable.class.getSimpleName();

    private static final String FONT_FILE = "www/FontAwesome.ttf";
    public static final int TEXT_COLOR_LIGHT = Color.argb(153, 51, 51, 51);
    public static final int TEXT_COLOR_DARK = Color.argb(204, 255, 255, 255);

    public FontAwesomeDrawable(Context context, String text, int color) {
        super(context, text, color, context.getResources().getDimensionPixelSize(R.dimen.textSize), context.getResources().getDimensionPixelSize(R.dimen.padding));
    }

    @Override
    protected String getStringResource(String identifier) {
        if (identifier.contains("-")) {
            identifier = identifier.replace("-", "_");
        }
        try {
            String packageName = mContext.getPackageName();
            int resourceId = mContext.getResources().getIdentifier(identifier, "string", packageName);
            if (resourceId != 0) {
                String iconId = mContext.getResources().getString(resourceId);
                return iconId;
            }
            else if (Cobalt.DEBUG) Log.e(TAG, "- getStringResource : no found resource");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected String getFontFilePath() {
        return FONT_FILE;
    }
}
