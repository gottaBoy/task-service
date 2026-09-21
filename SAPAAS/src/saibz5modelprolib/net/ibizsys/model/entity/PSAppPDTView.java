/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppPDTView
extends BaseDataEntity {
    public static final String TAG_PSAPPPDTVIEWID = "PSAPPPDTVIEWID";
    public static final String TAG_PSAPPPDTVIEWNAME = "PSAPPPDTVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSPDTVIEWID = "PSSYSPDTVIEWID";
    public static final String TAG_PSSYSPDTVIEWNAME = "PSSYSPDTVIEWNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSAPPVIEWNAME = "PSAPPVIEWNAME";

    public final boolean isPSAPPPDTVIEWIDNull() {
        return this.isParamNull(TAG_PSAPPPDTVIEWID);
    }

    public final String getPSAPPPDTVIEWID() {
        return this.getParamStringValue(TAG_PSAPPPDTVIEWID, "");
    }

    public final void setPSAPPPDTVIEWID(String strValue) {
        this.setParamValue(TAG_PSAPPPDTVIEWID, strValue);
    }

    public final boolean isPSAPPPDTVIEWNAMENull() {
        return this.isParamNull(TAG_PSAPPPDTVIEWNAME);
    }

    public final String getPSAPPPDTVIEWNAME() {
        return this.getParamStringValue(TAG_PSAPPPDTVIEWNAME, "");
    }

    public final void setPSAPPPDTVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSAPPPDTVIEWNAME, strValue);
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

    public final boolean isPSSYSPDTVIEWIDNull() {
        return this.isParamNull(TAG_PSSYSPDTVIEWID);
    }

    public final String getPSSYSPDTVIEWID() {
        return this.getParamStringValue(TAG_PSSYSPDTVIEWID, "");
    }

    public final void setPSSYSPDTVIEWID(String strValue) {
        this.setParamValue(TAG_PSSYSPDTVIEWID, strValue);
    }

    public final boolean isPSSYSPDTVIEWNAMENull() {
        return this.isParamNull(TAG_PSSYSPDTVIEWNAME);
    }

    public final String getPSSYSPDTVIEWNAME() {
        return this.getParamStringValue(TAG_PSSYSPDTVIEWNAME, "");
    }

    public final void setPSSYSPDTVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSSYSPDTVIEWNAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isPSAPPVIEWIDNull() {
        return this.isParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.getParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWID, strValue);
    }

    public final boolean isPSAPPVIEWNAMENull() {
        return this.isParamNull(TAG_PSAPPVIEWNAME);
    }

    public final String getPSAPPVIEWNAME() {
        return this.getParamStringValue(TAG_PSAPPVIEWNAME, "");
    }

    public final void setPSAPPVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWNAME, strValue);
    }
}

