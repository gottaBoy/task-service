/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppUITheme
extends BaseDataEntity {
    public static final String TAG_PSAPPUITHEMEID = "PSAPPUITHEMEID";
    public static final String TAG_PSAPPUITHEMENAME = "PSAPPUITHEMENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_THEMETAG = "THEMETAG";
    public static final String TAG_THEMEPARAMS = "THEMEPARAMS";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_THEMEDESC = "THEMEDESC";

    public final boolean isPSAPPUITHEMEIDNull() {
        return this.isParamNull(TAG_PSAPPUITHEMEID);
    }

    public final String getPSAPPUITHEMEID() {
        return this.getParamStringValue(TAG_PSAPPUITHEMEID, "");
    }

    public final void setPSAPPUITHEMEID(String strValue) {
        this.setParamValue(TAG_PSAPPUITHEMEID, strValue);
    }

    public final boolean isPSAPPUITHEMENAMENull() {
        return this.isParamNull(TAG_PSAPPUITHEMENAME);
    }

    public final String getPSAPPUITHEMENAME() {
        return this.getParamStringValue(TAG_PSAPPUITHEMENAME, "");
    }

    public final void setPSAPPUITHEMENAME(String strValue) {
        this.setParamValue(TAG_PSAPPUITHEMENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isTHEMETAGNull() {
        return this.isParamNull(TAG_THEMETAG);
    }

    public final String getTHEMETAG() {
        return this.getParamStringValue(TAG_THEMETAG, "");
    }

    public final void setTHEMETAG(String strValue) {
        this.setParamValue(TAG_THEMETAG, strValue);
    }

    public final boolean isTHEMEPARAMSNull() {
        return this.isParamNull(TAG_THEMEPARAMS);
    }

    public final String getTHEMEPARAMS() {
        return this.getParamStringValue(TAG_THEMEPARAMS, "");
    }

    public final void setTHEMEPARAMS(String strValue) {
        this.setParamValue(TAG_THEMEPARAMS, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isTHEMEDESCNull() {
        return this.isParamNull(TAG_THEMEDESC);
    }

    public final String getTHEMEDESC() {
        return this.getParamStringValue(TAG_THEMEDESC, "");
    }

    public final void setTHEMEDESC(String strValue) {
        this.setParamValue(TAG_THEMEDESC, strValue);
    }
}

