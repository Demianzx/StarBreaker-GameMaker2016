//
//  Created by Jose Neto
//  www.infinity8games.com
//
//


package ${YYAndroidPackageName};



import ${YYAndroidPackageName}.RunnerActivity;
import com.yoyogames.runner.RunnerJNILib;
import com.unity3d.ads.android.UnityAds;
import com.unity3d.ads.android.IUnityAdsListener;
import android.util.Log;
import com.yoyogames.runner.RunnerJNILib;

public class UnityAdsExt implements IUnityAdsListener
{
	int EVENT_OTHER_SOCIAL = 70;
	
	public void UnityAds_Init(String _app_id)
	{
		final String app_id = _app_id;
		
		Log.i("yoyo","Initialising UnityAds with activity "+RunnerActivity.CurrentActivity);
		RunnerActivity.ViewHandler.post( new Runnable() {
			public void run() {
				UnityAds.init(RunnerActivity.CurrentActivity, app_id, (IUnityAdsListener)UnityAdsExt.this);
			}
		 });
	}
	
	public void UnityAds_TestMode(double _testMode) {
	
		final boolean testMode = (_testMode == 1) ? true : false;
		RunnerActivity.ViewHandler.post( new Runnable() {
			public void run() {
				UnityAds.setTestMode(testMode);
			}
		 });
		 
	}
	
	public double UnityAds_IsReady() {
		
		boolean showRes = (UnityAds.canShow() && UnityAds.canShowAds());
		double ready = (showRes) ? 1 : 0;
		
		return ready;
	}
	
	public void UnityAds_Show() {
		
		Log.i("yoyo","UnityAds_Show Ad");
		RunnerActivity.ViewHandler.post( new Runnable() {
			public void run() {
				if(UnityAds.canShow() && UnityAds.canShowAds()) {
					UnityAds.show();
				}	
			}
		 });
	}
	
	 @Override
    public void onHide() {
	
       int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
	   RunnerJNILib.DsMapAddString( dsMapIndex, "type", "hide_unity_ads" );
	   RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
	   Log.i("yoyo","UnityAds_onHide ");
		
    }

    @Override
    public void onShow() {
	
       int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
	   RunnerJNILib.DsMapAddString( dsMapIndex, "type", "show_unity_ads" );
	   RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
	   Log.i("yoyo","UnityAds_onShow ");
	   
    }

    @Override
    public void onVideoStarted() {
	
       int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
	   RunnerJNILib.DsMapAddString( dsMapIndex, "type", "video_started_unity_ads" );
	   RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
	   Log.i("yoyo","UnityAds_onVideoStarted ");
    }

    @Override
    public void onVideoCompleted(String item, boolean skipped) {
      
	    int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
		RunnerJNILib.DsMapAddString( dsMapIndex, "type", "video_completed_unity_ads" );
		double shown = (skipped) ? 1 : 0;
		RunnerJNILib.DsMapAddString( dsMapIndex, "item", item );
		RunnerJNILib.DsMapAddDouble( dsMapIndex,"skipped",shown);
		RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
		Log.i("yoyo","UnityAds_onVideoCompleted ");
	  
    }

    @Override
    public void onFetchCompleted() {
        
	   int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
	   RunnerJNILib.DsMapAddString( dsMapIndex, "type", "fetch_completed_unity_ads" );
	   RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
	   Log.i("yoyo","UnityAds_onFetchCompleted ");
		
    }

    @Override
    public void onFetchFailed() {
	
       int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
	   RunnerJNILib.DsMapAddString( dsMapIndex, "type", "fetch_failed_unity_ads" );
	   RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
	   Log.i("yoyo","UnityAds_onFetchFailed ");
		
    }
	
	
}


