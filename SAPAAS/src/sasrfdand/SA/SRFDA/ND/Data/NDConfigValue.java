/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.ND.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class NDConfigValue
extends BaseDataEntity {
    public static final String TAG_NDCONFIGVALUEID = "NDCONFIGVALUEID";
    public static final String TAG_NDCONFIGVALUENAME = "NDCONFIGVALUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CONFIGVALUE = "CONFIGVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_NDCONFIGTYPEID = "NDCONFIGTYPEID";
    public static final String TAG_NDCONFIGTYPENAME = "NDCONFIGTYPENAME";

    public final boolean isNDCONFIGVALUEIDNull() {
        return this.IsParamNull(TAG_NDCONFIGVALUEID);
    }

    public final String getNDCONFIGVALUEID() {
        return this.GetParamStringValue(TAG_NDCONFIGVALUEID, "");
    }

    public final void setNDCONFIGVALUEID(String strValue) {
        this.SetParamValue(TAG_NDCONFIGVALUEID, strValue);
    }

    public final boolean isNDCONFIGVALUENAMENull() {
        return this.IsParamNull(TAG_NDCONFIGVALUENAME);
    }

    public final String getNDCONFIGVALUENAME() {
        return this.GetParamStringValue(TAG_NDCONFIGVALUENAME, "");
    }

    public final void setNDCONFIGVALUENAME(String strValue) {
        this.SetParamValue(TAG_NDCONFIGVALUENAME, strValue);
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

    public final boolean isNDCONFIGTYPEIDNull() {
        return this.IsParamNull(TAG_NDCONFIGTYPEID);
    }

    public final String getNDCONFIGTYPEID() {
        return this.GetParamStringValue(TAG_NDCONFIGTYPEID, "");
    }

    public final void setNDCONFIGTYPEID(String strValue) {
        this.SetParamValue(TAG_NDCONFIGTYPEID, strValue);
    }

    public final boolean isNDCONFIGTYPENAMENull() {
        return this.IsParamNull(TAG_NDCONFIGTYPENAME);
    }

    public final String getNDCONFIGTYPENAME() {
        return this.GetParamStringValue(TAG_NDCONFIGTYPENAME, "");
    }

    public final void setNDCONFIGTYPENAME(String strValue) {
        this.SetParamValue(TAG_NDCONFIGTYPENAME, strValue);
    }
}

