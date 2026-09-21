/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.Mob;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPackCert;
import SA.SRFDA.PS.Core.Deploy.IPSMobAppPackServer;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSMobAppPack;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSMobAppPack
extends IPSApplicationObject {
    public static final String CFG_APPID = "mobapp.id";
    public static final String CFG_APPNAME = "mobapp.name";
    public static final String CFG_APPPKGNAME = "mobapp.pkgname";
    public static final String CFG_PACKID = "apppack.id";
    public static final String CFG_PACKPKGNAME = "apppack.pkgname";
    public static final String CFG_PACKNAME = "apppack.name";
    public static final String CFG_PACKTYPE = "apppack.type";
    public static final String CFG_PACKVER = "apppack.ver";
    public static final String CFG_PACKANDROIDPERMISSIONS = "apppack.android.permissions";
    public static final String CFG_PACKIOSDEVICES = "apppack.ios.devices";
    public static final String CFG_PACKIOSPRIVACIES = "apppack.ios.privacies";
    public static final String OSTYPE_IOS = "IOS";
    public static final String OSTYPE_ANDROID = "ANDROID";
    public static final String IOSDEVICE_IPHONE = "IPHONE";
    public static final String IOSDEVICE_IPAD = "IPAD";
    public static final String IOSDEVICE_APPLEWATCH = "APPLEWATCH";
    public static final String IOSPRIVACY_CAMERA = "CAMERA";
    public static final String IOSPRIVACY_MICROPHONE = "MICROPHONE";
    public static final String IOSPRIVACY_READIMAGE = "READIMAGE";
    public static final String IOSPRIVACY_ADDIMAGE = "ADDIMAGE";
    public static final String IOSPRIVACY_CONTACTS = "CONTACTS";
    public static final String IOSPRIVACY_LOC = "LOC";
    public static final String IOSPRIVACY_LOCATION = "LOCATION";
    public static final String IOSPRIVACY_BLUETOOTHSHARING = "BLUETOOTHSHARING";
    public static final String IOSPRIVACY_CALENDARS = "CALENDARS";
    public static final String IOSPRIVACY_HEALTHSHARING = "HEALTHSHARING";
    public static final String IOSPRIVACY_HEALTHUPDATE = "HEALTHUPDATE";
    public static final String IOSPRIVACY_HOMEKIT = "HOMEKIT";
    public static final String IOSPRIVACY_MOTION_FITNESS = "MOTION_FITNESS";
    public static final String IOSPRIVACY_REMINDERS = "REMINDERS";
    public static final String IOSPRIVACY_SIRI = "SIRI";
    public static final String IOSPRIVACY_SPEECHRECOG = "SPEECHRECOG";
    public static final String IOSPRIVACY_MEDIALIBRARY = "MEDIALIBRARY";
    public static final String IOSPRIVACY_READNFC = "READNFC";
    public static final String ANDROIDPERMISSION_PHONE = "PHONE";
    public static final String ANDROIDPERMISSION_SMS = "SMS";
    public static final String ANDROIDPERMISSION_LOCATION = "LOCATION";
    public static final String ANDROIDPERMISSION_CONTACTS = "CONTACTS";
    public static final String ANDROIDPERMISSION_CAMERA = "CAMERA";
    public static final String ANDROIDPERMISSION_BLUETOOTH = "BLUETOOTH";
    public static final String ANDROIDPERMISSION_FLASHLIGHT = "FLASHLIGHT";
    public static final String ANDROIDPERMISSION_SYSLOG = "SYSLOG";
    public static final String ANDROIDPERMISSION_AUTOSTART = "AUTOSTART";
    public static final String ANDROIDPERMISSION_RECORD = "RECORD";
    public static final String PACKTYPE_TEST = "TEST";
    public static final String PACKTYPE_OFFICIAL = "OFFICIAL";

    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSMobAppPack var3) throws Exception;

    public IPSMobAppPackServer getPSMobAppPackServer();

    public boolean isEnableIOS();

    public boolean isEnableAndroid();

    public Iterator<String> getIOSDevices();

    public boolean isSupportIOSDevice(String var1);

    public Iterator<String> getIOSPrivicies();

    public Iterator<String> getAndroidPermissions();

    public String getPackType();

    public String getPKGName();

    public String getPackVersion();

    public IPSMobAppPackCert getPSMobAppPackCert();

    public String getResCfgFilePath();
}

