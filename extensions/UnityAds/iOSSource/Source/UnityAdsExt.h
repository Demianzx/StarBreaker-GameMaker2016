//
//  UnityAdsExt.h
//  iPad_JoseNeto
//
//  Created by NetoX on 11/01/2015.
//
//

#import <UnityAds/UnityAds.h>


@interface UnityAdsExt:NSObject<UnityAdsDelegate>

- (void)UnityAds_Init:(char *)gameId;
- (void)UnityAds_Show;
- (double)UnityAds_IsReady;
- (void)UnityAds_TestMode:(double) testMode;


@end
