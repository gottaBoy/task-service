/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppUtilPage
extends BaseDataEntity {
    public static final String PSAPPUTILPAGENAME_DOWNLOADTMPFILE = "DOWNLOADTMPFILE";
    public static final String PSAPPUTILPAGENAME_LOGIN = "LOGIN";
    public static final String PSAPPUTILPAGENAME_LOGOUT = "LOGOUT";
    public static final String TAG_PSAPPUTILPAGEID = "PSAPPUTILPAGEID";
    public static final String TAG_PSAPPUTILPAGENAME = "PSAPPUTILPAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PAGEURL = "PAGEURL";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";

    public final boolean isPSAPPUTILPAGEIDNull() {
        return this.isParamNull(TAG_PSAPPUTILPAGEID);
    }

    public final String getPSAPPUTILPAGEID() {
        return this.getParamStringValue(TAG_PSAPPUTILPAGEID, "");
    }

    public final void setPSAPPUTILPAGEID(String strValue) {
        this.setParamValue(TAG_PSAPPUTILPAGEID, strValue);
    }

    public final boolean isPSAPPUTILPAGENAMENull() {
        return this.isParamNull(TAG_PSAPPUTILPAGENAME);
    }

    public final String getPSAPPUTILPAGENAME() {
        return this.getParamStringValue(TAG_PSAPPUTILPAGENAME, "");
    }

    public final void setPSAPPUTILPAGENAME(String strValue) {
        this.setParamValue(TAG_PSAPPUTILPAGENAME, strValue);
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

    public final boolean isPAGEURLNull() {
        return this.isParamNull(TAG_PAGEURL);
    }

    public final String getPAGEURL() {
        return this.getParamStringValue(TAG_PAGEURL, "");
    }

    public final void setPAGEURL(String strValue) {
        this.setParamValue(TAG_PAGEURL, strValue);
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
}

