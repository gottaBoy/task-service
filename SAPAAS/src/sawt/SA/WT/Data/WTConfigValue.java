/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.WT.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WTConfigValue
extends BaseDataEntity {
    public static final String TAG_WTCONFIGVALUEID = "WTCONFIGVALUEID";
    public static final String TAG_WTCONFIGVALUENAME = "WTCONFIGVALUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CONFIGVALUE = "CONFIGVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_WTCONFIGTYPEID = "WTCONFIGTYPEID";
    public static final String TAG_WTCONFIGTYPENAME = "WTCONFIGTYPENAME";

    public final boolean isWTCONFIGVALUEIDNull() {
        return this.IsParamNull(TAG_WTCONFIGVALUEID);
    }

    public final String getWTCONFIGVALUEID() {
        return this.GetParamStringValue(TAG_WTCONFIGVALUEID, "");
    }

    public final void setWTCONFIGVALUEID(String strValue) {
        this.SetParamValue(TAG_WTCONFIGVALUEID, strValue);
    }

    public final boolean isWTCONFIGVALUENAMENull() {
        return this.IsParamNull(TAG_WTCONFIGVALUENAME);
    }

    public final String getWTCONFIGVALUENAME() {
        return this.GetParamStringValue(TAG_WTCONFIGVALUENAME, "");
    }

    public final void setWTCONFIGVALUENAME(String strValue) {
        this.SetParamValue(TAG_WTCONFIGVALUENAME, strValue);
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

    public final boolean isCONFIGVALUENull() {
        return this.IsParamNull(TAG_CONFIGVALUE);
    }

    public final String getCONFIGVALUE() {
        return this.GetParamStringValue(TAG_CONFIGVALUE, "");
    }

    public final void setCONFIGVALUE(String strValue) {
        this.SetParamValue(TAG_CONFIGVALUE, strValue);
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

    public final boolean isWTCONFIGTYPEIDNull() {
        return this.IsParamNull(TAG_WTCONFIGTYPEID);
    }

    public final String getWTCONFIGTYPEID() {
        return this.GetParamStringValue(TAG_WTCONFIGTYPEID, "");
    }

    public final void setWTCONFIGTYPEID(String strValue) {
        this.SetParamValue(TAG_WTCONFIGTYPEID, strValue);
    }

    public final boolean isWTCONFIGTYPENAMENull() {
        return this.IsParamNull(TAG_WTCONFIGTYPENAME);
    }

    public final String getWTCONFIGTYPENAME() {
        return this.GetParamStringValue(TAG_WTCONFIGTYPENAME, "");
    }

    public final void setWTCONFIGTYPENAME(String strValue) {
        this.SetParamValue(TAG_WTCONFIGTYPENAME, strValue);
    }
}

