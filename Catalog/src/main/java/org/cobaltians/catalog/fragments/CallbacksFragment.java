package org.cobaltians.catalog.fragments;

import org.cobaltians.cobalt.Cobalt;
import org.cobaltians.cobalt.fragments.CobaltFragment;
import org.cobaltians.cobalt.pubsub.PubSub;
import org.cobaltians.cobalt.pubsub.PubSubInterface;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public final class CallbacksFragment extends CobaltFragment implements PubSubInterface
{
	private static final String JSDoSomeMathsFromNative = "doSomeMathsFromNative";
    private static final String JSDoSomeMathsFromNativeResponse = "doSomeMathsFromNativeResponse";
    private static final String JSDoSomeMathsFromWeb = "doSomeMathsFromWeb";
    private static final String JSAutoTestsFromNative = "autoTestsFromNative";
    private static final String JSAutoTestsFromNativeCallback = "autoTestsFromNativeCallback";
    private static final String JSAutoTestsFromWeb = "autoTestsFromWeb";
    private static final String kJSValues = "values";
    private static final String kJSResult = "result";
    private static final String kJSIndex = "index";

	private Button btnDoSomeMath, btnTestAuto;

    private ArrayList<String> mArrayTest;
    private boolean testFailed;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    
        mArrayTest = new ArrayList<>(6);
        mArrayTest.add("quotes : it's working \"great\"");
        mArrayTest.add("+ is nice.");
        mArrayTest.add("url &eactue;é&12;\n3#23:%20'\\u0020hop");
        mArrayTest.add("'{ obj_representation : \"test\"}'");
        mArrayTest.add("emoji \ue415 \\ue415 u{1f604}");
        mArrayTest.add("http://42.com?key=xbE%2B49MCgE7/WTKqnvwQ3f4zYmg%3D");
    }
    
    @Override
	protected int getLayoutToInflate()
    {
		return org.cobaltians.catalog.R.layout.callbacks_fragment;
	}

	@Override
	protected void setUpViews(View rootView)
    {
		super.setUpViews(rootView);
		
        btnDoSomeMath = rootView.findViewById(org.cobaltians.catalog.R.id.btnDoSomeMaths);
        btnTestAuto = rootView.findViewById(org.cobaltians.catalog.R.id.btnTestAuto);
	}

	@Override
	protected void setUpListeners()
    {
        btnDoSomeMath.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0)
            {
				try
                {
					ArrayList<Integer> values = new ArrayList<>();
					values.add(1);
					values.add(3);
                    
                    JSONObject message = new JSONObject();
                    message.put(kJSValues, new JSONArray(values));
                    message.put(Cobalt.kJSCallback, JSDoSomeMathsFromNativeResponse);
                    
                    Cobalt.publishMessage(message, JSDoSomeMathsFromNative);
				}
				catch (JSONException e)
                {
					e.printStackTrace();
				}
			}
		});

        btnTestAuto.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                testFailed = false;
                launchTest(0);
            }
        });
	}
    
    @Override
    public void onResume()
    {
        super.onResume();

        Cobalt.subscribeToChannel(JSDoSomeMathsFromWeb, this);
        Cobalt.subscribeToChannel(JSDoSomeMathsFromNativeResponse, this);
        Cobalt.subscribeToChannel(JSAutoTestsFromWeb, this);
        Cobalt.subscribeToChannel(JSAutoTestsFromNativeCallback, this);
    }
    
    @Override
    public void onPause()
    {
        super.onPause();

        Cobalt.unsubscribeFromChannel(JSDoSomeMathsFromWeb, this);
        Cobalt.unsubscribeFromChannel(JSDoSomeMathsFromNativeResponse, this);
        Cobalt.unsubscribeFromChannel(JSAutoTestsFromWeb, this);
        Cobalt.unsubscribeFromChannel(JSAutoTestsFromNativeCallback, this);
    }
    
    @Override
    public void onMessageReceived(@Nullable JSONObject message, @NonNull String channel)
    {
        switch(channel)
        {
            case JSDoSomeMathsFromNativeResponse:
                try
                {
                    if (message != null)
                    {
                        final double result = message.getDouble(kJSResult);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run()
                            {
                                AlertDialog alert = new AlertDialog.Builder(getActivity())
                                        .setTitle("Result")
                                        .setMessage("result is : "+ result)
                                        .setPositiveButton("OK", null)
                                        .create();
                                alert.setCanceledOnTouchOutside(true);
                                alert.show();
                            }
                        });
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                break;
            case JSDoSomeMathsFromWeb:
                try
                {
                    if (message != null)
                    {
                        JSONArray values = message.getJSONArray(kJSValues);
                        double value1 = values.getDouble(0);
                        double value2 = values.getDouble(1);
                        String callback = message.getString(Cobalt.kJSCallback);
    
                        JSONObject doSomeMathsMessage = new JSONObject();
                        doSomeMathsMessage.put(kJSResult, value1 + value2);
    
                        Cobalt.publishMessage(doSomeMathsMessage, callback);
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                break;
            case JSAutoTestsFromWeb:
                try
                {
                    if (message != null)
                    {
                        String callback = message.getString(Cobalt.kJSCallback);
                        
                        Cobalt.publishMessage(message, callback);
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                break;
            case JSAutoTestsFromNativeCallback:
                try
                {
                    if (message != null)
                    {
                        int index = message.getInt(kJSIndex);
                        String value = message.getString(Cobalt.kJSValue);
                        
                        String valueSent = mArrayTest.get(index);
                        
                        if (value.equals(valueSent))
                        {
                            Log.d(TAG, "test OK for the String : " + value);
                        }
                        else
                        {
                            testFailed = true;
                            Log.e(TAG, "test failed !!!! send is : " + valueSent);
                            Log.e(TAG, "received : " + value);
                        }
                        
                        if (index < mArrayTest.size() - 1)
                        {
                            launchTest(++index);
                        }
                        else if (index == mArrayTest.size() - 1)
                        {
                            if (testFailed)
                            {
                                Toast.makeText(mContext,
                                               "Some tests failed ! Check logs.",
                                               Toast.LENGTH_SHORT)
                                     .show();
                            }
                            else
                            {
                                Toast.makeText(mContext,
                                               "All tests passed ! No errors",
                                               Toast.LENGTH_SHORT)
                                     .show();
                            }
                        }
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void launchTest(final int index)
    {
        try
        {
            JSONObject message = new JSONObject();
            message.put(kJSIndex, index);
            message.put(Cobalt.kJSValue, mArrayTest.get(index));
            message.put(Cobalt.kJSCallback, JSAutoTestsFromNativeCallback);

            Cobalt.publishMessage(message, JSAutoTestsFromNative);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
