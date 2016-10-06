package org.cobaltians.catalog.fragments;

import fr.haploid.webservices.WebServicesInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleHybridFragment extends AbstractFragment implements WebServicesInterface {

	@Override
	protected void onPullToRefreshRefreshed() { }

	@Override
	protected void onInfiniteScrollRefreshed() { }

	@Override
		public JSONObject treatData(JSONObject data, JSONObject process) {
			try {
				int count = process.getInt("count");
				JSONArray imageList = data.getJSONArray("result");

				if (imageList.length() > 0) {
					int max = Math.min(count, imageList.length());
					JSONArray filteredImageList = new JSONArray();

					for (int i = 0; i < max; i++) {
						JSONObject item = imageList.getJSONObject((int) (Math.random() * imageList.length()));

						filteredImageList.put(item);
					}

					data.put("result", filteredImageList);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return data;
		}

    @Override
    public boolean handleError(JSONObject call, JSONObject response) {
        return true;
    }

    @Override
    public boolean storeValue(String value, String key) {
        return false;
    }

    @Override
    public String storedValueForKey(String key) {
        return null;
    }
}
