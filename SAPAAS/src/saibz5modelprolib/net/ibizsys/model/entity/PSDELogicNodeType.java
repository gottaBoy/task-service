/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDELogicNodeType
extends BaseDataEntity {
    public static final String TAG_PSDELNTYPEID = "PSDELNTYPEID";
    public static final String TAG_PSDELNTYPENAME = "PSDELNTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_ITEMOBJ = "ITEMOBJ";

    public final boolean isPSDELNTYPEIDNull() {
        return this.isParamNull(TAG_PSDELNTYPEID);
    }

    public final String getPSDELNTYPEID() {
        return this.getParamStringValue(TAG_PSDELNTYPEID, "");
    }

    public final void setPSDELNTYPEID(String strValue) {
        this.setParamValue(TAG_PSDELNTYPEID, strValue);
    }

    public final boolean isPSDELNTYPENAMENull() {
        return this.isParamNull(TAG_PSDELNTYPENAME);
    }

    public final String getPSDELNTYPENAME() {
        return this.getParamStringValue(TAG_PSDELNTYPENAME, "");
    }

    public final void setPSDELNTYPENAME(String strValue) {
        this.setParamValue(TAG_PSDELNTYPENAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isITEMOBJNull() {
        return this.isParamNull(TAG_ITEMOBJ);
    }

    public final String getITEMOBJ() {
        return this.getParamStringValue(TAG_ITEMOBJ, "");
    }

    public final void setITEMOBJ(String strValue) {
        this.setParamValue(TAG_ITEMOBJ, strValue);
    }
}

