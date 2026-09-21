/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSysType
extends BaseDataEntity {
    public static final String TAG_PSDEPSYSTYPEID = "PSDEPSYSTYPEID";
    public static final String TAG_PSDEPSYSTYPENAME = "PSDEPSYSTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_TYPEPARAMS = "TYPEPARAMS";
    public static final String TAG_SYSVEROBJ = "SYSVEROBJ";
    public static final String TAG_SYSAPPOBJ = "SYSAPPOBJ";

    public final boolean isPSDEPSYSTYPEIDNull() {
        return this.IsParamNull(TAG_PSDEPSYSTYPEID);
    }

    public final String getPSDEPSYSTYPEID() {
        return this.GetParamStringValue(TAG_PSDEPSYSTYPEID, "");
    }

    public final void setPSDEPSYSTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSTYPEID, strValue);
    }

    public final boolean isPSDEPSYSTYPENAMENull() {
        return this.IsParamNull(TAG_PSDEPSYSTYPENAME);
    }

    public final String getPSDEPSYSTYPENAME() {
        return this.GetParamStringValue(TAG_PSDEPSYSTYPENAME, "");
    }

    public final void setPSDEPSYSTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSTYPENAME, strValue);
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

    public final boolean isTYPEOBJNull() {
        return this.IsParamNull(TAG_TYPEOBJ);
    }

    public final String getTYPEOBJ() {
        return this.GetParamStringValue(TAG_TYPEOBJ, "");
    }

    public final void setTYPEOBJ(String strValue) {
        this.SetParamValue(TAG_TYPEOBJ, strValue);
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

    public final boolean isTYPEPARAMSNull() {
        return this.IsParamNull(TAG_TYPEPARAMS);
    }

    public final String getTYPEPARAMS() {
        return this.GetParamStringValue(TAG_TYPEPARAMS, "");
    }

    public final void setTYPEPARAMS(String strValue) {
        this.SetParamValue(TAG_TYPEPARAMS, strValue);
    }

    public final boolean isSYSVEROBJNull() {
        return this.IsParamNull(TAG_SYSVEROBJ);
    }

    public final String getSYSVEROBJ() {
        return this.GetParamStringValue(TAG_SYSVEROBJ, "");
    }

    public final void setSYSVEROBJ(String strValue) {
        this.SetParamValue(TAG_SYSVEROBJ, strValue);
    }

    public final boolean isSYSAPPOBJNull() {
        return this.IsParamNull(TAG_SYSAPPOBJ);
    }

    public final String getSYSAPPOBJ() {
        return this.GetParamStringValue(TAG_SYSAPPOBJ, "");
    }

    public final void setSYSAPPOBJ(String strValue) {
        this.SetParamValue(TAG_SYSAPPOBJ, strValue);
    }
}

