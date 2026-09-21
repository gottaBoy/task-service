/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMConfigValue
extends BaseDataEntity {
    public static final String TAG_IMCONFIGVALUEID = "IMCONFIGVALUEID";
    public static final String TAG_IMCONFIGVALUENAME = "IMCONFIGVALUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CONFIGVALUE = "CONFIGVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_IMCONFIGTYPEID = "IMCONFIGTYPEID";
    public static final String TAG_IMCONFIGTYPENAME = "IMCONFIGTYPENAME";

    public final boolean isIMCONFIGVALUEIDNull() {
        return this.IsParamNull(TAG_IMCONFIGVALUEID);
    }

    public final String getIMCONFIGVALUEID() {
        return this.GetParamStringValue(TAG_IMCONFIGVALUEID, "");
    }

    public final void setIMCONFIGVALUEID(String strValue) {
        this.SetParamValue(TAG_IMCONFIGVALUEID, strValue);
    }

    public final boolean isIMCONFIGVALUENAMENull() {
        return this.IsParamNull(TAG_IMCONFIGVALUENAME);
    }

    public final String getIMCONFIGVALUENAME() {
        return this.GetParamStringValue(TAG_IMCONFIGVALUENAME, "");
    }

    public final void setIMCONFIGVALUENAME(String strValue) {
        this.SetParamValue(TAG_IMCONFIGVALUENAME, strValue);
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

    public final boolean isIMCONFIGTYPEIDNull() {
        return this.IsParamNull(TAG_IMCONFIGTYPEID);
    }

    public final String getIMCONFIGTYPEID() {
        return this.GetParamStringValue(TAG_IMCONFIGTYPEID, "");
    }

    public final void setIMCONFIGTYPEID(String strValue) {
        this.SetParamValue(TAG_IMCONFIGTYPEID, strValue);
    }

    public final boolean isIMCONFIGTYPENAMENull() {
        return this.IsParamNull(TAG_IMCONFIGTYPENAME);
    }

    public final String getIMCONFIGTYPENAME() {
        return this.GetParamStringValue(TAG_IMCONFIGTYPENAME, "");
    }

    public final void setIMCONFIGTYPENAME(String strValue) {
        this.SetParamValue(TAG_IMCONFIGTYPENAME, strValue);
    }
}

