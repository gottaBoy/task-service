/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.WT.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Timestamp;
import java.util.Date;

public class WTAccessToken
extends BaseDataEntity {
    public static final String TAG_WTACCESSTOKENID = "WTACCESSTOKENID";
    public static final String TAG_WTACCESSTOKENNAME = "WTACCESSTOKENNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WTACCOUNTID = "WTACCOUNTID";
    public static final String TAG_WTACCOUNTNAME = "WTACCOUNTNAME";
    public static final String TAG_ACCESSTOKEN = "ACCESSTOKEN";
    public static final String TAG_EXPIREDTIME = "EXPIREDTIME";

    public final boolean isWTACCESSTOKENIDNull() {
        return this.IsParamNull(TAG_WTACCESSTOKENID);
    }

    public final String getWTACCESSTOKENID() {
        return this.GetParamStringValue(TAG_WTACCESSTOKENID, "");
    }

    public final void setWTACCESSTOKENID(String strValue) {
        this.SetParamValue(TAG_WTACCESSTOKENID, strValue);
    }

    public final boolean isWTACCESSTOKENNAMENull() {
        return this.IsParamNull(TAG_WTACCESSTOKENNAME);
    }

    public final String getWTACCESSTOKENNAME() {
        return this.GetParamStringValue(TAG_WTACCESSTOKENNAME, "");
    }

    public final void setWTACCESSTOKENNAME(String strValue) {
        this.SetParamValue(TAG_WTACCESSTOKENNAME, strValue);
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

    public final boolean isACCESSTOKENNull() {
        return this.IsParamNull(TAG_ACCESSTOKEN);
    }

    public final String getACCESSTOKEN() {
        return this.GetParamStringValue(TAG_ACCESSTOKEN, "");
    }

    public final void setACCESSTOKEN(String strValue) {
        this.SetParamValue(TAG_ACCESSTOKEN, strValue);
    }

    public final boolean isEXPIREDTIMENull() {
        return this.IsParamNull(TAG_EXPIREDTIME);
    }

    public final Timestamp getEXPIREDTIME() {
        return this.GetParamTimestampValue(TAG_EXPIREDTIME, null);
    }

    public final void setEXPIREDTIME(Timestamp dtValue) {
        this.SetParamValue(TAG_EXPIREDTIME, dtValue);
    }
}

