//
//  UnityAdsExt.mm
//  iPad_JoseNeto
//
//  Created by NetoX on 11/01/2015.
//
//

#import "UnityAdsExt.h"


@implementation UnityAdsExt


const int EVENT_OTHER_SOCIAL = 70;
extern int CreateDsMap( int _num, ... );
extern void CreateAsynEventWithDSMap(int dsmapindex, int event_index);

	- (void) UnityAds_Init:(char *) arg1

		{NSString *appid = [NSString stringWithCString:arg1 encoding:NSUTF8StringEncoding];
		UIViewController *activeController = [UIApplication sharedApplication].keyWindow.rootViewController;
		
		[[UnityAds sharedInstance] startWithGameId:appid andViewController:activeController];
		[[UnityAds sharedInstance] setDelegate:self];
		
	}

	-(void) UnityAds_TestMode:(double) testMode
	{
		[[UnityAds sharedInstance] setTestMode:testMode];

	}

	- (double) UnityAds_IsReady
	{
		if([[UnityAds sharedInstance] canShow] && [[UnityAds sharedInstance] canShowAds])
			return 1;
		return 0;
	}

	-(void) UnityAds_Show
	{
		if ([[UnityAds sharedInstance] canShow] && [[UnityAds sharedInstance] canShowAds])
		{
			// If both are ready, show the ad.
			[[UnityAds sharedInstance] show];
		}

	}


	- (void)unityAdsVideoCompleted:(NSString *)rewardItemKey skipped:(BOOL)skipped
	{
			NSLog(@"UnityAds_onVideoCompleted");
	   
			double shown = (skipped) ? 1 : 0;
			int dsMapIndex = CreateDsMap(2,
							"type",0.0, "video_completed_unity_ads",
							"skipped",(double) shown,(void *)NULL,
							"item",0.0,[rewardItemKey UTF8String]
							);
			CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
	  
	}


	-(void) unityAdsDidHide
	{
		NSLog(@"UnityAds_onHide");
   
		int dsMapIndex = CreateDsMap(2,
						"type",0.0, "hide_unity_ads"
						);
		CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
	
		
    }

	-(void) unityAdsDidShow
	{
		NSLog(@"UnityAds_onShow");
   
		int dsMapIndex = CreateDsMap(2,
						"type",0.0, "show_unity_ads"
						);
		CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
	
		
    }
	
	-(void) unityAdsVideoStarted
	{
		NSLog(@"UnityAds_onVideoStarted");
   
		int dsMapIndex = CreateDsMap(2,
						"type",0.0, "video_started_unity_ads"
						);
		CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
		
    }

	-(void) unityAdsFetchCompleted
	{
		NSLog(@"UnityAds_onFetchCompleted");
   
		int dsMapIndex = CreateDsMap(2,
						"type",0.0, "fetch_completed_unity_ads"
						);
		CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
		
    }


	-(void) unityAdsFetchFailed
	{
		NSLog(@"UnityAds_onFetchFailed");
   
		int dsMapIndex = CreateDsMap(2,
						"type",0.0, "fetch_failed_unity_ads"
						);
		CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
	
		
    }


@end

