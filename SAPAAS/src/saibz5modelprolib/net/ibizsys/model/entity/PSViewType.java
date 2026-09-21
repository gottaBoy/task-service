/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSViewType
extends BaseDataEntity {
    public static final String TAG_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String TAG_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_APPVIEWOBJ = "APPVIEWOBJ";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_VIEWDEID = "VIEWDEID";
    public static final String TAG_VIEWDENAME = "VIEWDENAME";
    public static final String TAG_DEVIEWOBJ = "DEVIEWOBJ";
    public static final String TAG_DEVIEWMODE = "DEVIEWMODE";
    public static final String TAG_EMBEDVIEWFLAG = "EMBEDVIEWFLAG";

    public final boolean isPSVIEWTYPEIDNull() {
        return this.isParamNull(TAG_PSVIEWTYPEID);
    }

    public final String getPSVIEWTYPEID() {
        return this.getParamStringValue(TAG_PSVIEWTYPEID, "");
    }

    public final void setPSVIEWTYPEID(String strValue) {
        this.setParamValue(TAG_PSVIEWTYPEID, strValue);
    }

    public final boolean isPSVIEWTYPENAMENull() {
        return this.isParamNull(TAG_PSVIEWTYPENAME);
    }

    public final String getPSVIEWTYPENAME() {
        return this.getParamStringValue(TAG_PSVIEWTYPENAME, "");
    }

    public final void setPSVIEWTYPENAME(String strValue) {
        this.setParamValue(TAG_PSVIEWTYPENAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isAPPVIEWOBJNull() {
        return this.isParamNull(TAG_APPVIEWOBJ);
    }

    public final String getAPPVIEWOBJ() {
        return this.getParamStringValue(TAG_APPVIEWOBJ, "");
    }

    public final void setAPPVIEWOBJ(String strValue) {
        this.setParamValue(TAG_APPVIEWOBJ, strValue);
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

    public final boolean isVIEWDEIDNull() {
        return this.isParamNull(TAG_VIEWDEID);
    }

    public final String getVIEWDEID() {
        return this.getParamStringValue(TAG_VIEWDEID, "");
    }

    public final void setVIEWDEID(String strValue) {
        this.setParamValue(TAG_VIEWDEID, strValue);
    }

    public final boolean isVIEWDENAMENull() {
        return this.isParamNull(TAG_VIEWDENAME);
    }

    public final String getVIEWDENAME() {
        return this.getParamStringValue(TAG_VIEWDENAME, "");
    }

    public final void setVIEWDENAME(String strValue) {
        this.setParamValue(TAG_VIEWDENAME, strValue);
    }

    public final boolean isDEVIEWOBJNull() {
        return this.isParamNull(TAG_DEVIEWOBJ);
    }

    public final String getDEVIEWOBJ() {
        return this.getParamStringValue(TAG_DEVIEWOBJ, "");
    }

    public final void setDEVIEWOBJ(String strValue) {
        this.setParamValue(TAG_DEVIEWOBJ, strValue);
    }

    public final boolean isDEVIEWMODENull() {
        return this.isParamNull(TAG_DEVIEWMODE);
    }

    public final boolean getDEVIEWMODE() {
        return this.getParamIntValue(TAG_DEVIEWMODE, 0) == 1;
    }

    public final void setDEVIEWMODE(boolean bValue) {
        this.setParamValue(TAG_DEVIEWMODE, bValue ? 1 : 0);
    }

    public final boolean isEMBEDVIEWFLAGNull() {
        return this.isParamNull(TAG_EMBEDVIEWFLAG);
    }

    public final boolean getEMBEDVIEWFLAG() {
        return this.getParamIntValue(TAG_EMBEDVIEWFLAG, 0) == 1;
    }

    public final void setEMBEDVIEWFLAG(boolean bValue) {
        this.setParamValue(TAG_EMBEDVIEWFLAG, bValue ? 1 : 0);
    }
}

