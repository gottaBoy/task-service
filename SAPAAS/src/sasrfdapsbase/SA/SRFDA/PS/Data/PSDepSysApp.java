/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSysApp
extends BaseDataEntity {
    public static final String PSDEPSYSAPPTYPE_DEVSLNSYS = "DEVSLNSYS";
    public static final String PSDEPSYSAPPTYPE_SAASSYS = "SAASSYS";
    public static final String TAG_PSDEPSYSAPPID = "PSDEPSYSAPPID";
    public static final String TAG_PSDEPSYSAPPNAME = "PSDEPSYSAPPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEPSYSVERID = "PSDEPSYSVERID";
    public static final String TAG_PSDEPSYSVERNAME = "PSDEPSYSVERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEPSYSAPPTYPE = "PSDEPSYSAPPTYPE";

    public final boolean isPSDEPSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSDEPSYSAPPID);
    }

    public final String getPSDEPSYSAPPID() {
        return this.GetParamStringValue(TAG_PSDEPSYSAPPID, "");
    }

    public final void setPSDEPSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSAPPID, strValue);
    }

    public final boolean isPSDEPSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSDEPSYSAPPNAME);
    }

    public final String getPSDEPSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSDEPSYSAPPNAME, "");
    }

    public final void setPSDEPSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSAPPNAME, strValue);
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

    public final boolean isPSDEPSYSVERIDNull() {
        return this.IsParamNull(TAG_PSDEPSYSVERID);
    }

    public final String getPSDEPSYSVERID() {
        return this.GetParamStringValue(TAG_PSDEPSYSVERID, "");
    }

    public final void setPSDEPSYSVERID(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSVERID, strValue);
    }

    public final boolean isPSDEPSYSVERNAMENull() {
        return this.IsParamNull(TAG_PSDEPSYSVERNAME);
    }

    public final String getPSDEPSYSVERNAME() {
        return this.GetParamStringValue(TAG_PSDEPSYSVERNAME, "");
    }

    public final void setPSDEPSYSVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSVERNAME, strValue);
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

    public final boolean isPSDEPSYSAPPTYPENull() {
        return this.IsParamNull(TAG_PSDEPSYSAPPTYPE);
    }

    public final String getPSDEPSYSAPPTYPE() {
        return this.GetParamStringValue(TAG_PSDEPSYSAPPTYPE, "");
    }

    public final void setPSDEPSYSAPPTYPE(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSAPPTYPE, strValue);
    }
}

