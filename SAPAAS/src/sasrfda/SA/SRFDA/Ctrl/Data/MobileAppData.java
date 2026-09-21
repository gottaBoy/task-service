/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class MobileAppData
extends BaseDataEntity {
    public static final String TAG_MOBAPPDATAID = "MOBAPPDATAID";
    public static final String TAG_MOBAPPDATANAME = "MOBAPPDATANAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MOBILEAPPID = "MOBILEAPPID";
    public static final String TAG_MOBILEAPPNAME = "MOBILEAPPNAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_OLRESPATH = "OLRESPATH";
    public static final String TAG_SETUPRESPATH = "SETUPRESPATH";

    public final boolean isMOBAPPDATAIDNull() {
        return this.IsParamNull(TAG_MOBAPPDATAID);
    }

    public final String getMOBAPPDATAID() {
        return this.GetParamStringValue(TAG_MOBAPPDATAID, "");
    }

    public final void setMOBAPPDATAID(String strValue) {
        this.SetParamValue(TAG_MOBAPPDATAID, strValue);
    }

    public final boolean isMOBAPPDATANAMENull() {
        return this.IsParamNull(TAG_MOBAPPDATANAME);
    }

    public final String getMOBAPPDATANAME() {
        return this.GetParamStringValue(TAG_MOBAPPDATANAME, "");
    }

    public final void setMOBAPPDATANAME(String strValue) {
        this.SetParamValue(TAG_MOBAPPDATANAME, strValue);
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

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public final void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
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

    public final boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public final int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public final void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
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

    public final boolean isSETUPRESPATHNull() {
        return this.IsParamNull(TAG_SETUPRESPATH);
    }

    public final String getSETUPRESPATH() {
        return this.GetParamStringValue(TAG_SETUPRESPATH, "");
    }

    public final void setSETUPRESPATH(String strValue) {
        this.SetParamValue(TAG_SETUPRESPATH, strValue);
    }
}

