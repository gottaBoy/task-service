/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysUserDR
extends BaseDataEntity {
    public static final String TAG_PSSYSUSERDRID = "PSSYSUSERDRID";
    public static final String TAG_PSSYSUSERDRNAME = "PSSYSUSERDRNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_USERDRTAG = "USERDRTAG";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSSYSUSERDRIDNull() {
        return this.isParamNull(TAG_PSSYSUSERDRID);
    }

    public final String getPSSYSUSERDRID() {
        return this.getParamStringValue(TAG_PSSYSUSERDRID, "");
    }

    public final void setPSSYSUSERDRID(String strValue) {
        this.setParamValue(TAG_PSSYSUSERDRID, strValue);
    }

    public final boolean isPSSYSUSERDRNAMENull() {
        return this.isParamNull(TAG_PSSYSUSERDRNAME);
    }

    public final String getPSSYSUSERDRNAME() {
        return this.getParamStringValue(TAG_PSSYSUSERDRNAME, "");
    }

    public final void setPSSYSUSERDRNAME(String strValue) {
        this.setParamValue(TAG_PSSYSUSERDRNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isUSERDRTAGNull() {
        return this.isParamNull(TAG_USERDRTAG);
    }

    public final String getUSERDRTAG() {
        return this.getParamStringValue(TAG_USERDRTAG, "");
    }

    public final void setUSERDRTAG(String strValue) {
        this.setParamValue(TAG_USERDRTAG, strValue);
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

