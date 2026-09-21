/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSFormDetailType
extends BaseDataEntity {
    public static final String PFDTYPE_FORMPAGE = "FORMPAGE";
    public static final String PFDTYPE_TABPANEL = "TABPANEL";
    public static final String PFDTYPE_TABPAGE = "TABPAGE";
    public static final String PFDTYPE_DATAGRID = "DATAGRID";
    public static final String PFDTYPE_FORMITEM = "FORMITEM";
    public static final String PFDTYPE_USERCONTROL = "USERCONTROL";
    public static final String PFDTYPE_FORMPART = "FORMPART";
    public static final String PFDTYPE_GROUPPANEL = "GROUPPANEL";
    public static final String TAG_PSFORMDETAILTYPEID = "PSFORMDETAILTYPEID";
    public static final String TAG_PSFORMDETAILTYPENAME = "PSFORMDETAILTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DETAILOBJ = "DETAILOBJ";
    public static final String TAG_PFDTYPE = "PFDTYPE";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";

    public final boolean isPSFORMDETAILTYPEIDNull() {
        return this.IsParamNull(TAG_PSFORMDETAILTYPEID);
    }

    public final String getPSFORMDETAILTYPEID() {
        return this.GetParamStringValue(TAG_PSFORMDETAILTYPEID, "");
    }

    public final void setPSFORMDETAILTYPEID(String strValue) {
        this.SetParamValue(TAG_PSFORMDETAILTYPEID, strValue);
    }

    public final boolean isPSFORMDETAILTYPENAMENull() {
        return this.IsParamNull(TAG_PSFORMDETAILTYPENAME);
    }

    public final String getPSFORMDETAILTYPENAME() {
        return this.GetParamStringValue(TAG_PSFORMDETAILTYPENAME, "");
    }

    public final void setPSFORMDETAILTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSFORMDETAILTYPENAME, strValue);
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

    public final boolean isDETAILOBJNull() {
        return this.IsParamNull(TAG_DETAILOBJ);
    }

    public final String getDETAILOBJ() {
        return this.GetParamStringValue(TAG_DETAILOBJ, "");
    }

    public final void setDETAILOBJ(String strValue) {
        this.SetParamValue(TAG_DETAILOBJ, strValue);
    }

    public final boolean isPFDTYPENull() {
        return this.IsParamNull(TAG_PFDTYPE);
    }

    public final String getPFDTYPE() {
        return this.GetParamStringValue(TAG_PFDTYPE, "");
    }

    public final void setPFDTYPE(String strValue) {
        this.SetParamValue(TAG_PFDTYPE, strValue);
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
}

