/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.dfp;

import java.io.IOException;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import android.os.Bundle;
import android.location.Location;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.AdSize;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

@Kroll.module(name="Dfp", id="ti.dfp")
public class DfpModule extends KrollModule
{
	// Standard Debugging variables
	private static final String LCAT = "DfpModule";
	private static final boolean DBG = TiConfig.LOGD;

    // note -- I would have preferred to just expose PublisherAdRequest.DEVICE_ID_EMULATOR
    // as the constant, but I got nasty build errors like 
    // [exec] jni/ti.dfp.DfpModule.cpp: In static member function 'static v8::Handle<v8::FunctionTemplate> ti::dfp::DfpModule::getProxyTemplate()':
    // [exec] jni/ti.dfp.DfpModule.cpp:113:3: error: no matching function for call to 'v8::String::New(_jobject*&)'
    
	@Kroll.constant
	public static final String EMULATOR_ID = "[[[[[ -- PublisherAdRequest.DEVICE_ID_EMULATOR -- ]]]]]";

	public static String[] TEST_DEVICES = {};
	public static String ADUNIT_ID;

    public static Location LOCATION = null;

    public static Bundle CUSTOM_TARGETING = null;

    public static Boolean SUPPRESS_SCROLL = true;
 
 	public static Integer ADHEIGHT = 0;
 	public static Integer ADWIDTH = 0;
    
    public static AdSize[] AD_SIZES;

	// *
	public static String PROPERTY_COLOR_BG =     "adBackgroundColor";
	public static String PROPERTY_COLOR_BG_TOP = "backgroundTopColor";
	public static String PROPERTY_COLOR_BORDER = "borderColor";
	public static String PROPERTY_COLOR_TEXT =   "textColor";
	public static String PROPERTY_COLOR_LINK =   "linkColor";
	public static String PROPERTY_COLOR_URL =    "urlColor";

	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;

	public DfpModule()
	{
		super();
		Log.d(LCAT, "module instantiated");
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(LCAT, "inside onAppCreate");
		// put module init code that needs to run when the application is created
	}

	// must be done before the call to instantiate the view
	@Kroll.method
	public void setAdUnitId(String adUnitId) {
		Log.d(LCAT, "setAdUnitId(): " + adUnitId);
		ADUNIT_ID = adUnitId;
	}

    @Kroll.method
    public String getAdvertisingId ()
    {
        AdvertisingIdClient.Info adInfo = null;
 
        try {
             adInfo = AdvertisingIdClient.getAdvertisingIdInfo(TiApplication.getInstance());
        } catch (Exception e) {
             return "";
        }
 
        return adInfo.getId();
    }

    @Kroll.method
    public boolean getAdTrackingDisabled ()
    {
        AdvertisingIdClient.Info adInfo = null;
 
        try {
             adInfo = AdvertisingIdClient.getAdvertisingIdInfo(TiApplication.getInstance());
        } catch (Exception e) {
             return false;
        }
 
        boolean retval = adInfo.isLimitAdTrackingEnabled();

        if (retval)
        {
		    Log.d(LCAT, "isLimitAdTrackingEnabled() = true");
        }
        else
        {
		    Log.d(LCAT, "isLimitAdTrackingEnabled() = false");
        }

        return retval;
    }
}

