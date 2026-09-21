/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.WT.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WTAccount
extends BaseDataEntity {
    public static final String TAG_WTACCOUNTID = "WTACCOUNTID";
    public static final String TAG_WTACCOUNTNAME = "WTACCOUNTNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_APIURL = "APIURL";
    public static final String TAG_APITOKEN = "APITOKEN";
    public static final String TAG_APIAPPID = "APIAPPID";
    public static final String TAG_APIAPPSECRET = "APIAPPSECRET";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ENABLEADVAPI = "ENABLEADVAPI";

    public final boolean isWTACCOUNTIDNull() {
        return this.IsParamNull(TAG_WTACCOUNTID);
    }

    public final String getWTACCOUNTID() {
        return this.GetParamStringValue(TAG_WTACCOUNTID, "");
    }

    public final void setWTACCOUNTID(String strValue) {
        this.SetParamValue(TAG_WTACCOUNTID, strValue);
    }

    public final boolean isWTACCOUNTNAMENull() {
        return this.IsParamNull(TAG_WTACCOUNTNAME);
    }

    public final String getWTACCOUNTNAME() {
        return this.GetParamStringValue(TAG_WTACCOUNTNAME, "");
    }

    public final void setWTACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_WTACCOUNTNAME, strValue);
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

    public final boolean isAPIURLNull() {
        return this.IsParamNull(TAG_APIURL);
    }

    public final String getAPIURL() {
        return this.GetParamStringValue(TAG_APIURL, "");
    }

    public final void setAPIURL(String strValue) {
        this.SetParamValue(TAG_APIURL, strValue);
    }

    public final boolean isAPITOKENNull() {
        return this.IsParamNull(TAG_APITOKEN);
    }

    public final String getAPITOKEN() {
        return this.GetParamStringValue(TAG_APITOKEN, "");
    }

    public final void setAPITOKEN(String strValue) {
        this.SetParamValue(TAG_APITOKEN, strValue);
    }

    public final boolean isAPIAPPIDNull() {
        return this.IsParamNull(TAG_APIAPPID);
    }

    public final String getAPIAPPID() {
        return this.GetParamStringValue(TAG_APIAPPID, "");
    }

    public final void setAPIAPPID(String strValue) {
        this.SetParamValue(TAG_APIAPPID, strValue);
    }

    public final boolean isAPIAPPSECRETNull() {
        return this.IsParamNull(TAG_APIAPPSECRET);
    }

    public final String getAPIAPPSECRET() {
        return this.GetParamStringValue(TAG_APIAPPSECRET, "");
    }

    public final void setAPIAPPSECRET(String strValue) {
        this.SetParamValue(TAG_APIAPPSECRET, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isENABLEADVAPINull() {
        return this.IsParamNull(TAG_ENABLEADVAPI);
    }

    public final boolean getENABLEADVAPI() {
        return this.GetParamIntValue(TAG_ENABLEADVAPI, 0) == 1;
    }

    public final void setENABLEADVAPI(boolean bValue) {
        this.SetParamValue(TAG_ENABLEADVAPI, bValue ? 1 : 0);
    }
}

