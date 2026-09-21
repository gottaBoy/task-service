/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class MobileApp
extends BaseDataEntity {
    public static final String TAG_MOBILEAPPID = "MOBILEAPPID";
    public static final String TAG_MOBILEAPPNAME = "MOBILEAPPNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_MAINMENUID = "MAINMENUID";
    public static final String TAG_MAINMENUNAME = "MAINMENUNAME";
    public static final String TAG_OLDBPATH = "OLDBPATH";
    public static final String TAG_OFFLINEMENUID = "OFFLINEMENUID";
    public static final String TAG_OFFLINEMENUNAME = "OFFLINEMENUNAME";
    public static final String TAG_OLRESPATH = "OLRESPATH";
    public static final String TAG_APPRESFOLDER = "APPRESFOLDER";

    public final boolean isMOBILEAPPIDNull() {
        return this.IsParamNull(TAG_MOBILEAPPID);
    }

    public final String getMOBILEAPPID() {
        return this.GetParamStringValue(TAG_MOBILEAPPID, "");
    }

    public final void setMOBILEAPPID(String strValue) {
        this.SetParamValue(TAG_MOBILEAPPID, strValue);
    }

    public final boolean isMOBILEAPPNAMENull() {
        return this.IsParamNull(TAG_MOBILEAPPNAME);
    }

    public final String getMOBILEAPPNAME() {
        return this.GetParamStringValue(TAG_MOBILEAPPNAME, "");
    }

    public final void setMOBILEAPPNAME(String strValue) {
        this.SetParamValue(TAG_MOBILEAPPNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isMAINMENUIDNull() {
        return this.IsParamNull(TAG_MAINMENUID);
    }

    public final String getMAINMENUID() {
        return this.GetParamStringValue(TAG_MAINMENUID, "");
    }

    public final void setMAINMENUID(String strValue) {
        this.SetParamValue(TAG_MAINMENUID, strValue);
    }

    public final boolean isMAINMENUNAMENull() {
        return this.IsParamNull(TAG_MAINMENUNAME);
    }

    public final String getMAINMENUNAME() {
        return this.GetParamStringValue(TAG_MAINMENUNAME, "");
    }

    public final void setMAINMENUNAME(String strValue) {
        this.SetParamValue(TAG_MAINMENUNAME, strValue);
    }

    public final boolean isOLDBPATHNull() {
        return this.IsParamNull(TAG_OLDBPATH);
    }

    public final String getOLDBPATH() {
        return this.GetParamStringValue(TAG_OLDBPATH, "");
    }

    public final void setOLDBPATH(String strValue) {
        this.SetParamValue(TAG_OLDBPATH, strValue);
    }

    public final boolean isOFFLINEMENUIDNull() {
        return this.IsParamNull(TAG_OFFLINEMENUID);
    }

    public final String getOFFLINEMENUID() {
        return this.GetParamStringValue(TAG_OFFLINEMENUID, "");
    }

    public final void setOFFLINEMENUID(String strValue) {
        this.SetParamValue(TAG_OFFLINEMENUID, strValue);
    }

    public final boolean isOFFLINEMENUNAMENull() {
        return this.IsParamNull(TAG_OFFLINEMENUNAME);
    }

    public final String getOFFLINEMENUNAME() {
        return this.GetParamStringValue(TAG_OFFLINEMENUNAME, "");
    }

    public final void setOFFLINEMENUNAME(String strValue) {
        this.SetParamValue(TAG_OFFLINEMENUNAME, strValue);
    }

    public final boolean isOLRESPATHNull() {
        return this.IsParamNull(TAG_OLRESPATH);
    }

    public final String getOLRESPATH() {
        return this.GetParamStringValue(TAG_OLRESPATH, "");
    }

    public final void setOLRESPATH(String strValue) {
        this.SetParamValue(TAG_OLRESPATH, strValue);
    }

    public final boolean isAPPRESFOLDERNull() {
        return this.IsParamNull(TAG_APPRESFOLDER);
    }

    public final String getAPPRESFOLDER() {
        return this.GetParamStringValue(TAG_APPRESFOLDER, "");
    }

    public final void setAPPRESFOLDER(String strValue) {
        this.SetParamValue(TAG_APPRESFOLDER, strValue);
    }
}

