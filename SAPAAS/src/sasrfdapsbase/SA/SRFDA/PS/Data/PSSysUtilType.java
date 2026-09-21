/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysUtilType
extends BaseDataEntity {
    public static final String TAG_PSSYSUTILTYPEID = "PSSYSUTILTYPEID";
    public static final String TAG_PSSYSUTILTYPENAME = "PSSYSUTILTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_UTILDESC = "UTILDESC";
    public static final String TAG_UTILOBJ = "UTILOBJ";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_UTILPARAMS = "UTILPARAMS";
    public static final String TAG_UTILRTOBJS = "UTILRTOBJS";
    public static final String TAG_REGTOSYSFLAG = "REGTOSYSFLAG";

    public final boolean isPSSYSUTILTYPEIDNull() {
        return this.IsParamNull(TAG_PSSYSUTILTYPEID);
    }

    public final String getPSSYSUTILTYPEID() {
        return this.GetParamStringValue(TAG_PSSYSUTILTYPEID, "");
    }

    public final void setPSSYSUTILTYPEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUTILTYPEID, strValue);
    }

    public final boolean isPSSYSUTILTYPENAMENull() {
        return this.IsParamNull(TAG_PSSYSUTILTYPENAME);
    }

    public final String getPSSYSUTILTYPENAME() {
        return this.GetParamStringValue(TAG_PSSYSUTILTYPENAME, "");
    }

    public final void setPSSYSUTILTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUTILTYPENAME, strValue);
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

    public final boolean isUTILDESCNull() {
        return this.IsParamNull(TAG_UTILDESC);
    }

    public final String getUTILDESC() {
        return this.GetParamStringValue(TAG_UTILDESC, "");
    }

    public final void setUTILDESC(String strValue) {
        this.SetParamValue(TAG_UTILDESC, strValue);
    }

    public final boolean isUTILOBJNull() {
        return this.IsParamNull(TAG_UTILOBJ);
    }

    public final String getUTILOBJ() {
        return this.GetParamStringValue(TAG_UTILOBJ, "");
    }

    public final void setUTILOBJ(String strValue) {
        this.SetParamValue(TAG_UTILOBJ, strValue);
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

    public final boolean isUTILPARAMSNull() {
        return this.IsParamNull(TAG_UTILPARAMS);
    }

    public final String getUTILPARAMS() {
        return this.GetParamStringValue(TAG_UTILPARAMS, "");
    }

    public final void setUTILPARAMS(String strValue) {
        this.SetParamValue(TAG_UTILPARAMS, strValue);
    }

    public final boolean isUTILRTOBJSNull() {
        return this.IsParamNull(TAG_UTILRTOBJS);
    }

    public final String getUTILRTOBJS() {
        return this.GetParamStringValue(TAG_UTILRTOBJS, "");
    }

    public final void setUTILRTOBJS(String strValue) {
        this.SetParamValue(TAG_UTILRTOBJS, strValue);
    }

    public final boolean isREGTOSYSFLAGNull() {
        return this.IsParamNull(TAG_REGTOSYSFLAG);
    }

    public final boolean getREGTOSYSFLAG() {
        return this.GetParamIntValue(TAG_REGTOSYSFLAG, 0) == 1;
    }

    public final void setREGTOSYSFLAG(boolean bValue) {
        this.SetParamValue(TAG_REGTOSYSFLAG, bValue ? 1 : 0);
    }
}

