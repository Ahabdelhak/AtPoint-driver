package atpoint.com.Common;

import atpoint.com.Remote.FCMClient;
import atpoint.com.Remote.IFCMService;

/**
 * Created by ah_abdelhak on 2/28/2018.
 */
public class Common {
    //firebase tables

    public static final String mechanic_tbl="Mechanic";// store all the information of Mechanic locations
    public static final String user_Mechanic_tbl="MechanicInformation";//store all the info of Mechanics who registered
    public static final String user_driver_tbl="DriverInformation";//store all the info of driver who registered
    public static final String pickup_request_tbl="PickupRequest";//store information about pickup Request of user


    public static final String token_table="Tokens";
    public static final String fcmURL="https://fcm.googleapis.com/";


    public static IFCMService getFcmService(){
        return FCMClient.getClent(fcmURL).create(IFCMService.class);
    }
}
