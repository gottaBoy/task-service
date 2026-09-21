/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepToolType
extends BaseDataEntity {
    public static final String TAG_PSDEPTOOLTYPEID = "PSDEPTOOLTYPEID";
    public static final String TAG_PSDEPTOOLTYPENAME = "PSDEPTOOLTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PACKOBJ = "PACKOBJ";
    public static final String TAG_DEPOBJ = "DEPOBJ";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSDEPTOOLTYPEIDNull() {
        return this.IsParamNull(TAG_PSDEPTOOLTYPEID);
    }

    public final String getPSDEPTOOLTYPEID() {
        return this.GetParamStringValue(TAG_PSDEPTOOLTYPEID, "");
    }

    public final void setPSDEPTOOLTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDEPTOOLTYPEID, strValue);
    }

    public final boolean isPSDEPTOOLTYPENAMENull() {
        return this.IsParamNull(TAG_PSDEPTOOLTYPENAME);
    }

    public final String getPSDEPTOOLTYPENAME() {
        return this.GetParamStringValue(TAG_PSDEPTOOLTYPENAME, "");
    }

    public final void setPSDEPTOOLTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDEPTOOLTYPENAME, strValue);
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

    public final boolean isPACKOBJNull() {
        return this.IsParamNull(TAG_PACKOBJ);
    }

    public final String getPACKOBJ() {
        return this.GetParamStringValue(TAG_PACKOBJ, "");
    }

    public final void setPACKOBJ(String strValue) {
        this.SetParamValue(TAG_PACKOBJ, strValue);
    }

    public final boolean isDEPOBJNull() {
        return this.IsParamNull(TAG_DEPOBJ);
    }

    public final String getDEPOBJ() {
        return this.GetParamStringValue(TAG_DEPOBJ, "");
    }

    public final void setDEPOBJ(String strValue) {
        this.SetParamValue(TAG_DEPOBJ, strValue);
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
}

