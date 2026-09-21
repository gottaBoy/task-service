/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppLan
extends BaseDataEntity {
    public static final String TAG_PSAPPLANID = "PSAPPLANID";
    public static final String TAG_PSAPPLANNAME = "PSAPPLANNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSLANGUAGEID = "PSLANGUAGEID";
    public static final String TAG_PSLANGUAGENAME = "PSLANGUAGENAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSAPPLANIDNull() {
        return this.isParamNull(TAG_PSAPPLANID);
    }

    public final String getPSAPPLANID() {
        return this.getParamStringValue(TAG_PSAPPLANID, "");
    }

    public final void setPSAPPLANID(String strValue) {
        this.setParamValue(TAG_PSAPPLANID, strValue);
    }

    public final boolean isPSAPPLANNAMENull() {
        return this.isParamNull(TAG_PSAPPLANNAME);
    }

    public final String getPSAPPLANNAME() {
        return this.getParamStringValue(TAG_PSAPPLANNAME, "");
    }

    public final void setPSAPPLANNAME(String strValue) {
        this.setParamValue(TAG_PSAPPLANNAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.isParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.getParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.setParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.isParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.getParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.setParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSLANGUAGEIDNull() {
        return this.isParamNull(TAG_PSLANGUAGEID);
    }

    public final String getPSLANGUAGEID() {
        return this.getParamStringValue(TAG_PSLANGUAGEID, "");
    }

    public final void setPSLANGUAGEID(String strValue) {
        this.setParamValue(TAG_PSLANGUAGEID, strValue);
    }

    public final boolean isPSLANGUAGENAMENull() {
        return this.isParamNull(TAG_PSLANGUAGENAME);
    }

    public final String getPSLANGUAGENAME() {
        return this.getParamStringValue(TAG_PSLANGUAGENAME, "");
    }

    public final void setPSLANGUAGENAME(String strValue) {
        this.setParamValue(TAG_PSLANGUAGENAME, strValue);
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
}

