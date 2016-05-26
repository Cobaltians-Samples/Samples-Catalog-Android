package org.cobaltians.catalog.fragments;

import fr.haploid.webservices.WebServicesInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleHybridFragment extends AbstractFragment implements WebServicesInterface {

	private JSONArray generateBigData(int size)
	{
		JSONArray a = new JSONArray();
		for(int i = 0 ; i < size ; i++)
		{
			String name = (i%2 == 0) ? "Léo" : "Popi";
			String imageName = "img/ic_launcher.png";
			double age = (i <= 100) ? i : i/100.0;

			JSONObject j = new JSONObject();
			try {
				j.put("username", name);
				j.put("userimage", imageName);
				j.put("userage", age);
				a.put(j);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return a;
	}

	//  unhandled JS messages
	@Override
	protected void onUnhandledMessage(JSONObject message) {

    }

    @Override
	protected boolean onUnhandledEvent(String name, JSONObject data, String callback) {
        if (super.onUnhandledEvent(name, data, callback)) return true;
		else return false;
	}

	@Override
	protected boolean onUnhandledCallback(String name, JSONObject data) {
		return false;
	}

	@Override
	protected void onPullToRefreshRefreshed() {

	}

	@Override
	protected void onInfiniteScrollRefreshed() {

	}

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
