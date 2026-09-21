/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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
        return this.isParamNull(TAG_PSFORMDETAILTYPEID);
    }

    public final String getPSFORMDETAILTYPEID() {
        return this.getParamStringValue(TAG_PSFORMDETAILTYPEID, "");
    }

    public final void setPSFORMDETAILTYPEID(String strValue) {
        this.setParamValue(TAG_PSFORMDETAILTYPEID, strValue);
    }

    public final boolean isPSFORMDETAILTYPENAMENull() {
        return this.isParamNull(TAG_PSFORMDETAILTYPENAME);
    }

    public final String getPSFORMDETAILTYPENAME() {
        return this.getParamStringValue(TAG_PSFORMDETAILTYPENAME, "");
    }

    public final void setPSFORMDETAILTYPENAME(String strValue) {
        this.setParamValue(TAG_PSFORMDETAILTYPENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isDETAILOBJNull() {
        return this.isParamNull(TAG_DETAILOBJ);
    }

    public final String getDETAILOBJ() {
        return this.getParamStringValue(TAG_DETAILOBJ, "");
    }

    public final void setDETAILOBJ(String strValue) {
        this.setParamValue(TAG_DETAILOBJ, strValue);
    }

    public final boolean isPFDTYPENull() {
        return this.isParamNull(TAG_PFDTYPE);
    }

    public final String getPFDTYPE() {
        return this.getParamStringValue(TAG_PFDTYPE, "");
    }

    public final void setPFDTYPE(String strValue) {
        this.setParamValue(TAG_PFDTYPE, strValue);
    }

    public final boolean isTYPEOBJNull() {
        return this.isParamNull(TAG_TYPEOBJ);
    }

    public final String getTYPEOBJ() {
        return this.getParamStringValue(TAG_TYPEOBJ, "");
    }

    public final void setTYPEOBJ(String strValue) {
        this.setParamValue(TAG_TYPEOBJ, strValue);
    }
}

