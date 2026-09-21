/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDELogicLinkType
extends BaseDataEntity {
    public static final String TAG_PSDELLTYPEID = "PSDELLTYPEID";
    public static final String TAG_PSDELLTYPENAME = "PSDELLTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ITEMOBJ = "ITEMOBJ";
    public static final String TAG_ITEMOBJ2 = "ITEMOBJ2";

    public final boolean isPSDELLTYPEIDNull() {
        return this.IsParamNull(TAG_PSDELLTYPEID);
    }

    public final String getPSDELLTYPEID() {
        return this.GetParamStringValue(TAG_PSDELLTYPEID, "");
    }

    public final void setPSDELLTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDELLTYPEID, strValue);
    }

    public final boolean isPSDELLTYPENAMENull() {
        return this.IsParamNull(TAG_PSDELLTYPENAME);
    }

    public final String getPSDELLTYPENAME() {
        return this.GetParamStringValue(TAG_PSDELLTYPENAME, "");
    }

    public final void setPSDELLTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDELLTYPENAME, strValue);
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

    public final boolean isITEMOBJNull() {
        return this.IsParamNull(TAG_ITEMOBJ);
    }

    public final String getITEMOBJ() {
        return this.GetParamStringValue(TAG_ITEMOBJ, "");
    }

    public final void setITEMOBJ(String strValue) {
        this.SetParamValue(TAG_ITEMOBJ, strValue);
    }

    public final boolean isITEMOBJ2Null() {
        return this.IsParamNull(TAG_ITEMOBJ2);
    }

    public final String getITEMOBJ2() {
        return this.GetParamStringValue(TAG_ITEMOBJ2, "");
    }

    public final void setITEMOBJ2(String strValue) {
        this.SetParamValue(TAG_ITEMOBJ2, strValue);
    }
}

