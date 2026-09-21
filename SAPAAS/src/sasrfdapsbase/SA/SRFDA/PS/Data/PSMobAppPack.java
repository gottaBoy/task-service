/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSMobAppPack
extends BaseDataEntity {
    public static final String OSTYPES_IOS = "IOS";
    public static final String OSTYPES_ANDROID = "ANDROID";
    public static final String IOSDEVICES_IPHONE = "IPHONE";
    public static final String IOSDEVICES_IPAD = "IPAD";
    public static final String IOSDEVICES_APPLEWATCH = "APPLEWATCH";
    public static final String IOSPRIVACIES_CAMERA = "CAMERA";
    public static final String IOSPRIVACIES_MICROPHONE = "MICROPHONE";
    public static final String IOSPRIVACIES_READIMAGE = "READIMAGE";
    public static final String IOSPRIVACIES_ADDIMAGE = "ADDIMAGE";
    public static final String IOSPRIVACIES_CONTACTS = "CONTACTS";
    public static final String IOSPRIVACIES_LOC = "LOC";
    public static final String IOSPRIVACIES_LOCATION = "LOCATION";
    public static final String IOSPRIVACIES_BLUETOOTHSHARING = "BLUETOOTHSHARING";
    public static final String IOSPRIVACIES_CALENDARS = "CALENDARS";
    public static final String IOSPRIVACIES_HEALTHSHARING = "HEALTHSHARING";
    public static final String IOSPRIVACIES_HEALTHUPDATE = "HEALTHUPDATE";
    public static final String IOSPRIVACIES_HOMEKIT = "HOMEKIT";
    public static final String IOSPRIVACIES_MOTION_FITNESS = "MOTION_FITNESS";
    public static final String IOSPRIVACIES_REMINDERS = "REMINDERS";
    public static final String IOSPRIVACIES_Siri = "Siri";
    public static final String IOSPRIVACIES_SPEECHRECOG = "SPEECHRECOG";
    public static final String IOSPRIVACIES_MEDIALIBRARY = "MEDIALIBRARY";
    public static final String IOSPRIVACIES_READNFC = "READNFC";
    public static final String ANDROIDPERMISSIONS_PHONE = "PHONE";
    public static final String ANDROIDPERMISSIONS_SMS = "SMS";
    public static final String ANDROIDPERMISSIONS_LOCATION = "LOCATION";
    public static final String ANDROIDPERMISSIONS_CONTACTS = "CONTACTS";
    public static final String ANDROIDPERMISSIONS_CAMERA = "CAMERA";
    public static final String ANDROIDPERMISSIONS_BLUETOOTH = "BLUETOOTH";
    public static final String ANDROIDPERMISSIONS_FLASHLIGHT = "FLASHLIGHT";
    public static final String ANDROIDPERMISSIONS_SYSLOG = "SYSLOG";
    public static final String ANDROIDPERMISSIONS_AUTOSTART = "AUTOSTART";
    public static final String ANDROIDPERMISSIONS_RECORD = "RECORD";
    public static final String PACKTYPE_TEST = "TEST";
    public static final String PACKTYPE_OFFICIAL = "OFFICIAL";
    public static final String TAG_PSMOBAPPPACKID = "PSMOBAPPPACKID";
    public static final String TAG_PSMOBAPPPACKNAME = "PSMOBAPPPACKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PKGNAME = "PKGNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_OSTYPES = "OSTYPES";
    public static final String TAG_ENABLEIOS = "ENABLEIOS";
    public static final String TAG_ENABLEANDROID = "ENABLEANDROID";
    public static final String TAG_IOSDEVICES = "IOSDEVICES";
    public static final String TAG_IOSPRIVACIES = "IOSPRIVACIES";
    public static final String TAG_ANDROIDPERMISSIONS = "ANDROIDPERMISSIONS";
    public static final String TAG_PACKTYPE = "PACKTYPE";
    public static final String TAG_ENABLEENCRYPTION = "ENABLEENCRYPTION";
    public static final String TAG_PSDCMOBPACKCERTID = "PSDCMOBPACKCERTID";
    public static final String TAG_PSDCMOBPACKCERTNAME = "PSDCMOBPACKCERTNAME";
    public static final String TAG_TDCNT = "TDCNT";
    public static final String TAG_VERSION = "VERSION";

    public final boolean isPSMOBAPPPACKIDNull() {
        return this.IsParamNull(TAG_PSMOBAPPPACKID);
    }

    public final String getPSMOBAPPPACKID() {
        return this.GetParamStringValue(TAG_PSMOBAPPPACKID, "");
    }

    public final void setPSMOBAPPPACKID(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPPACKID, strValue);
    }

    public final boolean isPSMOBAPPPACKNAMENull() {
        return this.IsParamNull(TAG_PSMOBAPPPACKNAME);
    }

    public final String getPSMOBAPPPACKNAME() {
        return this.GetParamStringValue(TAG_PSMOBAPPPACKNAME, "");
    }

    public final void setPSMOBAPPPACKNAME(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPPACKNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPKGNAMENull() {
        return this.IsParamNull(TAG_PKGNAME);
    }

    public final String getPKGNAME() {
        return this.GetParamStringValue(TAG_PKGNAME, "");
    }

    public final void setPKGNAME(String strValue) {
        this.SetParamValue(TAG_PKGNAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isOSTYPESNull() {
        return this.IsParamNull(TAG_OSTYPES);
    }

    public final String getOSTYPES() {
        return this.GetParamStringValue(TAG_OSTYPES, "");
    }

    public final void setOSTYPES(String strValue) {
        this.SetParamValue(TAG_OSTYPES, strValue);
    }

    public final boolean isENABLEIOSNull() {
        return this.IsParamNull(TAG_ENABLEIOS);
    }

    public final boolean getENABLEIOS() {
        return this.GetParamIntValue(TAG_ENABLEIOS, 0) == 1;
    }

    public final void setENABLEIOS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEIOS, bValue ? 1 : 0);
    }

    public final boolean isENABLEANDROIDNull() {
        return this.IsParamNull(TAG_ENABLEANDROID);
    }

    public final boolean getENABLEANDROID() {
        return this.GetParamIntValue(TAG_ENABLEANDROID, 0) == 1;
    }

    public final void setENABLEANDROID(boolean bValue) {
        this.SetParamValue(TAG_ENABLEANDROID, bValue ? 1 : 0);
    }

    public final boolean isIOSDEVICESNull() {
        return this.IsParamNull(TAG_IOSDEVICES);
    }

    public final String getIOSDEVICES() {
        return this.GetParamStringValue(TAG_IOSDEVICES, "");
    }

    public final void setIOSDEVICES(String strValue) {
        this.SetParamValue(TAG_IOSDEVICES, strValue);
    }

    public final boolean isIOSPRIVACIESNull() {
        return this.IsParamNull(TAG_IOSPRIVACIES);
    }

    public final String getIOSPRIVACIES() {
        return this.GetParamStringValue(TAG_IOSPRIVACIES, "");
    }

    public final void setIOSPRIVACIES(String strValue) {
        this.SetParamValue(TAG_IOSPRIVACIES, strValue);
    }

    public final boolean isANDROIDPERMISSIONSNull() {
        return this.IsParamNull(TAG_ANDROIDPERMISSIONS);
    }

    public final String getANDROIDPERMISSIONS() {
        return this.GetParamStringValue(TAG_ANDROIDPERMISSIONS, "");
    }

    public final void setANDROIDPERMISSIONS(String strValue) {
        this.SetParamValue(TAG_ANDROIDPERMISSIONS, strValue);
    }

    public final boolean isPACKTYPENull() {
        return this.IsParamNull(TAG_PACKTYPE);
    }

    public final String getPACKTYPE() {
        return this.GetParamStringValue(TAG_PACKTYPE, "");
    }

    public final void setPACKTYPE(String strValue) {
        this.SetParamValue(TAG_PACKTYPE, strValue);
    }

    public final boolean isENABLEENCRYPTIONNull() {
        return this.IsParamNull(TAG_ENABLEENCRYPTION);
    }

    public final boolean getENABLEENCRYPTION() {
        return this.GetParamIntValue(TAG_ENABLEENCRYPTION, 0) == 1;
    }

    public final void setENABLEENCRYPTION(boolean bValue) {
        this.SetParamValue(TAG_ENABLEENCRYPTION, bValue ? 1 : 0);
    }

    public final boolean isPSDCMOBPACKCERTIDNull() {
        return this.IsParamNull(TAG_PSDCMOBPACKCERTID);
    }

    public final String getPSDCMOBPACKCERTID() {
        return this.GetParamStringValue(TAG_PSDCMOBPACKCERTID, "");
    }

    public final void setPSDCMOBPACKCERTID(String strValue) {
        this.SetParamValue(TAG_PSDCMOBPACKCERTID, strValue);
    }

    public final boolean isPSDCMOBPACKCERTNAMENull() {
        return this.IsParamNull(TAG_PSDCMOBPACKCERTNAME);
    }

    public final String getPSDCMOBPACKCERTNAME() {
        return this.GetParamStringValue(TAG_PSDCMOBPACKCERTNAME, "");
    }

    public final void setPSDCMOBPACKCERTNAME(String strValue) {
        this.SetParamValue(TAG_PSDCMOBPACKCERTNAME, strValue);
    }

    public final boolean isTDCNTNull() {
        return this.IsParamNull(TAG_TDCNT);
    }

    public final int getTDCNT() {
        return this.GetParamIntValue(TAG_TDCNT, 0);
    }

    public final void setTDCNT(int nValue) {
        this.SetParamValue(TAG_TDCNT, nValue);
    }

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final String getVERSION() {
        return this.GetParamStringValue(TAG_VERSION, "");
    }

    public final void setVERSION(String strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }
}

